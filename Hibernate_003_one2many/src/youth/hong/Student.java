package youth.hong;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
	private int sid;
	private String sname;
	private char sex;
	private int gid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Student(int sid, String sname, char sex, int gid) {
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.gid = gid;
	}
	public Student() {
	}
	
	
	
}
