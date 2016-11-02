package youth.hong;

/**
 * 可能出现的运行结果
 * Thread one：0
Thread two：0
Thread one：1
Thread two：2
Thread one：3
Thread two：4
Thread one：5
Thread two：6
Thread one：7
Thread two：8
Thread one：9
Thread two：10
Thread two：12
Thread two：13
Thread one：11
Thread one：15
Thread two：14
Thread one：16
Thread two：17
Thread one：18
 * @author May
 *
 */
public class NoUseAtomicIntegerTest {
	public static int count = 0;

	public static void printInt(int i) {
		System.out.println(i);
	}

	private class MyThread implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				
				System.out.println(Thread.currentThread().getName() + "：" + count++);
			}
		}

	}

	public static void main(String[] args) {
		NoUseAtomicIntegerTest att = new NoUseAtomicIntegerTest();
		
		MyThread mt = att.new MyThread();
		Thread t1 = new Thread(mt, "Thread one");
		Thread t2 = new Thread(mt, "Thread two");
		t1.start();
		t2.start();
		
		
	}
}
