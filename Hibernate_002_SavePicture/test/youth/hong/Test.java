package youth.hong;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;


public class Test {
	
	private SessionFactory sf = null;
	private Session session = null;
	private Transaction transaction = null;
	
	@Before
	public void init() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr =  new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sf = cfg.buildSessionFactory(sr);
		session = sf.openSession();
		transaction = session.beginTransaction();
		
	}
	
	@org.junit.Test
	public void test() {
		Student s = new Student();
		s.setAge(22);
		s.setName("youth");

		session.save(s);
	
	}
	
	@org.junit.Test
	public void testBlob() throws Exception {
		Student s = new Student(1,"youth",22);
		File f = new File("d:" + File.separator + "warArea.jpg");
		FileInputStream input = new FileInputStream(f);
		Blob image = Hibernate.getLobCreator(session).createBlob(input, input.available());
		s.setPicture(image);
		session.save(s);
		input.close();
	}
	
	@org.junit.Test
	public void testReadBlob() throws Exception {
		Student s = (Student)session.get(Student.class, 1);
		Blob image = s.getPicture();
		InputStream input = image.getBinaryStream();
		File f = new File("d:" + File.separator + "warAreaBak.jpg");
		OutputStream output = new FileOutputStream(f);
		byte[] buff = new byte[input.available()];
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
	}
	
	@org.junit.Test
	public void testComponent() throws Exception {
		Student s = new Student(1,"youth",22);
		Address address = new Address("∏”÷›");
		s.setAddress(address);
		session.save(s);
		
	}
	
	@org.junit.Test
	public void testLoadStudent() {
		Student s = (Student)session.load(Student.class, 1);
		System.out.println(s);
	}
	
	@org.junit.Test
	public void testGetStudent() {
		Student s = (Student)session.get(Student.class, 1);
		System.out.println(s);
	}
	
	@org.junit.Test
	public void testUpdate() {
		Student s = (Student)session.get(Student.class, 1);
		s.setName("hong");
		session.update(s);
	}
	
	@org.junit.Test
	public void testDelete() {
		Student s = (Student)session.get(Student.class, 1);
		session.delete(s);
	}
	
	@After
	public void destory() {
		transaction.commit();
		
		session.close();
		
		sf.close();
	}

}
