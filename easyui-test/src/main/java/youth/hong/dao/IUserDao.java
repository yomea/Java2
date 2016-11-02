package youth.hong.dao;

import java.util.List;

import youth.hong.entity.Tree;
import youth.hong.entity.User;

public interface IUserDao {
	public User getUser(User user);
	
	public List<Tree> findTree(int id);
}
