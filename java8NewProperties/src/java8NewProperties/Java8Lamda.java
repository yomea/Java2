package java8NewProperties;

public class Java8Lamda {

	public static void main(String[] args) {
		/*print(new Java8Interface() {

			@Override
			public void hello() {
				System.out.println("¦Ë");
				
			}
			
		});*/
		
		print(()->System.out.println("Lamda"));
	}
	
	public static void print(Java8Interface java8) {
		java8.hello();
	}
	
}
