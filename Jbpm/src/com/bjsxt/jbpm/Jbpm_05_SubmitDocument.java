package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;

import junit.framework.TestCase;

/**
 * �ύ����
 * @author May
 *
 */
public class Jbpm_05_SubmitDocument extends TestCase{
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testSubmitDocument(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		//���ع���ʵ��
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		ProcessInstance processInstance = context.getProcessInstance(doc.getProcessIntanceId());
		
		//��������ʵ��������һ��
		processInstance.getRootToken().signal();
		
		context.close();
	}
}
