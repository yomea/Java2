package youth.hong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class Husband {
	private int id;
	private String name;
	private Wife wife;
	@Id
	@GeneratedValue
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
	@OneToOne
	@JoinColumns({@JoinColumn(name="wifeId",referencedColumnName="id"),@JoinColumn(name="WifeName",referencedColumnName="name")})
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	
	
	
}
