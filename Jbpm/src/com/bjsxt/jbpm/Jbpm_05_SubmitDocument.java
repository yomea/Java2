package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;

import junit.framework.TestCase;

/**
 * 提交公文
 * @author May
 *
 */
public class Jbpm_05_SubmitDocument extends TestCase{
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testSubmitDocument(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		//加载公文实例
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		ProcessInstance processInstance = context.getProcessInstance(doc.getProcessIntanceId());
		
		//触发流程实例走向下一步
		processInstance.getRootToken().signal();
		
		context.close();
	}
}
