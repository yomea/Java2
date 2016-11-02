package com.bjsxt.oa.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.Session;

public class OrgTest5 extends TestCase {
	public void testUpdateParentOrg(){
		Session session = HibernateUtils.getSession();
		try{
			session.beginTransaction();
			
			
			Orgnization org1 = new Orgnization();
			org1.setId(1);
			org1.setName("¸¸»ú¹¹");
			session.update(org1);
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	
}
