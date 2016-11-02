package youth.hong;

public class UserServiceImpl implements UserServiceDao {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//@Transactional
	public boolean save(User user) {
		boolean t = isExists(user);
		if(t) {
			return t;
		}
		userDao.save(user);
		return false;
	}

	@Override
	public boolean isExists(User user) {
		return userDao.isExists(user);
	}
	
}
