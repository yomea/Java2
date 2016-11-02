package youth.hong;

import java.awt.Point;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	
	private List<String> interests;
	private Date d;
	private Map<String,String> m;
	private Point p;

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public Map<String, String> getM() {
		return m;
	}

	public void setM(Map<String, String> m) {
		this.m = m;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}
	
	
	
	
}
