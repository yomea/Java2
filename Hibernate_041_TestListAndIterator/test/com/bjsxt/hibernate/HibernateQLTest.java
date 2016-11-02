package com.bjsxt.hibernate;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateQLTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		Configuration config = new Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sf = config.buildSessionFactory(ssr);
	}
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	/*@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}*/
	
	@Test
	public void testSave() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		for(int i=0; i<10; i++) {
			Category c = new Category();
			c.setName("c" + i);
			session.save(c);
		}
		
		for(int i=0; i<10; i++) {
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			session.save(t);
			
		}
		
		for(int i=0; i<10; i++) {
			
			Topic t = new Topic();
			t.setId(1);
			Msg m = new Msg();
			m.setCont("m" + i);
			m.setTopic(t);
			session.save(m);
			
		}
		
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	//is empty and is not empty
	//query by criteria query by example
	@Test
	public void testList() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		
		for(Object o : q.list()) {
			Category t = (Category)o;
			System.out.println(t.getId() + "-" + t.getName());
		}
		Query q2 = session.createQuery("from Category");
		for(Object o : q2.list()) {
			Category t = (Category)o;
			System.out.println(t.getId() + "-" + t.getName());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testIterator() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Category");
		Iterator<Category> categories = q.iterate();
		while(categories.hasNext()) {
			Category c = (Category)categories.next();
			System.out.println(c.getName());
		}
		//System.out.println(categories.hasNext());
		Iterator<Category> categories2 = q.iterate();
		while(categories2.hasNext()) {
			Category c = (Category)categories2.next();
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
