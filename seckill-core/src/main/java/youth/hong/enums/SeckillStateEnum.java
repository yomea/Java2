package youth.hong.enums;

public enum SeckillStateEnum {
	SUCCESS(1,"��ɱ�ɹ�"),
	END(0,"��ɱ����"),
	REPEAT_KILL(-1,"�ظ���ɱ"),
	INNER_ERROR(-2,"ϵͳ����"),
	DATA_REWRITE(-3,"���ݴ۸�");
	
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
