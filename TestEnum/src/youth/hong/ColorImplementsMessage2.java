package youth.hong;

enum ColorImplementsMessage2 implements Message {
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
	
	private ColorImplementsMessage2(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}

	

}


