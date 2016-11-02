package youth.hong;

public interface UserDao {
	public void save(User user);
	public boolean isExists(User user);
}
