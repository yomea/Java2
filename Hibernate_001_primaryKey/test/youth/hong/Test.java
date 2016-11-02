package youth.hong;


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
		Student s1 = new Student();
		s1.setAge(22);
		s1.setName("youth");
		Student s2 = new Student();
		s2.setAge(22);
		s2.setName("hong");
		//Teacher t = new Teacher(1,"hong","高级");
		/*session.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				conn.setAutoCommit(true);
				
			}
		});*/
		
		session.save(s1);
		session.save(s2);
		//session.save(t);
		//session.flush();
	}
	
	@After
	public void destory() {
		transaction.commit();
		
		session.close();
		//sf必须要在session后关闭否则会报错！！！
		sf.close();
	}

}
