package youth.hong.compiler;

import youth.hong.InvocationHandler;
import youth.hong.Moveable;
import youth.hong.Proxy;
import youth.hong.Tank;
import youth.hong.TimeInvocationHandler;

public class Test {
	public static void main(String[] args) throws Exception {
		Tank t = new Tank();
		InvocationHandler ih = new TimeInvocationHandler(t);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, ih);
		m.move();
		
	}
}
