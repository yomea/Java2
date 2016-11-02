package youth.hong;

public class BroomFactory implements VihecleFactory {

	
	@Override
	public Moveable create() {
		return new Broom();
		
	}

}
