package youth.hong;

enum Color {
	RED("红色"), WHITE("白色"), BLACK("黑色"), GREEN("绿色");
	
	private String title;
	
	private Color(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}


