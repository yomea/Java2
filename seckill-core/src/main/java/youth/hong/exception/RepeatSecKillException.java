package youth.hong.exception;

/**
 * �ظ���ɱ�쳣
 * @author May
 *
 */
public class RepeatSecKillException extends SeckillException {

	private static final long serialVersionUID = 1L;

	public RepeatSecKillException(String message) {
		super(message);
	}
	
	public RepeatSecKillException(String message, Throwable cause) {
		super(message, cause);
	}

	
	

}
