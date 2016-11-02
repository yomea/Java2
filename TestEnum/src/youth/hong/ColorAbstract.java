package youth.hong;

enum ColorAbstract implements Message {
	RED("红色") {
		public String getTitle() {
			
			return this.toString();
		}
	}, WHITE("白色") {
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.toString();
		}
	}, BLACK("黑色") {
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.toString();
		}
	}, GREEN("绿色") {
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


