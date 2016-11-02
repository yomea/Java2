package youth.hong;

public class Girl {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void command(Boy b) {
		Command c = new ShoppingCommand();
		Command cc = new WatchFilm();
		b.addCommand(c);
		b.addCommand(cc);
		b.doCommand();
	}
	
}
