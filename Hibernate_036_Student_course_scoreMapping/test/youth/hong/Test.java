package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testSave() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
@org.junit.Test
	
	public void testGet() {
		testSave();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}

	

	
}
