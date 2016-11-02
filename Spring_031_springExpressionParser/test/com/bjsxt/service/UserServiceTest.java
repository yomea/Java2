package com.bjsxt.service;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lib.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserServiceTest {

	@Test
	public void test1(){
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('! I come back')");
		String message = (String) exp.getValue();
		System.out.println(message);
	}
	
	@Test
	public void test2(){
		// Create and set a calendar
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);

		// The constructor arguments are name, birthday, and nationality.
		Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

		ExpressionParser parser = new SpelExpressionParser();
		Expression exp1 = parser.parseExpression("name");
		//定义了一个变量在exp1中，但是需要告诉他到哪里才能找到它。
		EvaluationContext context = new StandardEvaluationContext(tesla);
		String name = (String) exp1.getValue(context);
		System.out.println(name);
		Expression exp2 = parser.parseExpression("name == 'Nikola Tesla'");
		boolean result = exp2.getValue(context, Boolean.class); // evaluates to true
		System.out.println(result);
		System.out.println(tesla);
	}
	
	
	
	@Test
	public void test3(){
		class Simple {
		    public List<Boolean> booleanList = new ArrayList<Boolean>();
		}

		Simple simple = new Simple();

		simple.booleanList.add(true);

		StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);
		
		ExpressionParser parser = new SpelExpressionParser();
		// false is passed in here as a string. SpEL and the conversion service will
		// correctly recognize that it needs to be a Boolean and convert it
		parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");

		// b will be false
		Boolean b = simple.booleanList.get(0);
		
		System.out.println(b);
	}
	
	class Demo {
	    public List<String> list;
	}
	
	
	@Test
	public void test4(){
		// Turn on:
		// - auto null reference initialization
		// - auto collection growing
		SpelParserConfiguration config = new SpelParserConfiguration(true,true);

		ExpressionParser parser = new SpelExpressionParser(config);

		Expression expression = parser.parseExpression("list[3]");

		Demo demo = new Demo();

		Object o = expression.getValue(demo);

		// demo.list will now be a real collection of 4 entries
		// Each entry is a new empty String
		
		System.out.println(o + "list的size自定变为了四，并且值全是空的字符串！");
	}
	
	@Test
	public void test5() {
		User user = new User("youth", 22);
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		EvaluationContext e = new StandardEvaluationContext(user);
		String name = exp.getValue(e, String.class);
		System.out.println(name);
		
	}
	@Inject
	@Named("user")
	private User user;

	@Test
	public void test6() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp1 = parser.parseExpression("name");
		Expression exp2 = parser.parseExpression("age");
		EvaluationContext e = new StandardEvaluationContext(user);
		String name = exp1.getValue(e, String.class);
		int age = exp2.getValue(e, int.class);
		System.out.println(name + " = " + age);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test7() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp1 = parser.parseExpression("{1,2,3,4,5,6,7,8,9}");
		Expression exp2 = parser.parseExpression("{{1,2,3,4},{5,6,7,8,9}}");
		List<List<Integer>> list2 = exp2.getValue(List.class);
		List<Integer> list1 = exp1.getValue(List.class);
		System.out.println(list1);
		System.out.println();
		System.out.println(((List<Integer>)list2.get(0)).get(0));
		
	}
	
	
	/**
	 * 注册方法到context中。
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void test8() throws NoSuchMethodException, SecurityException {
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();

		context.registerFunction("reverseString",
		    StringUtils.class.getDeclaredMethod("reverseString", new Class[] { String.class }));

		String helloWorldReversed = parser.parseExpression(
		    "#reverseString('hello')").getValue(context, String.class);
		System.out.println(helloWorldReversed);
	}
	
	@Test
	public void test9(){
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setBeanResolver(new BeanResolver() {
			
			@Override
			public Object resolve(EvaluationContext arg0, String arg1) throws AccessException {
				// TODO Auto-generated method stub
				return null;
			}
		});

		// This will end up calling resolve(context,"foo") on MyBeanResolver during evaluation
		Object bean = parser.parseExpression("@foo").getValue(context);
	}

	

}

abstract class StringUtils {
	
	private StringUtils() {}

    public static String reverseString(String input) {
        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            backwards.append(input.charAt(input.length() - 1 - i));
        }
        return backwards.toString();
    }
}
