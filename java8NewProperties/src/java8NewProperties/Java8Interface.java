package java8NewProperties;

public interface Java8Interface {
	
	public static final String name = "java8新特性";
	
	
	public void hello();
	
	
	public static String getName() {
		return name;
	}
	
	public default void defaultHello() {
		System.out.println("增加这些特性是为了避免太多子类时需要全部去实现的问题！");
	}
}
