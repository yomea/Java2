package youth.hong;

enum ColorImplementsMessage implements Message {
	RED("红色"), WHITE("白色"), BLACK("黑色"), GREEN("绿色");
	
	private String title;
	
	private ColorImplementsMessage(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}
}


