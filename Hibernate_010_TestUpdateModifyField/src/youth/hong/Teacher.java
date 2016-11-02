package youth.hong;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Teacher {
	private int id;
	private String name;
	private Title title;
	
	public Teacher() {}
	
	

	public Teacher(int id, String name, Title title) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
	}



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

	//@Column(updatable=false)//该字段不会经行更新
	@Enumerated(EnumType.ORDINAL)/*@Enumerated(EnumType.STRING)*/
	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}

	
}
