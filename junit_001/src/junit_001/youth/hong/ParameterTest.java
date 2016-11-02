package junit_001.youth.hong;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import youth.hong.Caculate;

@RunWith(Parameterized.class)
public class ParameterTest {

	int excepect = 0;
	
	int input1 = 0;
	
	int input2 = 0;
	
	@Parameters
	public static Collection<Object[]> get() {
		return Arrays.asList(new Object[][] {
			{3,2,1},
			{5,3,2},
			{200,150,50}
		});
	}

	public ParameterTest(int excepect, int input1, int input2) {
		super();
		this.excepect = excepect;
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Test
	public void parameterTest() {
		Assert.assertEquals(excepect,new Caculate().add(input1, input2));
		Object i = 7;
		int a = (int)i;
		System.out.println("ÆÚÍûÖµ" + excepect + "....." + (a*2));
	}
	
}
