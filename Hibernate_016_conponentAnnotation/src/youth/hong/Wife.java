package youth.hong;

import javax.persistence.Column;

public class Wife {
	private String name;
	
	@Column(name="wifeName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
