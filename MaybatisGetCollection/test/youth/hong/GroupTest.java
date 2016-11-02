package youth.hong;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GroupTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void queryTest() {
		SqlSession session = sqlSessionFactory.openSession();
		GroupDao groupDao = session.getMapper(GroupDao.class);
		Group group = groupDao.query(1);
		System.out.println(group);
	}
	
	@After
	public void destroy() {
	}
}
