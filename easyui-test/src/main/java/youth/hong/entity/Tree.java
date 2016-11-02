package youth.hong.entity;

public class Tree {
	private int id;
	private String text;
	private String state;
	private String url;

	public Tree() {
		super();
	}

	public Tree(String text, String state, String url) {
		super();
		this.text = text;
		this.state = state;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", state=" + state + ", url=" + url + "]";
	}

	
}
