package youth.hong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

public class Test {
	SessionFactory sessionFactory = null;
	Session session = null;
	@Before
	public void ceateSessionFactory() {
		Configuration config = new org.hibernate.cfg.Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(ssr);
		
	}
	
	@org.junit.Test
	public void test() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Hello h = new Hello();
		
		session.saveOrUpdate(h);
		session.getTransaction().commit();
	}
	
	@After
	
	public void close() {
		session.close();
		sessionFactory.close();
	}
}
