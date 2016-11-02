package youth.hong;

public class LookableSynchronized {

	private int num = 1;

	private boolean ready = false;

	private int result = 0;

	private class ThreadTest extends Thread {

		private boolean flag = true;

		public ThreadTest(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {
			if (flag) {
				write();
			} else {
				read();
			}

		}

	}

	/**
	 * synchronized除了进行同步外，还可以进行内存的可见性，它保证了其他线程在使用共享变量时一定先去主内存中加载共享变量，
	 * 确保在执行自个任务前是新的。
	 */
	private void write() {
		synchronized (this) {
			if (ready) {
				result = num * 3;

			}
		}
		System.out.println("result的值：" + result);
	}

	private synchronized void read() {
		synchronized (this) {
			ready = true;
			num = 2;
		}

	}

	public static void main(String[] args) {

		LookableSynchronized lu = new LookableSynchronized();
		ThreadTest th1 = lu.new ThreadTest(true);
		ThreadTest th2 = lu.new ThreadTest(false);
		th2.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		th1.start();
	}

}
