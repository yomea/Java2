package com.bjsxt.oa.managers.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.managers.PersonManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.model.Organization;
import com.bjsxt.oa.model.Person;

public class PersonManagerImpl extends AbstractManager implements
		PersonManager {

	public void addPerson(Person person, int orgId) {

		if(orgId == 0){
			throw new SystemException("机构不允许为空！");
		}
		
		person.setOrg(
				(Organization)getHibernateTemplate().load(Organization.class, orgId)
			);
		getHibernateTemplate().save(person);
	}

	public void delPerson(int personId) {
		getHibernateTemplate().delete(
				getHibernateTemplate().load(Person.class, personId)
			);
	}

	public Person findPerson(int personId) {
		return (Person)getHibernateTemplate().load(Person.class, personId);
	}

	public PagerModel searchPersons() {
		return searchPaginated("from Person");
	}

	public PagerModel searchPersons(int orgId) {
		return searchPaginated("select p from Person p where p.org.id = "+orgId);
	}

}
