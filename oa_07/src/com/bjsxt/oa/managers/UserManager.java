package com.bjsxt.oa.managers;

import java.util.List;

import com.bjsxt.oa.model.User;

public interface UserManager {
	
	/**
	 * 添加用户信息
	 * @param user
	 * @param personId
	 */
	public void addUser(User user,int personId);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @param personId
	 */
	public void updateUser(User user,int personId);
	
	/**
	 * 删除用户信息
	 * @param userId
	 */
	public void delUser(int userId);
	
	/**
	 * 查找特定的用户
	 * @param userId
	 * @return
	 */
	public User findUser(int userId);
	
	/**
	 * 查询用户拥有的所有的角色
	 * @param userId 用户ID
	 * @return UsersRoles对象的集合
	 */
	public List searchUserRoles(int userId);
	
	/**
	 * 添加或更新用户拥有的角色，如果用户[userId]已经拥有角色[roleId]，
	 * 则更新其优先级[orderNo]，否则给用户分配相应的角色，并设置优先级
	 * @param userId
	 * @param roleId
	 * @param orderNo
	 */
	public void addOrUpdateUserRole(int userId,int roleId,int orderNo);
	
	/**
	 * 删除分配给用户的角色（关联）
	 * @param userId
	 * @param roleId
	 */
	public void delUserRole(int userId,int roleId);
	
	/**
	 * 用户执行登陆操作
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
}
