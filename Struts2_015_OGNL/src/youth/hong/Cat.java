package youth.hong;

public class Cat {
	private Dog friend;
	private int age;
	//private String name;
	
	public Cat() {}

	public Cat(int age) {
		this.age = age;
	}	
	
	public Dog getFriend() {
		return friend;
	}

	public void setFriend(Dog friend) {
		this.friend = friend;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String miaomiao() {
		return "miaomiao";
	}

	@Override
	public String toString() {
		return "Cat [age=" + age + "]";
	}
	
	
	
}
