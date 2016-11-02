package youth.hong;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
public class TeacherPK implements Serializable {
	private int id;
	private String name;
	
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
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof TeacherPK) {
			TeacherPK tpk = (TeacherPK)o;
			if(tpk.getId() == this.getId() && tpk.getName().equals(this.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return this.name.hashCode();
	}
}
