package youth.hong;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

public class Test {
	
	private SessionFactory sf = null;
	private Session session = null;
	private Transaction transaction = null;
	
	@Before
	public void init() {
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistry sr =  new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		sf = cfg.buildSessionFactory(sr);
		session = sf.openSession();
		transaction = session.beginTransaction();
		
	}
	
	@org.junit.Test
	public void test() {
		Student s = new Student(1,"youth",22);
		TeacherPK tpk = new TeacherPK();
		tpk.setId(1);
		tpk.setName("youth");
		Teacher t = new Teacher(1,"youth",Title.C);
		/*session.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				conn.setAutoCommit(true);
				
			}
		});*/
		
		session.save(s);
		session.save(t);
		/*session.flush();*/
	}
	
	@After
	public void destory() {
		transaction.commit();
		
		session.close();
		//sf必须要在session后关闭否则会报错！！！
		sf.close();
	}

}
