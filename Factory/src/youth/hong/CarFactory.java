package youth.hong;

public class CarFactory implements VihecleFactory {

	
	@Override
	public Moveable create() {
		return new Car();
		
	}

}
