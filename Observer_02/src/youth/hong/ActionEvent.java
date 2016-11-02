package youth.hong;

public class ActionEvent {
	private long time;
	private String loc;
	private Child source;
	
	
	
	public ActionEvent(long time, String loc, Child source) {
		super();
		this.time = time;
		this.loc = loc;
		this.source = source;
	}
	public long getTime() {
		time = System.currentTimeMillis();
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Child getSource() {
		return source;
	}
	public void setSource(Child source) {
		this.source = source;
	}
	
	
	
}
