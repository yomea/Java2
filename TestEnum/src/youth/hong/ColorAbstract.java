package youth.hong;

enum ColorAbstract implements Message {
	RED("��ɫ") {
		public String getTitle() {
			
			return this.toString();
		}
	}, WHITE("��ɫ") {
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.toString();
		}
	}, BLACK("��ɫ") {
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.toString();
		}
	}, GREEN("��ɫ") {
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.toString();
		}
	};
	
	private String title;
	
	private ColorAbstract(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}

	public abstract String getTitle();

}


