package bean;

public class CounterBean {
	int count;
	public CounterBean(){
		
	}
	public int getCount() {
		count++;
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
