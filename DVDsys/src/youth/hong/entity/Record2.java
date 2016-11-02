package youth.hong.entity;

import java.util.Date;

public class Record2 {
	
	private int id;
	
	private int did;
	
	private String uname;
	
	private String dname;
	
	private Date lendTime;
	
	private Date returnTime;

	public Record2(int id, String uname, String dname, Date lendTime, Date returnTime) {
		super();
		this.id = id;
		this.uname = uname;
		this.dname = dname;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}

	public Record2(String uname, String dname, Date lendTime, Date returnTime) {
		super();
		this.uname = uname;
		this.dname = dname;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}

	public Record2() {
		super();
	}

	@Override
	public String toString() {
		return "Record2 [id=" + id + ", did=" + did + ", uname=" + uname + ", dname=" + dname + ", lendTime=" + lendTime
				+ ", returnTime=" + returnTime + "]";
	}
	
	
}
