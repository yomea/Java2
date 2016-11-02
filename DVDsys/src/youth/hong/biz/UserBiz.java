package youth.hong.biz;

import youth.hong.entity.User;

public interface UserBiz {
	public User login(User user);
	public int registerUser(User user);
}
