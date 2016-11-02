package youth.hong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(ssr);
		session = sessionFactory.openSession();
	}	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		return session;
	}
	
	public static void close(Session session) {
		if(session != null) {
			session.close();
			session = null;
		}
	}
	
			
}
