package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testOne2One() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = new User();
		user.setName("youth");
		Group group = new Group();
		group.setName("hong");
		user.setGroup(group);
		session.save(group);
		session.save(user);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
	@org.junit.Test

	public void testGetOne2Many() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		System.out.println(g.getUsers().size());
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	

	@org.junit.Test

	public void testLoadOne2Many() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Group g = (Group)session.load(Group.class, 1);
		System.out.println(g.getUsers().size());
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}

	@org.junit.Test

	public void testGetMany2One() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		System.out.println(user.getGroup().getName());
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
	@org.junit.Test

	public void testLoadtMany2One() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = (User)session.load(User.class, 1);
		System.out.println(user.getGroup().getName());
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
@org.junit.Test
	
	public void testSaveOne2Many() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user1 = new User();
		User user2 = new User();
		user2.setName("hong");
		user1.setName("youth");
		Group group = new Group();
		group.setName("hong");
		user1.setGroup(group);
		user2.setGroup(group);
		group.getUsers().add(user1);
		group.getUsers().add(user2);
		session.save(group);
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
}
