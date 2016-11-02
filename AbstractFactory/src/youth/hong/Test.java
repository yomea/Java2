package youth.hong;

public class Test {
	public static void main(String[] args) {
		AbstractFactory af = new DefaultFactory();
		Vehicle v = af.createVehicle();
		Food f = af.createFood();
		Weapon w = af.createWeapon();
		v.vehicle();
		f.eated();
		w.weapon();
	}
}
