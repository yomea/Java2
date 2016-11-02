package com.bjsxt.jbpm;

import java.util.Iterator;
import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import junit.framework.TestCase;

public class Jbpm_08_NextNode extends TestCase {
	static JbpmConfiguration jbpmConfiguration = JbpmConfiguration.getInstance(); 
	
	//��������
	public void testFlowNextNode(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("�������ĵ��У�");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//���ζ������Ĺ��Ľ����ύ
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//�����Ѿ����������������ύ���⽫�������̼�������������
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"�ѱ��������");
		}
		
		context.close();
	}
	
	//��������
	public void testFlowNextNode2(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("���ĵ��ĵ��У�");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//���ζ����ĵĹ��Ľ����ύ
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//�����Ѿ����������������ύ���⽫�������̼�������������
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"�ѱ��������");
		}
		
		context.close();
	}
	
	//��������
	public void testFlowNextNode3(){
		
		JbpmContext context = jbpmConfiguration.createJbpmContext();
		context.setSessionFactory(HibernateUtils.getSessionFactory());

		List<?> tasks = context.getTaskMgmtSession().findTaskInstances("����");
		System.err.println("������ĵ��У�");
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId);
		}
		
		//���ζ�����Ĺ��Ľ����ύ
		for (Iterator<?> iter = tasks.iterator(); iter.hasNext();) {
			TaskInstance taskInstance = (TaskInstance) iter.next();
			
			//�����Ѿ����������������ύ���⽫�������̼�������������
			taskInstance.end();
			
			Integer docId = (Integer)taskInstance.getProcessInstance().getContextInstance().getVariable("document");
			System.err.println(docId+"�ѱ��������");
		}
		
		context.close();
	}
}
