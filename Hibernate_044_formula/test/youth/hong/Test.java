package youth.hong;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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
		/*Hello h = new Hello();
		
		session.saveOrUpdate(h);*/
		
		World w = new World();
		w.setName("dashijie");
		for(int i = 0; i < 10; i++) {
			Hello h = new Hello();
			char c = 'a';
			h.setNam(Character.toString(c++));
			h.setWorld(w);
			w.getHellos().add(h);
		}
		
		
		session.save(w);
		Query q = session.createQuery("from World");
		List list = q.list();
		Iterator it = q.iterate();
		for (Object hello : list) {
			System.out.println(((World)hello).getAvg());
		}
		session.getTransaction().commit();
	}
	
	@After
	
	public void close() {
		session.close();
		sessionFactory.close();
	}
}
