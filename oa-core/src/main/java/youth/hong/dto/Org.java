package youth.hong.dto;

public class Org {
	private int id;
	private String name;
	private String sn;// ±àºÅ
	private String decription;
	private int pid;
	
	public Org() {}

	public Org(String name, String sn, String decription, int pid) {
		super();
		this.name = name;
		this.sn = sn;
		this.decription = decription;
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
