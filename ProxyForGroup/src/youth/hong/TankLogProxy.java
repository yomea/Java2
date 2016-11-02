package youth.hong;

public class TankLogProxy implements Moveable {
	Moveable m = null;
	public TankLogProxy(Moveable m) {
		this.m = m;
	}
	@Override
	public void move() {
		System.out.println("start move...");
		m.move();
		System.out.println("stop move...");
	}
	
}
