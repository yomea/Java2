package youth.hong;

public class SadState extends State {

	@Override
	public void smile() {
		System.out.println("没想到这么多年了，我才发现你一直在骗我");
	}

	@Override
	public void cry() {
		System.out.println("。。。。。。。。。。。。。");
	}

	@Override
	public void say() {
		System.out.println("我要阉了你");
	}

}
