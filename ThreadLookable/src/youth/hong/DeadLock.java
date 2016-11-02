package youth.hong;

public class DeadLock {
	
	Object o1 = new Object();
	Object o2 = new Object();
	
	private class Threadtest extends Thread {
		
		private boolean flag = true;
		
		public Threadtest(boolean flag) {
			this.flag = flag;
		}
		
		@Override
		public void run() {
			if(flag) {
				synchronized (o1) {
					int num1 = 3;
					int num2 = 3;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					synchronized (o2) {
						try {
							Thread.sleep(1000);
							System.out.println("sum:" + (num1 + num2));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				synchronized (o2) {
					int num1 = 2;
					int num2 = 2;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					synchronized (o1) {
						try {
							Thread.sleep(1000);
							System.out.println("sum:" + (num1 + num2));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	
	
	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Threadtest t1 = dl.new Threadtest(true);
		Threadtest t2 =dl.new Threadtest(false);
		t1.start();
		t2.start();
	
		
	}
	
}
