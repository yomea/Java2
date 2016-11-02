package youth.hong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Session session;
	private static SessionFactory sessionFactory = null;
	
	static {
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr  = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(ssr);
		
		
	}
	
	public static Session getSession() {
		 session = sessionFactory.openSession();
		 return session;
				
	}
	
	public static void close(Session session) {
		session.close();
	}
}
