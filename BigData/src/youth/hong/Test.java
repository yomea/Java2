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
	 * ����˽�г�Ա���಻�ܼ̳�
	private int getAge() {
		return this.age;
	}*/
	public static void main(String[] args) {
		System.out.println(new Test().getAge());
	}
}
