package youth.hong.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import youth.hong.model.Student;

public class HibernateUtil {
	
	private static Session session;
	
	private static SessionFactory sessionFactory;
	
	static {
		
		/*Configuration config = new org.hibernate.cfg.Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(ssr);*/
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			//StandardServiceRegistryBuilder.destroy( registry );
		}
		
	}

	public static Session getSession() {
		
		
		return session;
	}


	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void close() {
		session.close();
	}
	
	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Student student = session.get(Student.class, 2);
		
		System.out.println(student);
		session.getTransaction().commit();
		HibernateUtil.close();
	}

	
}
