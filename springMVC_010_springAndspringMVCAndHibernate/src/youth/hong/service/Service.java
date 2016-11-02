package youth.hong.service;

import java.util.List;

import youth.hong.entity.User;

public interface Service {
	public void add(User user);

	public List<User> showUsers();

	public void deleteUser(int id);

	public void updateuser(User user);

	public User loadUserById(int id);
}
