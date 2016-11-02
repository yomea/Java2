package com.bjsxt.oa.managers.impl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.oa.managers.WorkflowManager;
import com.bjsxt.oa.model.Document;
import com.bjsxt.oa.model.Workflow;

public class WorkflowManagerImpl extends HibernateDaoSupport implements
		WorkflowManager {

	private JbpmConfiguration jbpmConfiguration;
	
	public long addProcessInstance(String workflowName, int documentId) {
		
		JbpmContext context = getContext();
		
		//��JBPM�м������̶���
		ProcessDefinition definition = context.getGraphSession().findLatestProcessDefinition(workflowName);
		
		ProcessInstance instance = new ProcessInstance(definition);
		
		//�����ı�ʶ�󶨵�����ʵ��
		instance.getContextInstance().createVariable("document", documentId);
		
		//�洢����ʵ������Ϣ
		context.save(instance);
		
		return instance.getId();
	}

	public void delProcessInstance(long processInstanceId) {
		
		JbpmContext context = getContext();
		
		//ɾ������ʵ��
		context.getGraphSession().deleteProcessInstance(processInstanceId);
	}

	public void delWorkflow(int workflowId) {
		
		//��OA��ɾ�����̵Ķ���
		Workflow workflow = (Workflow)getHibernateTemplate().load(Workflow.class, workflowId);
		getHibernateTemplate().delete(workflow);
		
		//��JBPM��ɾ�����̶���
		//JBPM�����̶��尴�汾���й���������ͬһ��ʱ�̣����ܴ���ͬһ�����̶���Ķ����ͬ�İ汾
		//�����Ҫ����ɾ������Ӧ��ɾ�����еİ汾
		
		//���Ҷ�Ӧ���̶�������а汾
		List defs = getContext().getGraphSession().findAllProcessDefinitionVersions(workflow.getName());
		for (Iterator iter = defs.iterator(); iter.hasNext();) {
			ProcessDefinition def = (ProcessDefinition) iter.next();
			getContext().getGraphSession().deleteProcessDefinition(def);
		}
	}

	public void deployProcessDefinition(byte[] processDefinition,
			byte[] processImage) {
		
		//ͨ��byte[]����ProcessDefinition����
		ProcessDefinition def = 
			ProcessDefinition.parseXmlInputStream(
					new ByteArrayInputStream(processDefinition)); 
		
		//�����̶����ļ�����JBPM
		getContext().deployProcessDefinition(def);
		
		//���Ȳ���һ��Workflow�����Ƿ��Ѿ�����
		Workflow workflow = (Workflow)getSession()
				.createQuery("select w from Workflow w where w.name = ? ")
				.setParameter(0, def.getName())
				.uniqueResult();
		
		//���������δ���ڣ��򴴽�
		if(workflow == null){
			workflow = new Workflow();
			workflow.setName(def.getName());
			workflow.setProcessDefinition(processDefinition);
			workflow.setProcessImage(processImage);
			getHibernateTemplate().save(workflow);
			return;
		}
		
		//��������Ѿ����ڣ������
		workflow.setName(def.getName());
		workflow.setProcessDefinition(processDefinition);
		workflow.setProcessImage(processImage);
		getHibernateTemplate().update(workflow);
	}

	public Workflow findWorkflow(int workflowId) {
		return (Workflow)getHibernateTemplate().load(Workflow.class, workflowId);
	}

	public String flowToNextStep(String username, long processInstanceId,
			String transitionName) {
		
		JbpmContext context = getContext();
		String status = null;
		
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//��ǰ�ڵ�
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//��ʼ�ڵ�
		String startNodeName = instance.getProcessDefinition().getStartState().getName();

		//���������ʼ�ڵ㣬��Ϊ��ʼ�ڵ㲻����κ���������������Ὣ���������κ��ˣ�
		if(currentNodeName.equals(startNodeName)){
			//��Ҫʹ������ʵ����signal()������������������һ��������
			instance.getRootToken().signal(transitionName);
		}else{
		
			//�����ҳ��û��ĵ�ǰ����
			List tasks = context.getTaskMgmtSession().findTaskInstances(username);
			for (Iterator iter = tasks.iterator(); iter.hasNext();) {
				TaskInstance taskInstance = (TaskInstance) iter.next();
				if(taskInstance.getProcessInstance().getId() == processInstanceId){
					
					//����ǵ�ǰ�ĵ���Ӧ��������Ҫ����������񣬴Ӷ�������������һ�����ƶ���
					taskInstance.end(transitionName);
					break;
				}
			}
		}
		
		//�����ĵ�ǰ�����ڵ���Ϊ״̬��Ϣ����
		status = instance.getRootToken().getNode().getName();
		
		//�жϵ�ǰ��״̬�Ƿ��Ѿ�������
		if(instance.hasEnded()){
			status = Document.STATUS_END;
		}
		
		return status;
	}

	public List searchAllWorkflows() {
		return getHibernateTemplate().find("from Workflow");
	}

	
	public List searchApprovingDocuments(String username) {
		
		JbpmContext context = getContext();
		
		List docIds = new ArrayList();
		
		//���Ȼ����ת���û��������б�
		List tasks = context.getTaskMgmtSession().findTaskInstances(username);
		for (Iterator iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//�������Ӧ������ʵ������ù��ı�ʶ
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);  
		}
		
		return docIds;
	}

	//��һ��������Щ����
	public List searchNextTransitions(long processInstanceId) {
		
		JbpmContext context = getContext();
		
		List transitions = new ArrayList();
		
		//��������ʵ����ʶ��������ʵ��
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//��������ʵ������õ�ǰ�Ľڵ㣬�Ӷ��õ��ڵ�ǰ�ڵ�������Щ����
		List nextSteps = instance.getRootToken().getNode().getLeavingTransitions();
		for (Iterator iter = nextSteps.iterator(); iter.hasNext();) {
			
			Transition transition = (Transition) iter.next();
			transitions.add(transition.getName());
		}
		
		
		return transitions;
	}
	
	/**
	 * ��ȡJbpmContext������Ҫ��JbpmContext��session����Ϊ��ǰ��session����
	 * @return
	 */
	private JbpmContext getContext(){
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSession(getSession());
		return context;
	}

	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

}
