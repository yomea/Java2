package youth.hong.dao;

import youth.hong.entity.Person;
import youth.hong.pager.Pager;

public interface PersonDao {
	
	/**
	 * 搜索所有的人员信息
	 * @return
	 */
	public Pager<Person> searchPersons();
	
	/**
	 * 搜索某个机构下的人员列表
	 * @param orgId
	 * @return
	 */
	public Pager<Person> searchPersons(int orgId);
	
	/**
	 * 查找特定人员的信息
	 * @param personId
	 * @return
	 */
	public Person findPerson(int personId);
	
	/**
	 * 添加人员信息
	 * orgId不允许为0，即一个人员必须属于某个机构
	 * @param person
	 * @param orgId 
	 */
	public void addPerson(Person person,int orgId);
	
	/**
	 * 删除人员的信息
	 * @param personId
	 */
	public void delPerson(int personId);
}
