package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testOne2One() {
		Session session = HibernateUtil.getSession();
		HibernateUtil.close(session);
	}
	
	@org.junit.Test
	public void testSave() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Group g = new Group();
		g.setName("java“ª∞‡");
		User user = new User();
		user.setName("youth");
		g.getUsers().add(user);
		user.setGroup(g);
		session.save(g);
		session.getTransaction().commit();
		session.close();
		
	}
}
