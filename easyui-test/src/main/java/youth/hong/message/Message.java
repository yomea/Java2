package youth.hong.message;

import java.util.List;

public class Message<T> {
	private boolean success;
	
	private List<T> data;
	
	public Message() {}
	
	public Message(boolean success, List<T> data) {
		this.success = success;
		
		this.data = data;
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message [success=" + success + ", data=" + data + "]";
	}
	
}
