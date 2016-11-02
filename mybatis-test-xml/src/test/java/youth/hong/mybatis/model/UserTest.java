package youth.hong.mybatis.model;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void test() {
		
		try {
			SqlSessionFactory f = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
			System.out.println(this.getClass().getClassLoader().getResource("").getPath());
			SqlSession session = f.openSession();
			User user = new User();
			user.setUsername("奥特曼");
			user.setAge(22);
			//session.insert(User.class.getName()+".add", user);
			List<User> users = session.selectList(User.class.getName()+".list", user);
			
			for (User user2 : users) {
				System.out.println(user2.getUsername());
			}
			
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
