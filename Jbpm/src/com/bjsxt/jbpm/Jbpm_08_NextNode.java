package com.bjsxt.jbpm;

import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import junit.framework.TestCase;

public class Jbpm_08_NextNode extends TestCase {
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	//张三审批
	public void testFlowNextNode(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("张三");
		System.err.println("张三的文档有：");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//依次对张三的公文进行提交
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//张三已经审批结束，继续提交，这将触发流程继续向下流动！
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"已被审批完成");
		}
		
		context.close();
	}
	
	//李四审批
	public void testFlowNextNode2(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("李四");
		System.err.println("李四的文档有：");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//依次对李四的公文进行提交
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//李四已经审批结束，继续提交，这将触发流程继续向下流动！
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"已被审批完成");
		}
		
		context.close();
	}
	
	//王五审批
	public void testFlowNextNode3(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("王五");
		System.err.println("王五的文档有：");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//依次对王五的公文进行提交
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//王五已经审批结束，继续提交，这将触发流程继续向下流动！
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"已被审批完成");
		}
		
		context.close();
	}
}
