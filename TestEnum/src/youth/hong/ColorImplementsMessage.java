package youth.hong;

enum ColorImplementsMessage implements Message {
	RED("��ɫ"), WHITE("��ɫ"), BLACK("��ɫ"), GREEN("��ɫ");
	
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


