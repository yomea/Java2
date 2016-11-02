package youth.hong.service;

import youth.hong.dao.IUsersDao;
import youth.hong.dao.UsersDaoImpl;
import youth.hong.model.Users;

public class UsersServiceImpl implements IUsersService {
	
	private IUsersDao dao = null;
	
	public UsersServiceImpl() {
		dao = new UsersDaoImpl();
	}

	@Override
	public boolean isLogin(Users user) {
		
		return dao.isLogin(user);
	}

	
	
	
	

}
