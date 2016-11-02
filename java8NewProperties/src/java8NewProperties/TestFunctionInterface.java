package java8NewProperties;

public class TestFunctionInterface {

	public static void main(String[] args) {
		System.out.println("--------------------静态方法引入-------------------------");
		Java8FunctionInterface<Integer> jfi = Integer :: max;
		System.out.println(jfi.bijiao(9, 10));
		System.out.println("--------------------对象方法引入-------------------------");
		Integer a = new Integer(11);
		Java8FunctionInterface2<Integer> jfi2 = a :: intValue;
		System.out.println(jfi2.value());
		System.out.println("--------------------特殊类型方法引入-------------------------");
		Java8FunctionInterface3<String> jfi3 = String :: compareTo;
		System.out.println(jfi3.compare("A", "B"));
		System.out.println("--------------------构造方法引入-------------------------");
		Java8FunctionInterface4<Book> jfi4 = Book :: new;
		Book book = jfi4.create("youth", 1000);
		System.out.println(book);
	}
}
