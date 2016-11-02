package youth.hong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="_teacher")
@TableGenerator(
name="outh",
table="_outh",
pkColumnName="pk_key",
valueColumnName="pk_value",
pkColumnValue="Teacher",
allocationSize=1
)
//@SequenceGenerator(name="a",sequenceName="b")
public class Teacher {
	private int id;
	private String name;
	private Title title;
	
	public Teacher() {}
	
	
	
	public Teacher(int id, String name, Title title) {
		
		this.id = id;
		this.name = name;
		this.title = title;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="outh")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="a")//oracle
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="username")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.ORDINAL)/*@Enumerated(EnumType.STRING)*/
	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
	
	
	
}
