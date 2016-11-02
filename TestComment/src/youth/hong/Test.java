package youth.hong;

import java.lang.reflect.Method;

//@Description("Test")
public class Test extends Person {
	@SuppressWarnings("deprecation")
//	@Description("public static void main(String[] args)")
	public static void main(String[] args) {
		Person p = new TestComment();
		p.sing();
		Class<Test> c = Test.class;
		boolean isAnn = c.isAnnotationPresent(Description.class);
		if(isAnn) {
			Description d = (Description) c.getAnnotation(Description.class);
			System.out.println(d.value());
		}
		
		Method[] ms = c.getMethods();
		for (Method method : ms) {
			boolean ise = method.isAnnotationPresent(Description.class);
			if(ise) {
				Description d = method.getAnnotation(Description.class);
				System.out.println(d.value());
			}
		}
	}
}
