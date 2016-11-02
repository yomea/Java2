package youth.hong;

import java.util.List;

public interface UserServiceDao {
	

	public UserDao getUserDao();

	public void setUserDao(UserDao userDao);
	
	public boolean save(User user);
	
	public boolean isExists(User user);
	
	public List<User> getUsers();
	
	public User loadById(int id);

}
