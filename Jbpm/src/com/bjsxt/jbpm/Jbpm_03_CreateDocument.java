package com.bjsxt.jbpm;

import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * 在数据库中创建公文数据，当然应该叫做公文实例
 * @author May
 *
 */
public class Jbpm_03_CreateDocument extends TestCase {
	public void testCreateDocument(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			Document doc = new Document();
			doc.setTitle("测试公文");
			doc.setContent("测试公文的内容");
			doc.setCreator("赵一");
			session.save(doc);
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
