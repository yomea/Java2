package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;

import junit.framework.TestCase;

public class Jbpm_02_DeployProcessDefinition extends TestCase {
	//����jbpm�����ö���
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	//�������̣�����jbpm�и����̣��������ֻ�Ǹ����ĵ��������̵����̣����ݿ�����̶�����лᴢ����
	public void testDeployProcessDefinition(){
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("process.xml");
		
		//context����������hibernate session����Ĺ���
		JbpmContext context = jbpmConfiguration.createJbpmContext();

		try{
			context.deployProcessDefinition(processDefinition);
		}finally{
			
			//context������Ҫ�ر�
			context.close();
		}
		
	}
}
