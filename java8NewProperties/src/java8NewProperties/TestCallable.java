package java8NewProperties;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		return "HelloWorld!";
	}
	
	public static void main(String[] args) throws Exception {
		TestCallable callable = new TestCallable();
		FutureTask<String> ft = new FutureTask<String>(callable);
		new Thread(ft).start();
		System.out.println(ft.get());
	}
}