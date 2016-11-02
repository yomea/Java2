package youth.hong.userDao;

public class PasswordNotCorrectException extends Exception {
	public PasswordNotCorrectException(String str) {
		super(str);
	}
}
