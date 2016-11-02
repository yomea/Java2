package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;

import junit.framework.TestCase;

public class Jbpm_02_DeployProcessDefinition extends TestCase {
	//创建jbpm的配置对象
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	//定义流程，告诉jbpm有个流程，这里就是只那个叫文档测试流程的流程，数据库的流程定义表中会储存它
	public void testDeployProcessDefinition(){
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("process.xml");
		
		//context对象类似于hibernate session对象的功能
		JbpmContext context = jbpmConfiguration.createJbpmContext();

		try{
			context.deployProcessDefinition(processDefinition);
		}finally{
			
			//context对象需要关闭
			context.close();
		}
		
	}
}
