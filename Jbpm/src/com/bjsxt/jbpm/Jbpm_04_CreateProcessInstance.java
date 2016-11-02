package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

import junit.framework.TestCase;

//��������ʵ������������ʵ���빫�Ļ����
public class Jbpm_04_CreateProcessInstance extends TestCase {
	
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testCreateProcessInstance(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		//�����ݿ��м���ProcessDefinition����
		ProcessDefinition definition = context.getGraphSession().findLatestProcessDefinition("�ĵ���������");
		
		//�������д���һ������ʵ��
		ProcessInstance processInstance = new ProcessInstance(definition);
		
		//�洢����ʵ��
		context.save(processInstance);
		
		//���ع���
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		//������ʵ��������
		doc.setProcessIntanceId(processInstance.getId());
		
		//�󶨹��ĵ�����ʵ��(ContextInstance�൱��һ������������)
		processInstance.getContextInstance().createVariable("document", doc.getId());
		
		context.close();
	}
}
