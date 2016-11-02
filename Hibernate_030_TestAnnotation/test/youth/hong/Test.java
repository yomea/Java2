package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testOne2One() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Group group = new Group();
		group.setName("hong");
		session.save(group);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
}
