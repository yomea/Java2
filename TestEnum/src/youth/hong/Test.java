package youth.hong;

public class Test {
	public static void main(String[] args) {
		for(Color color : Color.values()) {
			System.out.println(color.ordinal() + "--" + color.name());
		}
		
		System.out.println("------------------------ʵ�ֽӿ�--------------------------------");
		//�Ǿ�̬����ʹ��ö�ٶ��������ö�̬����
		System.out.println(ColorImplementsMessage.RED.getTitle());
		System.out.println("------------------------ʵ�ֽӿ�2--------------------------------");
		System.out.println(ColorImplementsMessage2.BLACK.getTitle());
		System.out.println("------------------------ֱ�Ӷ�����󷽷�--------------------------------");
		System.out.println(ColorImplementsMessage2.GREEN.getTitle());
	}
}
