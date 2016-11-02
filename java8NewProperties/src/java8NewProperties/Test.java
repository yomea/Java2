package java8NewProperties;

class Java8NewProperties implements Java8Interface {

	@Override
	public void hello() {
		System.out.println("ƒ„∫√£°Œ“ «java8£°");
	}

	
}

public class Test {
	
	public static void main(String[] args) {
		Java8Interface java8 = new Java8NewProperties();
		java8.hello();
		System.out.println("----------------------default-----------------------");
		java8.defaultHello();
		System.out.println("----------------------static-----------------------");
		System.out.println(Java8Interface.getName());
	}
	
}
