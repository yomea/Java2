package com.bjsxt.jbpm;

import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import junit.framework.TestCase;

/**
 * ����ÿ���˵�ǰ��Ҫ�����Ĺ���
 * @author May
 *
 */
public class Jbpm_07_SearchMyTaskList extends TestCase {
static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	public void testSearchMyTaskList(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());
		
		//�����������ĵ�
		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("�������ĵ��У�");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		List<?> tasks1 = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("���ĵ��ĵ��У�");
		for (Iterator<?> iter = tasks1.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		
		List<?> tasks2 = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("������ĵ��У�");
		for (Iterator<?> iter = tasks2.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		
		context.close();
	}
}
