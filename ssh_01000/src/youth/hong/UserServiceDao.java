package youth.hong;


public interface UserServiceDao {
	

	public UserDao getUserDao();

	public void setUserDao(UserDao userDao);
	
	public boolean save(User user);
	
	public boolean isExists(User user);

}
