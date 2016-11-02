package com.bjsxt.oa.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;

public class OrgTest2 extends TestCase {
	public void testSaveOrg(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			
			Set set = new HashSet();
			Orgnization org2 = new Orgnization();
			org2.setName("org2");
			session.save(org2);
			set.add(org2);
			
			Orgnization org3 = new Orgnization();
			org3.setName("org3");
			session.save(org3);
			set.add(org3);
			
			Orgnization org4 = new Orgnization();
			org4.setName("org4");
			session.save(org4);
			set.add(org4);
			
			Orgnization org1 = new Orgnization();
			org1.setName("org1");
			org1.setChildren(set);
			session.save(org1);
			
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
			
			Orgnization org1 = (Orgnization)session.load(Orgnization.class, 4);
			System.out.println(org1.getName()+" has children:");
			Set set = org1.getChildren();
			for (Iterator iter = set.iterator(); iter.hasNext();) {
				Orgnization org = (Orgnization) iter.next();
				System.out.print(org.getName());
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
