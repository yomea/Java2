package youth.hong.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import youth.hong.dao.IUserDao;
import youth.hong.entity.Tree;
import youth.hong.entity.User;
import youth.hong.util.DatabaseUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public User getUser(User user) {
		Connection conn = DatabaseUtil.getConn();
		List<Object> list = new ArrayList<Object>();
		String sql = "select id, username, password from t_user where username=? and password=?";
		list.add(user.getUsername());
		list.add(user.getPassword());
		List<User> users = DatabaseUtil.$(conn, sql, list, User.class);
		if(users == null || users.size() < 1) {
			return null;
			
		}
		return (User)users.get(0);
	}

	@Override
	public List<Tree> findTree(int id) {
		Connection conn = DatabaseUtil.getConn();
		List<Object> params = new ArrayList<Object>();
		List<Tree> list = null;
		String sql = "select id, text, state, url from t_tree where pid = ?";
		params.add(id);
		list = DatabaseUtil.$(conn, sql, params, Tree.class);
		if(list == null || list.size() < 1) {
			return null;
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		List<Tree> trees = dao.findTree(0);
		System.out.println(trees);
		JSONArray json = JSONArray.fromObject(trees);
		System.out.println(json);
	}
	
	

}
