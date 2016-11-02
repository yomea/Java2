package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testSave() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Teacher teacher = new Teacher();
		teacher.setName("youth");
		Student student = new Student();
		student.setName("hong");
		student.setScore(100);
		teacher.setTitle("¸ß¼¶");
		//session.save(group);
		session.save(student);
		session.save(teacher);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
@org.junit.Test
	
	public void testGet() {
		testSave();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Student student = (Student)session.load(Student.class,1);
		System.out.println(student.getScore());
		Person person = (Person)session.load(Person.class,2);
		System.out.println(person.getName());
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
	
}
