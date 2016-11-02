package youth.hong;

public class HappyState extends State {

	@Override
	public void smile() {
		System.out.println("商场打折，我要去购物！");
	}

	@Override
	public void cry() {
		System.out.println("我终于买到我心爱已久的裙子了，老公你真好!");
	}

	@Override
	public void say() {
		System.out.println("今天我要给你跳个舞！");
	}

}
