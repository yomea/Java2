package youth.hong;

import java.util.List;

public interface UserDao {
	public void save(User user);
	public boolean isExists(User user);
	public List<User> getUsers();
	public User loadById(int id);
}
