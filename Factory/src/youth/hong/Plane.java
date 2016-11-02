package youth.hong;

public class Plane implements Moveable {

	private static Moveable plane = new Plane();
	
	private Plane() {}
	
	public static Moveable create() {
		return plane;
	}
	
	@Override
	public void run() {
		System.out.println("Plane ...");
	}

}
