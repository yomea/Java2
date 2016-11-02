package youth.hong;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class World {
	private WorldPK worldPK;
	private Set<Hello> hellos = new HashSet<Hello>();

	@OneToMany(mappedBy="world")
	public Set<Hello> getHellos() {
		return hellos;
	}
	public void setHellos(Set<Hello> hellos) {
		this.hellos = hellos;
	}
	@EmbeddedId
	public WorldPK getWorldPK() {
		return worldPK;
	}
	public void setWorldPK(WorldPK worldPK) {
		this.worldPK = worldPK;
	}
	
	
	
}
