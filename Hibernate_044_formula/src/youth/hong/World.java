package youth.hong;

import java.util.HashSet;
import java.util.Set;

public class World {
	private int id;
	private String name;
	private int avg;
	private Set<Hello> hellos = new HashSet<Hello>();

	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public Set<Hello> getHellos() {
		return hellos;
	}
	public void setHellos(Set<Hello> hellos) {
		this.hellos = hellos;
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
