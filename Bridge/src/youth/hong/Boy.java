package youth.hong;

public class Boy {
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pusue(Girl g) {
		WaramGift w = new WaramGift(new Ring());
		give(g, w.impl);
	}

	private void give(Girl g, GiftImpl impl2) {
		
	}
}
