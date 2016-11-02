package youth.hong;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(1);
		s.setName("youth");
		s.setAge(22);
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
