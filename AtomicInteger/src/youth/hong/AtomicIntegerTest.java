package youth.hong;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的，两个线程不会出现相同的值
 * @author May
 *
 */
public class AtomicIntegerTest {
	public static AtomicInteger ato = new AtomicInteger(0);

	public static void printInt(int i) {
		System.out.println(i);
	}

	private class MyThread implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "：" + ato.getAndIncrement());
			}
		}

	}

	public static void main(String[] args) {
		int a = ato.get();
		printInt(a);
		int b = ato.getAndIncrement();
		printInt(b);
		int c = ato.getAndIncrement();
		printInt(c);
		
		AtomicIntegerTest att = new AtomicIntegerTest();
		
		MyThread mt = att.new MyThread();
		Thread t1 = new Thread(mt, "Thread one");
		Thread t2 = new Thread(mt, "Thread two");
		t1.start();
		t2.start();
		
	}
}
