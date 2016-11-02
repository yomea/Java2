package youth.hong;

public class Test {
	
	
	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("runable...");
			}
		}){
			public void run() {
				System.out.println("thread...");
			}
			
		};
		
		th.start();
	}
}
