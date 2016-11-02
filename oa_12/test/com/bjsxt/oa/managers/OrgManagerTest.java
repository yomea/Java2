package com.bjsxt.oa.managers;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.oa.managers.OrgManager;
import com.bjsxt.oa.model.Organization;

public class OrgManagerTest extends TestCase {

	private static BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	
	public void testAddOrg() {
		OrgManager orgManager = (OrgManager)factory.getBean("orgManager");
		Organization org = new Organization();
		org.setName("���Ի���");
		org.setDescription("kkkkk");
		
		orgManager.addOrg(org, 0);
	}

	public void testDelOrg() {
		fail("Not yet implemented");
	}

	public void testUpdateOrg() {
		fail("Not yet implemented");
	}

	public void testFindOrg() {
		fail("Not yet implemented");
	}

	public void testFindOrgs() {
		fail("Not yet implemented");
	}

}
