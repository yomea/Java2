package com.bjsxt.oa.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;

public class OrgTest4 extends TestCase {
	public void testSaveOrg(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			
			Organization org1 = new Organization();
			org1.setName("org1");
			session.save(org1);
			
			Organization org2 = new Organization();
			org2.setName("org2");
			org2.setParent(org1);
			session.save(org2);
			
			Organization org3 = new Organization();
			org3.setName("org3");
			org3.setParent(org1);
			session.save(org3);
			
			Organization org4 = new Organization();
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
	
	public void testLoadOrg_01(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			//parent --> child
			Organization org1 = (Organization)session.load(Organization.class, 1);
			System.out.println(org1.getName()+" has children:");
			Set set = org1.getChildren();
			for (Iterator iter = set.iterator(); iter.hasNext();) {
				Organization org = (Organization) iter.next();
				System.out.print(org.getName());
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testLoadOrg_02(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			//child --> parent
			Organization org2 = (Organization)session.load(Organization.class, 2);
			System.out.println(org2.getName()+","+org2.getParent().getName());
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
