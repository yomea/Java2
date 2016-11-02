package youth.hong.enums;

public enum SeckillStateEnum {
	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1,"重复秒杀"),
	INNER_ERROR(-2,"系统错误"),
	DATA_REWRITE(-3,"数据篡改");
	
	private String info;
	
	private int state;

	SeckillStateEnum(int state, String info) {
		this.state = state;
		this.info = info;
	}


	public int getState() {
		return state;
	}


	public String getInfo() {
		return info;
	}
	
	public static SeckillStateEnum stateOf(int index) {
		for (SeckillStateEnum state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}

	
}
