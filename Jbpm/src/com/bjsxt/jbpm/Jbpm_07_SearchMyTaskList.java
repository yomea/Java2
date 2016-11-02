package com.bjsxt.jbpm;

import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import junit.framework.TestCase;

/**
 * 查找每个人但前需要审批的公文
 * @author May
 *
 */
public class Jbpm_07_SearchMyTaskList extends TestCase {
static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testSearchMyTaskList(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		//查找张三的文档
		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("张三");
		System.err.println("张三的文档有：");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		List<?> tasks1 = context.getTaskMgmtSession().findTaskInstances("李四");
		System.err.println("李四的文档有：");
		for (Iterator<?> iter = tasks1.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		
		List<?> tasks2 = context.getTaskMgmtSession().findTaskInstances("王五");
		System.err.println("王五的文档有：");
		for (Iterator<?> iter = tasks2.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		
		context.close();
	}
}
