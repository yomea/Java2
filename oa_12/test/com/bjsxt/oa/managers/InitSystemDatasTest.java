package com.bjsxt.oa.managers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class InitSystemDatasTest extends TestCase {
	private static BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	public void testAddOrUpdateInitDatas() {
		InitSystemDatas init = (InitSystemDatas)factory.getBean("initSystemDatas");
		init.addOrUpdateInitDatas("init_datas.xml");
	}

}
