package youth.hong.util;

import org.junit.Test;

public class SqlSessionFactoryUtilTest {
	@Test
	public void getSqlSessionFactoryTest() {
		SqlSessionFactoryUtil.getSqlSessionFactory();
		System.out.println(SqlSessionFactoryUtil.getSqlSessionFactory());
	}
}
