package youth.hong;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testSaveMany2One() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = new User();
		user.setName("youth");
		Group group = new Group();
		group.setName("hong");
		user.setGroup(group);
		//session.save(group);
		session.save(user);
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
		group.getUsers().put(8, user1);
		group.getUsers().put(2, user2);
		session.save(group);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}

@org.junit.Test
	
	public void testGetMap() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		for(Map.Entry<Integer, User> entry : g.getUsers().entrySet()) {
			
			System.out.println(entry.getValue().getName());
		}
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
	@org.junit.Test
	
	public void testGetOne2Many() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.get(Group.class, 1);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
@org.junit.Test
	
	public void testUpdate() {
		testSaveOne2Many();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		user.setName("lisa");
		user.getGroup().setName("ji");//cascade设置为merage或者其他时需要在调用相对应的方法才有效
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}

@org.junit.Test

public void testDelete() {
	testSaveOne2Many();
	Session session = HibernateUtil.getSession();
	session.beginTransaction();
	Query q = session.createQuery("delete from User where id=1");
	q.executeUpdate();
	/*User user = (User)session.load(User.class,1);
	user.setGroup(null);
	session.delete(user);*///此法似乎已失效，会报错
	session.getTransaction().commit();
	HibernateUtil.close(session);
}
	
	@org.junit.Test
	
	public void testGetMany2One() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.get(User.class, 1);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
}
