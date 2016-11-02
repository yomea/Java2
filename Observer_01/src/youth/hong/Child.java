package youth.hong;

import java.util.Random;

public class Child {
	Dad d;
	
	public Child(Dad d) {
		this.d = d;
		Sleep s = new Sleep();
		new Thread(s).start();
	}

	
	
	
	private class Sleep implements Runnable {

		@Override
		public void run() {
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(10000));
				d.feed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
