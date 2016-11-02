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
	Teacher t = null;
	
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
		t = new Teacher();
		t.setName("youth");
		t.setTitle(Title.C);
		/*session.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				conn.setAutoCommit(true);
				
			}
		});*/
		System.out.println(t.getId());//status : transient 内存里有teacher对象，缓存里没有id，数据库里没有
		session.save(s);
		session.save(t);
		//t.setName("hong");
		//session.update(t);
		//session.saveOrUpdate(t);
		session.saveOrUpdate("Teacher", t);//Teacher为实体名
		//session.delete(t);
		System.out.println(t.getId());//status : persistent 内存里有id值，数据库里有id，缓存里也有
		/*session.flush();*/
	}
	
	@After
	public void destory() {
		transaction.commit();
		
		session.close();
		//sf必须要在session后关闭否则会报错！！！
		sf.close();
		System.out.println(t.getId());//status : detached 内存里有，缓存里没有，数据可有
	}

}
