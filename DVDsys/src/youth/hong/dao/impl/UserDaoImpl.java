package youth.hong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import youth.hong.dao.UserDao;
import youth.hong.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean saveUser(User user) {
		String sql = "insert into users(uname, upass, type) values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delUser(int id) {
		String sql = "delete from users where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update users set uname=?, upass=?, type=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		params.add(user.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public User queryUser(User user) {
		List<User> users = new ArrayList<User>();
		String sql = "select id, uname, upass, type from users where uname=? and upass=? and type=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		Class<User> clsUser = User.class;
		users = this.operQuery(sql, params, clsUser);
		if(users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
