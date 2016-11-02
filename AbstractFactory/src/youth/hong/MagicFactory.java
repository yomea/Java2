package youth.hong;

public class MagicFactory extends AbstractFactory {

	@Override
	public Food createFood() {
		// TODO Auto-generated method stub
		return new Mushroom();
	}

	@Override
	public Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Broom();
	}

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new MagicStick();
	}

}
