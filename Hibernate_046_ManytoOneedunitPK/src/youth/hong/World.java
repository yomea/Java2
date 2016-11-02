package youth.hong;

import java.util.HashSet;
import java.util.Set;

public class World {
	private WorldPK worldPK;
	private Set<Hello> hellos = new HashSet<Hello>();

	
	public Set<Hello> getHellos() {
		return hellos;
	}
	public void setHellos(Set<Hello> hellos) {
		this.hellos = hellos;
	}
	public WorldPK getWorldPK() {
		return worldPK;
	}
	public void setWorldPK(WorldPK worldPK) {
		this.worldPK = worldPK;
	}
	
	
	
}
