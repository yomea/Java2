package youth.hong;

public class Cat {
	private int id;
	private String desc = "��Һã�����������";
	
	public Cat() {}
	
	public Cat(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", desc=" + desc + "]";
	}
	
	
}
