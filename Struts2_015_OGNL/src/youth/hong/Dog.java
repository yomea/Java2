package youth.hong;

public class Dog {
	private String name;
	
	public Dog() {
		
	}

	public Dog(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String wangwang() {
		return "wangwang";
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
	
}
