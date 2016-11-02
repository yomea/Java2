package youth.hong;

class Haha {
	private int age = 10;
	
	public int getAge() {
		return this.age;
	}
}

public class Test extends Haha {
	//private int age = 11;
	
	
	/*@Override
	 * 父类私有成员子类不能继承
	private int getAge() {
		return this.age;
	}*/
	public static void main(String[] args) {
		System.out.println(new Test().getAge());
	}
}
