package youth.hong;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LookableVolatile {

	private Lock lock = new ReentrantLock();
	
	private volatile int num = 0;

	public int getNum() {
		return num;
	}
	
	public void increase() {
		//加锁
		lock.lock();
		try {
			num++;
			
		} finally {
			//解锁
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		LookableVolatile lookableVolatile = new LookableVolatile();
		for(int i = 0; i < 500; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					lookableVolatile.increase();
					
				}
				
			}).start();
		
		}
		
		while(Thread.activeCount() > 1) {
			/**
			 * 确保所有的子线程执行完，在打印出来。
			 */
			
		}
		
		/**
		 * 实验证明volatile只保证可见性，不能保证原子性，所以需要枷锁
		 */
		System.out.println("num:" + lookableVolatile.num);
	}
	
}
