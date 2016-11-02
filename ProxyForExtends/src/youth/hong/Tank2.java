package youth.hong;

public class Tank2 extends Tank {

	@Override
	public void move() {
		Long start = System.currentTimeMillis();
		super.move();
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
}
