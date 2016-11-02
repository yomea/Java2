package youth.hong;

public class Girl {
	private String name;
	private State state;
	

	public Girl(State state) {
		super();
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void smile() {
		state.smile();
	}

	public void cry() {
		state.cry();
	}

	public void say() {
		state.say();
	}
	
}
