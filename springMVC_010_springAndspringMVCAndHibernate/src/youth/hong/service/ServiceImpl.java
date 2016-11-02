package youth.hong.service;

import java.util.List;

import javax.annotation.Resource;

import youth.hong.dao.Dao;
import youth.hong.entity.User;

//@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Resource(name="daoImpl")
	private Dao dao;
	
	@Override
	//@Transactional
	public void add(User user) {
		dao.add(user);
	}

	@Override
	public List<User> showUsers() {
		return dao.showUsers();
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
		
	}

	@Override
	public void updateuser(User user) {
		dao.updateuser(user);
		
	}

	@Override
	public User loadUserById(int id) {
		return dao.loadUserById(id);
	}

}
