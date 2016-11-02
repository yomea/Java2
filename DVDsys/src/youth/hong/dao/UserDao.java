package youth.hong.dao;

import youth.hong.entity.User;

public interface UserDao {
	
	public boolean saveUser(User user);
	
	public boolean delUser(int id);
	
	public boolean updateUser(User user);
	
	public User queryUser(User user);
}
