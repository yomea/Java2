package youth.hong.dao;

import youth.hong.entity.Person;
import youth.hong.pager.Pager;

public interface PersonDao {
	
	/**
	 * �������е���Ա��Ϣ
	 * @return
	 */
	public Pager<Person> searchPersons();
	
	/**
	 * ����ĳ�������µ���Ա�б�
	 * @param orgId
	 * @return
	 */
	public Pager<Person> searchPersons(int orgId);
	
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
