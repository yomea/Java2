package com.bjsxt.oa.model;

import org.hibernate.Session;

import junit.framework.TestCase;

public class OrgTest extends TestCase {
	public void testSaveOrg(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			Orgnization org1 = new Orgnization();
			org1.setName("org1");
			session.save(org1);
			
			Orgnization org2 = new Orgnization();
			org2.setName("org2");
			org2.setParent(org1);
			session.save(org2);
			
			Orgnization org3 = new Orgnization();
			org3.setName("org3");
			org3.setParent(org1);
			session.save(org3);
			
			Orgnization org4 = new Orgnization();
			org4.setName("org4");
			org4.setParent(org1);
			session.save(org4);
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testLoadOrg(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			Orgnization org2 = (Orgnization)session.load(Orgnization.class, 2);
			System.out.println(org2.getName()+","+org2.getParent().getName());
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
