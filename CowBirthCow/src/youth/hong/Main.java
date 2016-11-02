package youth.hong;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		//for(int i = 0; i < 20; i++){
			Cow1 c = new Cow1(1);
			Thread t = new Thread(c);
			t.start();
			
			
		//}
			
			
	}
}
