package youth.hong.userDao;

import youth.hong.user.User;

public class Userdao {
	
	private static Userdao ud = null;
	
	static {
		ud = new Userdao();
	}
	
	private Userdao() {}
	
	public static Userdao getUd() {
		if(ud == null) {
			ud = new Userdao();
		}
		return ud;
	}
	
	public void checkUser(User user) throws UsernameNotFoundException, PasswordNotCorrectException {
		if(!user.getUsername().equals("admin")) {
			throw new UsernameNotFoundException("username not exist");
		} else if(!user.getPassword().equals("admin")) {
			throw new PasswordNotCorrectException("password not correct");
		}
	}
}
