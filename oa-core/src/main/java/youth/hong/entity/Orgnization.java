package youth.hong.entity;

import java.util.Set;

public class Orgnization {
	private int id;
	private String name;
	private String sn;//±àºÅ
	private Orgnization parent;
	private String decription;
	private Set<Orgnization> children;
	private int cid;
	
	
	public Orgnization() {
		super();
	}

	public Orgnization(String name, String sn, Orgnization parent, Set<Orgnization> children, String decription, int cid) {
		super();
		this.name = name;
		this.sn = sn;
		this.parent = parent;
		this.children = children;
		this.decription = decription;
		this.cid = cid;
	}
	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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
	public Orgnization getParent() {
		return parent;
	}
	public void setParent(Orgnization parent) {
		this.parent = parent;
	}
	public Set<Orgnization> getChildren() {
		return children;
	}
	public void setChildren(Set<Orgnization> children) {
		this.children = children;
	}
	
	

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "Orgnization [id=" + id + ", name=" + name + ", sn=" + sn + ", parent=" + parent + ", decription="
				+ decription + ", children=" + children + "]";
	}

}
