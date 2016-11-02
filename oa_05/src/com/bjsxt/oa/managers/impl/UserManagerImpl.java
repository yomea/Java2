package com.bjsxt.oa.managers.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.managers.UserManager;
import com.bjsxt.oa.model.Person;
import com.bjsxt.oa.model.Role;
import com.bjsxt.oa.model.User;
import com.bjsxt.oa.model.UsersRoles;

public class UserManagerImpl extends AbstractManager implements UserManager {

	public void addOrUpdateUserRole(int userId, int roleId, int orderNo) {
		
		//���ȸ���userId��roleId����UsersRoles����
		UsersRoles ur = findUsersRoles(userId,roleId);
		
		if(ur == null){
			ur = new UsersRoles();
			ur.setOrderNo(orderNo);
			ur.setRole((Role)getHibernateTemplate().load(Role.class, roleId));
			ur.setUser((User)getHibernateTemplate().load(User.class, userId));
			getHibernateTemplate().save(ur);
			return;
		}
		
		//
		ur.setOrderNo(orderNo);
		getHibernateTemplate().update(ur);
	}

	public void addUser(User user, int personId) {
		if(personId == 0){
			throw new SystemException("����ѡ����Ӧ����Ա��Ϣ");
		}
		
		user.setPerson((Person)getHibernateTemplate().load(Person.class, personId));
		
		//���ô���ʱ��
		user.setCreateTime(new Date());
		
		getHibernateTemplate().save(user);
	}

	public void delUser(int userId) {
		getHibernateTemplate().delete(getHibernateTemplate().load(User.class, userId));
	}

	public void delUserRole(int userId, int roleId) {
		getHibernateTemplate().delete(findUsersRoles(userId,roleId));
	}

	public User findUser(int userId) {
		
		return (User)getHibernateTemplate().load(User.class, userId);
	}

	public User login(String username, String password) {
		
		User user = (User)getSession().createQuery("select u from User u where u.username = ?")
			.setParameter(0, username)
			.uniqueResult();
		
		if(user == null){
			throw new SystemException("û������û�");
		}
		
		if(!user.getPassword().equals(password)){
			throw new SystemException("�������");
		}
		
		if(user.getExpireTime() != null){
			
			//����ʱ��
			Calendar now = Calendar.getInstance();
			
			//ʧЧʱ��
			Calendar expireTime = Calendar.getInstance();
			expireTime.setTime(user.getExpireTime());
			
			//���������ʧЧʱ��֮��
			if(now.after(expireTime)){
				throw new SystemException("�û���Ϣ��ʧЧ��");
			}
		}
		return user;
	}

	public List searchUserRoles(int userId) {
		
		return getHibernateTemplate().find("select ur from UsersRoles ur where ur.user.id = ?", userId);
		
	}

	public void updateUser(User user, int personId) {
		if(personId == 0){
			throw new SystemException("����ѡ����Ӧ����Ա��Ϣ");
		}
		
		user.setPerson((Person)getHibernateTemplate().load(Person.class, personId));
		
		getHibernateTemplate().update(user);
	}
	
	private UsersRoles findUsersRoles(int userId,int roleId){
		return (UsersRoles)getSession().createQuery(
			"select ur from UsersRoles ur where ur.role.id = ? and ur.user.id = ?")
			.setParameter(0, roleId)
			.setParameter(1, userId)
			.uniqueResult();		
	}

}
