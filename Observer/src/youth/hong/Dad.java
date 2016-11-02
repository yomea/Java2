package youth.hong;

public class Dad {
	Child c;
	
	public Dad(Child c) {
		this.c = c;
		Naozhong nz = new Naozhong();
		new Thread(nz).start();
	}
	
	public void feed() {
		System.out.println("feed food!");
	}
	
	
	
	private class Naozhong implements Runnable {
		
		@Override
		public void run() {
			while(!c.isWakeUp()) {
				try {
					
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			feed();
		} 
		
	}
}
