package youth.hong;

public class Test {
	public static void main(String[] args) {
		VihecleFactory cf = new CarFactory();
		Moveable car = cf.create();
		Moveable plane = Plane.create();
		plane.run();
		car.run();
	}
}
