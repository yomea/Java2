package youth.hong;

public class TankTimeProxy implements Moveable {
	Moveable m = null;
	public TankTimeProxy(Moveable m) {
		this.m = m;
	}
	@Override
	public void move() {
		Long start = System.currentTimeMillis();
		m.move();
		Long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
}
