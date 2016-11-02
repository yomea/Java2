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
		
		//从JBPM中加载流程定义
		ProcessDefinition definition = context.getGraphSession().findLatestProcessDefinition(workflowName);
		
		ProcessInstance instance = new ProcessInstance(definition);
		
		//将公文标识绑定到流程实例
		instance.getContextInstance().createVariable("document", documentId);
		
		//存储流程实例的信息
		context.save(instance);
		
		return instance.getId();
	}

	public void delProcessInstance(long processInstanceId) {
		
		JbpmContext context = getContext();
		
		//删除流程实例
		context.getGraphSession().deleteProcessInstance(processInstanceId);
	}

	public void delWorkflow(int workflowId) {
		
		//在OA中删除流程的定义
		Workflow workflow = (Workflow)getHibernateTemplate().load(Workflow.class, workflowId);
		getHibernateTemplate().delete(workflow);
		
		//在JBPM中删除流程定义
		//JBPM对流程定义按版本进行管理，所以在同一个时刻，可能存在同一个流程定义的多个不同的版本
		//如果需要对其删除，则应该删除所有的版本
		
		//查找对应流程定义的所有版本
		List defs = getContext().getGraphSession().findAllProcessDefinitionVersions(workflow.getName());
		for (Iterator iter = defs.iterator(); iter.hasNext();) {
			ProcessDefinition def = (ProcessDefinition) iter.next();
			getContext().getGraphSession().deleteProcessDefinition(def);
		}
	}

	public void deployProcessDefinition(byte[] processDefinition,
			byte[] processImage) {
		
		//通过byte[]创建ProcessDefinition对象
		ProcessDefinition def = 
			ProcessDefinition.parseXmlInputStream(
					new ByteArrayInputStream(processDefinition)); 
		
		//将流程定义文件部署到JBPM
		getContext().deployProcessDefinition(def);
		
		//首先查找一下Workflow对象是否已经存在
		Workflow workflow = (Workflow)getSession()
				.createQuery("select w from Workflow w where w.name = ? ")
				.setParameter(0, def.getName())
				.uniqueResult();
		
		//如果流程尚未存在，则创建
		if(workflow == null){
			workflow = new Workflow();
			workflow.setName(def.getName());
			workflow.setProcessDefinition(processDefinition);
			workflow.setProcessImage(processImage);
			getHibernateTemplate().save(workflow);
			return;
		}
		
		//如果流程已经存在，则更新
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
		
		//当前节点
		String currentNodeName = instance.getRootToken().getNode().getName();
		
		//起始节点
		String startNodeName = instance.getProcessDefinition().getStartState().getName();

		//如果是在起始节点，因为起始节点不会跟任何人相关联（即不会将任务分配给任何人）
		if(currentNodeName.equals(startNodeName)){
			//需要使用流程实例的signal()方法来触发流程向下一步流动！
			instance.getRootToken().signal(transitionName);
		}else{
		
			//首先找出用户的当前任务
			List tasks = context.getTaskMgmtSession().findTaskInstances(username);
			for (Iterator iter = tasks.iterator(); iter.hasNext();) {
				TaskInstance taskInstance = (TaskInstance) iter.next();
				if(taskInstance.getProcessInstance().getId() == processInstanceId){
					
					//这就是当前文档对应的任务，需要结束这个任务，从而触发流程向下一步骤移动！
					taskInstance.end(transitionName);
					break;
				}
			}
		}
		
		//将公文当前所处节点作为状态信息返回
		status = instance.getRootToken().getNode().getName();
		
		//判断当前的状态是否已经结束！
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
		
		//首先获得流转到用户的任务列表
		List tasks = context.getTaskMgmtSession().findTaskInstances(username);
		for (Iterator iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//根据其对应的流程实例，获得公文标识
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			docIds.add(docId);  
		}
		
		return docIds;
	}

	//下一步都有哪些流向？
	public List searchNextTransitions(long processInstanceId) {
		
		JbpmContext context = getContext();
		
		List transitions = new ArrayList();
		
		//根据流程实例标识查找流程实例
		ProcessInstance instance = context.getProcessInstance(processInstanceId);
		
		//根据流程实例，获得当前的节点，从而得到在当前节点下有哪些流向
		List nextSteps = instance.getRootToken().getNode().getLeavingTransitions();
		for (Iterator iter = nextSteps.iterator(); iter.hasNext();) {
			
			Transition transition = (Transition) iter.next();
			transitions.add(transition.getName());
		}
		
		
		return transitions;
	}
	
	/**
	 * 获取JbpmContext对象，需要将JbpmContext的session设置为当前的session对象
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
