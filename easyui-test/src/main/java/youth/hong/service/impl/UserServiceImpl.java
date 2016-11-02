package youth.hong.service.impl;

import java.util.ArrayList;
import java.util.List;

import youth.hong.dao.IUserDao;
import youth.hong.dao.impl.UserDaoImpl;
import youth.hong.entity.Tree;
import youth.hong.entity.User;
import youth.hong.message.Message;
import youth.hong.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
		
	}

	@Override
	public Message<User> getUser(User user) {
		User u = userDao.getUser(user);
		List<User> list = null;
		boolean success = false;
		if(u != null) {
			success = true;
			list = new ArrayList<User>();
			list.add(u);
			
		}
		Message<User> messager = new Message<User>(success, list);
		return messager;
	}

	@Override
	public List<Tree> findTree(int id) {
		List<Tree> trees = userDao.findTree(id);
		
		return trees;
	}
	
}
