package youth.hong;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Org {
	private int id;
	private String name;
	private Org org;
	private Set<Org> orgs = new HashSet<Org>();
	
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
	@ManyToOne
	@JoinColumn(name="personId")
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	@OneToMany(mappedBy="org",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Org> getOrgs() {
		return orgs;
	}
	public void setOrgs(Set<Org> orgs) {
		this.orgs = orgs;
	}
	
	
}
