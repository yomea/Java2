package youth.hong;

public class Test {
	public static void main(String[] args) {
		for(Color color : Color.values()) {
			System.out.println(color.ordinal() + "--" + color.name());
		}
		
		System.out.println("------------------------实现接口--------------------------------");
		//非静态方法使用枚举对象来调用动态方法
		System.out.println(ColorImplementsMessage.RED.getTitle());
		System.out.println("------------------------实现接口2--------------------------------");
		System.out.println(ColorImplementsMessage2.BLACK.getTitle());
		System.out.println("------------------------直接定义抽象方法--------------------------------");
		System.out.println(ColorImplementsMessage2.GREEN.getTitle());
	}
}
