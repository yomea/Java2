package youth.hong;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Teacher {
	private TeacherPK pk;
	private Title title;
	
	public Teacher() {}
	
	
	
	public Teacher(TeacherPK pk, Title title) {
		
		this.pk = pk;
		this.title = title;
	}
	@Id
	public TeacherPK getPk() {
		return pk;
	}



	public void setPk(TeacherPK pk) {
		this.pk = pk;
	}



	@Enumerated(EnumType.ORDINAL)/*@Enumerated(EnumType.STRING)*/
	public Title getTitle() {
		return title;
	}



	public void setTitle(Title title) {
		this.title = title;
	}

	
}
