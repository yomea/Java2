package youth.hong.service;

import java.util.List;

import youth.hong.entity.Tree;
import youth.hong.entity.User;
import youth.hong.message.Message;

public interface IUserService {

	public Message<User> getUser(User user);
	
	public List<Tree> findTree(int id);
}
