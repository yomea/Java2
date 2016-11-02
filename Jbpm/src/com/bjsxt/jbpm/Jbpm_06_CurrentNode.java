package com.bjsxt.jbpm;

import junit.framework.TestCase;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;

//查看文档的当前位置
public class Jbpm_06_CurrentNode extends TestCase{
	
static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testCurrentNode(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		ProcessInstance processInstance = context.getProcessInstance(doc.getProcessIntanceId());
		
		//当前节点名称？
		System.err.println(processInstance.getRootToken().getNode().getName());

		context.close();
	}
}
