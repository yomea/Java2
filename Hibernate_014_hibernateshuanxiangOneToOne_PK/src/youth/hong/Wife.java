package youth.hong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Wife {
	private int id;
	private String name;
	private Husband husband;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public Husband getHusband() {
		return husband;
	}
	public void setHusband(Husband husband) {
		this.husband = husband;
	}
	@Id
	@GenericGenerator(name ="pkGenerator",strategy="foreign" ,parameters={@Parameter(name="property",value="husband")})
	@GeneratedValue(generator="pkGenerator")
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
