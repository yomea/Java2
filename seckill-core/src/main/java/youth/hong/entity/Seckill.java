package youth.hong.entity;

import java.util.Date;

public class Seckill {
	
	private long seckillId;
	
	private String name;
	
	private int number;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date createTime;
	
	
	

	public long getSeckillId() {
		return seckillId;
	}




	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getNumber() {
		return number;
	}




	public void setNumber(int number) {
		this.number = number;
	}




	public Date getStartTiem() {
		return startTime;
	}




	public void setStartTiem(Date startTiem) {
		this.startTime = startTiem;
	}




	public Date getEndTime() {
		return endTime;
	}




	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}




	public Date getCreateTime() {
		return createTime;
	}




	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}




	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTiem=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
	
	
	
	
	
}
