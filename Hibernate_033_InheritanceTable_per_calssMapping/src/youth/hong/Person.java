package youth.hong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@TableGenerator(
		name="table",
		table="t_table",
		pkColumnName="p_key",
		valueColumnName="p_value",
		pkColumnValue="Student",
		initialValue=1,
		allocationSize=1
		)
public class Person {
	private int id;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="table")
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
