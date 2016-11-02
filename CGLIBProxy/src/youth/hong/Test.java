package youth.hong;

public class Test {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Train train = (Train)cglibProxy.getProxy(Train.class);
		train.move();
	}
}
