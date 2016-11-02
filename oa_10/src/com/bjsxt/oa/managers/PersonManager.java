package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Person;

public interface PersonManager {
	
	/**
	 * �������е���Ա��Ϣ
	 * @return
	 */
	public PagerModel searchPersons();
	
	/**
	 * ����ĳ�������µ���Ա�б�
	 * @param orgId
	 * @return
	 */
	public PagerModel searchPersons(int orgId);
	
	/**
	 * �����ض���Ա����Ϣ
	 * @param personId
	 * @return
	 */
	public Person findPerson(int personId);
	
	/**
	 * �����Ա��Ϣ
	 * orgId������Ϊ0����һ����Ա��������ĳ������
	 * @param person
	 * @param orgId 
	 */
	public void addPerson(Person person,int orgId);
	
	/**
	 * ɾ����Ա����Ϣ
	 * @param personId
	 */
	public void delPerson(int personId);
}
