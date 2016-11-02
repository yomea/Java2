package com.bjsxt.jbpm;

import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * �����ݿ��д����������ݣ���ȻӦ�ý�������ʵ��
 * @author May
 *
 */
public class Jbpm_03_CreateDocument extends TestCase {
	public void testCreateDocument(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			Document doc = new Document();
			doc.setTitle("���Թ���");
			doc.setContent("���Թ��ĵ�����");
			doc.setCreator("��һ");
			session.save(doc);
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
