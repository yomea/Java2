package youth.hong.dto;

public class ModuleDto {
	
	private int id;
	
	private String name;
	
	private String sn;
	
	private String url;
	
	private int orderNo;
	
	private int parentId;
	
	

	public ModuleDto() {
		super();
	}

	public ModuleDto(int id, String name, String sn, String url, int orderNo, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.sn = sn;
		this.url = url;
		this.orderNo = orderNo;
		this.parentId = parentId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", sn=" + sn + ", url=" + url + ", orderNo=" + orderNo
				+ ", parentId=" + parentId + "]";
	}
	
	
}
