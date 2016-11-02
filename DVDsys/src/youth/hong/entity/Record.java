package youth.hong.entity;

import java.util.Date;

public class Record {
	private int id;
	private int uid;
	private int did;
	private Date lendTime;
	private Date returnTime;
	
	
	
	public Record() {
		super();
	}



	public Record(int uid, int did, Date lendTime, Date returnTime) {
		super();
		this.uid = uid;
		this.did = did;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	
	
	



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public Date getLendTime() {
		return lendTime;
	}



	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}



	public Date getReturnTime() {
		return returnTime;
	}



	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}



	public Record(int id, int uid, int did, Date lendTime, Date returnTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.did = did;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}



	@Override
	public String toString() {
		return "Record [id=" + id + ", uid=" + uid + ", did=" + did + ", lendTime=" + lendTime + ", returnTime="
				+ returnTime + "]";
	}
	
	
	
}
