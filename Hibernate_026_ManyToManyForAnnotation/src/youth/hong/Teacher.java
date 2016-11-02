package youth.hong;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author May
 *
 */
@Entity
public class Teacher {
	private int id;
	
	private String name;

	private Set<Student> students;

	@ManyToMany
	@JoinTable(
			name="t_s",
			joinColumns={@JoinColumn(name="teacherId")},
			inverseJoinColumns={@JoinColumn(name="studentId")}
			)
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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
	
	
}
