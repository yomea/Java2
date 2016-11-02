package youth.hong;

public class Test {

	public static void main(String[] args) {
		State state = new HappyState();
		Girl g = new Girl(state);
		g.smile();
		g.say();
		g.cry();
		
	}

}
