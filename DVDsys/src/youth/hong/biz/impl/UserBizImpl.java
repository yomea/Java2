package youth.hong.biz.impl;

import youth.hong.biz.UserBiz;
import youth.hong.dao.UserDao;
import youth.hong.dao.impl.UserDaoImpl;
import youth.hong.entity.User;

public class UserBizImpl implements UserBiz {
	private UserDao userDao = null;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User login(User user) {
		
		return userDao.queryUser(user);
	}

	@Override
	public int registerUser(User user) {
		if(userDao.queryUser(user) != null) {
			return 0;//�ظ�ע��
		} else {
			boolean flag = userDao.saveUser(user);
			if(flag) {
				return 1;//ע��ɹ�
			} else {
				return -1;//ע��ʧ��
			}
			
		}
	}

}
