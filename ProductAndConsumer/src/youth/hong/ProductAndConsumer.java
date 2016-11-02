package youth.hong;

class Info {
	private String name;
	private String content;
	private boolean flag = true;
	
	public synchronized void set(String name, String content) {
		if(flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.content = content;
		flag = false;
		this.notify();
	}
	
	public synchronized void get() {
		if(flag == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.name + "--" + this.content);
		flag = true;
		this.notify();
	}
}

class Product implements Runnable {
	private Info info;
	
	public Product(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			if(i % 2 == 0) {
				info.set("hong", "我是天才");
			} else {
				info.set("youth", "我是大侠");
			}
		}
		
	}
	
}

class Consumer implements Runnable {
	private Info info;
	
	public Consumer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			info.get();
			
		}
		
	}
	
}

public class ProductAndConsumer {
	
	public static void main(String[] args) {
		Info info = new Info();
		Product product = new Product(info);
		Consumer consumer = new Consumer(info);
		new Thread(product).start();
		new Thread(consumer).start();
	}
	
}
