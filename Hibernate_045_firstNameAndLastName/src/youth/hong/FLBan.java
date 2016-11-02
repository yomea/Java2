package youth.hong;

import java.util.StringTokenizer;

public class FLBan {
	private int id;
	private String firstName;
	private String lastName;
	
	
	public String getName() {
		return firstName+" "+lastName;
	}
	public void setName(String name) {
		StringTokenizer st = new StringTokenizer(name, " ");
		this.firstName = st.nextToken();
		this.lastName = st.nextToken();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
