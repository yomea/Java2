package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;

import junit.framework.TestCase;

public class Jbpm_09_ProcessInstanceIsEnded extends TestCase {
static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	//测试某个流程实例是否已经结束
	public void testHasEnded(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		ProcessInstance processInstance = context.getProcessInstance(doc.getProcessIntanceId());
		
		System.err.println("流程已结束？ - "+processInstance.hasEnded());
		
		context.close();
	}
}
