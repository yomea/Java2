package youth.hong;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student {
	private int id;
	private String name;
	private Set<Course> cs = new HashSet<Course>();
	private Set<Score> sores = new HashSet<Score>();
	
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Set<Score> getSores() {
		return sores;
	}
	public void setSores(Set<Score> sores) {
		this.sores = sores;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@ManyToMany
	@JoinTable(
			name="score",
			joinColumns={@JoinColumn(name="courseId")},
			inverseJoinColumns={@JoinColumn(name="studentId")}

			)
	public Set<Course> getCs() {
		return cs;
	}
	public void setCs(Set<Course> cs) {
		this.cs = cs;
	}
	
	
}
