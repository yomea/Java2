package youth.hong.dto;

import youth.hong.entity.SuccessSeckill;
import youth.hong.enums.SeckillStateEnum;

/**
 * 秒杀执行后的结果
 * @author May
 *
 */
public class SeckillExcution {
	private long seckillId;
	
	private int state;
	
	private String info;
	
	private SuccessSeckill successSeckill;
	
	

	public SeckillExcution(long seckillId, SeckillStateEnum seckillStateEnum) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.info = seckillStateEnum.getInfo();
	}

	public SeckillExcution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessSeckill successSeckill) {
		super();
		this.seckillId = seckillId;
		this.state = seckillStateEnum.getState();
		this.info = seckillStateEnum.getInfo();
		this.successSeckill = successSeckill;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SuccessSeckill getSuccessSeckill() {
		return successSeckill;
	}

	public void setSuccessSeckill(SuccessSeckill successSeckill) {
		this.successSeckill = successSeckill;
	}

	@Override
	public String toString() {
		return "SeckillExcution [seckillId=" + seckillId + ", state=" + state + ", info=" + info + ", successSeckill="
				+ successSeckill + "]";
	}
	
}
