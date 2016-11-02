package youth.hong.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import youth.hong.dao.UsersDaoImpl;
import youth.hong.model.Students;
import youth.hong.model.Users;
import youth.hong.service.IUsersService;
import youth.hong.service.UsersServiceImpl;

public class HibernateUtilTest {

	@Test
	public void testGetSession() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Users user = session.get(Users.class, 1);
		/*
		 * SchemaExport export = new SchemaExport(); export.create(targetTypes,
		 * metadata);
		 */
		System.out.println(user);
		session.getTransaction().commit();

	}

	@Test
	public void test() {
		IUsersService service = new UsersServiceImpl();
		Users user = new Users(1, "zhangsan", "123456");
		boolean isExist = service.isLogin(user);
		System.out.println(isExist);
	}

	
}
