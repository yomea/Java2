package youth.hong;

public class ShoppingCommand implements Command {

	@Override
	public void execute() {
		System.out.println("shopping...");
	}

	@Override
	public void undo() {
		System.out.println("stay at home...");
	}

}
