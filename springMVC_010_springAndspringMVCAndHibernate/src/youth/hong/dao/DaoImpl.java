package youth.hong.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import youth.hong.entity.User;

@Repository
public class DaoImpl implements Dao {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void add(User user) {
		hibernateTemplate.saveOrUpdate(user);
		System.out.println("add success!!!");
		
	}

	@Override
	public List<User> showUsers() {
		String queryString = "from User";
		List<User> users = (List<User>) hibernateTemplate.find(queryString);
		
		return users;
	}

	@Override
	public void deleteUser(int id) {
		
		User user = new User();
		
		user.setId(id);
		
		hibernateTemplate.delete(user);
	}

	@Override
	public void updateuser(User user) {
		
		hibernateTemplate.update(user);
		
	}

	@Override
	public User loadUserById(int id) {
		
		User user = hibernateTemplate.load(User.class, id);
		System.out.println(user);
		return user;
	}

}
