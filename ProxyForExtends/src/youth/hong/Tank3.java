package youth.hong;

public class Tank3 extends Tank2 {

	@Override
	public void move() {
		System.out.println("start move...");
		super.move();
		System.out.println("stop move...");
	}
	
}
