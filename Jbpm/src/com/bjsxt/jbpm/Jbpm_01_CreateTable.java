package com.bjsxt.jbpm;

import org.jbpm.JbpmConfiguration;

import junit.framework.TestCase;

/**
 * ����jbpm��������Ҫ��һ��ѱ�
 * @author May
 *
 */
public class Jbpm_01_CreateTable extends TestCase {
	
	//�������
	public void testCreateTable(){
		JbpmConfiguration.getInstance().createSchema();
	}
}
