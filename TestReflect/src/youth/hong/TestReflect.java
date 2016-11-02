package youth.hong;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int i = 0;
		new TestReflect().executeMethod();
		List<String> strings = new ArrayList<String>();
		strings.add("hello");
		//strings.add(20);//报错，在编译期间就会检查，运行期间是去泛型化的
		//可以通过反射的方法来绕过编译
		Method m = List.class.getMethod("add", new Class[]{Object.class});
		m.invoke(strings, 20);//这样他就不会报错了。
		System.out.println(strings.size());

	}
	
	public void executeMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class t = TestReflect.class;
		TestReflect rt = new TestReflect();
		Method m = t.getDeclaredMethod("showClassInfo", new Class[]{Object.class});
		int i = 0;
		m.invoke(rt, i);
	}
	
	public void showClassInfo(Object obj) throws NoSuchMethodException, SecurityException {
		Class c = obj.getClass();
		System.out.println(c.getName());
		Method[] ms = c.getMethods();
		for(int i = 0; i < ms.length; i++) {
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			System.out.print(ms[i].getName() + "(");		
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class pt : paramTypes) {
				System.out.print(pt.getName() + ",");
			}
			System.out.print(")");
			System.out.println();
		}
		Field[] field = c.getDeclaredFields();
		for (Field field2 : field) {
			Class ret = field2.getType();
			System.out.print(ret.getName() + " ");
			System.out.println(field2.getName());
		}
		Constructor[] ct = c.getConstructors();
		for (Constructor constructor : ct) {
			Class[] trt = constructor.getParameterTypes();
			System.out.print(constructor.getName() + "(");
			for (Class class1 : trt) {
				System.out.print(class1.getName() + ",");
			}
			System.out.print(")");
			System.out.println();
			
		}
	}
	
	

}
