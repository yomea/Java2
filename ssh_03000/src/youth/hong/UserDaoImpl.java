package youth.hong;

import java.util.List;



public class UserDaoImpl extends SuperDao implements UserDao {
	
	
	
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public boolean isExists(User user) {
		String sql = "from User u where u.username=?";
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) this.getHibernateTemplate().find(sql, user.getUsername());
		if(users.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		String sql = "from User";
		return (List<User>) this.getHibernateTemplate().find(sql);
	}

	@Override
	public User loadById(int id) {
		
		User user = (User)this.getHibernateTemplate().load(User.class,id);
		//System.out.println(user);
		return user;
	}

}
