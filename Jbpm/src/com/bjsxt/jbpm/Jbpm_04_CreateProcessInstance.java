package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

import junit.framework.TestCase;

//创建流程实例，并将流程实例与公文互相绑定
public class Jbpm_04_CreateProcessInstance extends TestCase {
	
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testCreateProcessInstance(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		//从数据库中加载ProcessDefinition对象
		ProcessDefinition definition = context.getGraphSession().findLatestProcessDefinition("文档测试流程");
		
		//从流程中创建一个流程实例
		ProcessInstance processInstance = new ProcessInstance(definition);
		
		//存储流程实例
		context.save(processInstance);
		
		//加载公文
		Document doc = (Document)context.getSession().load(Document.class, 1);
		
		//绑定流程实例到公文
		doc.setProcessIntanceId(processInstance.getId());
		
		//绑定公文到流程实例(ContextInstance相当于一个变量的容器)
		processInstance.getContextInstance().createVariable("document", doc.getId());
		
		context.close();
	}
}
