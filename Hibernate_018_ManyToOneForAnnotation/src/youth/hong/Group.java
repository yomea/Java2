package youth.hong;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author May
 *
 */
@Entity
public class Group {
	private int id;
	
	private String name;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
