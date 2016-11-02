package youth.hong;

import java.util.Random;

public class Child {
	boolean wakeUp = false;
	
	public Child() {
		Sleep s = new Sleep();
		new Thread(s).start();
	}

	public boolean isWakeUp() {
		return wakeUp;
	}

	public void setWakeUp(boolean wakeUp) {
		this.wakeUp = wakeUp;
	}
	
	private class Sleep implements Runnable {

		@Override
		public void run() {
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(10000));
				setWakeUp(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
