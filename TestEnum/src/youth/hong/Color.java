package youth.hong;

enum Color {
	RED("��ɫ"), WHITE("��ɫ"), BLACK("��ɫ"), GREEN("��ɫ");
	
	private String title;
	
	private Color(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}


