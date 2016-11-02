package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;

import junit.framework.TestCase;

/**
 * 创建jbpm流程所需要的一大堆表
 * @author May
 *
 */
public class Jbpm_01_CreateTable extends TestCase {
	
	//创建表格
	public void testCreateTable(){
		JbpmConfiguration.getInstance().createSchema();
	}
}
