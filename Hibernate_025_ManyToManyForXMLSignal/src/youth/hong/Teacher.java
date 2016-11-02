package youth.hong;

import java.util.Set;

/**
 * @author May
 *
 */

public class Teacher {
	private int id;
	
	private String name;

	private Set<Student> students;


	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

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
