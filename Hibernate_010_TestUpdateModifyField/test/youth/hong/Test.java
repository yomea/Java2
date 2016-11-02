package youth.hong;


import org.hibernate.Query;
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
		s.setName("youth");
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
		session.save(t);
		session.save(s);
		t.setName("hong");
		session.flush();//强制update
		t.setName("youth");
		//s.setName("hong");
		//session.update(t);
		//session.update(t);//persistent 下会将当前的内存里的对象与缓存里的作比较，如果不同则进行update
		//session.saveOrUpdate(t);
		//session.saveOrUpdate("Teacher", t);//Teacher为实体名
		//session.delete(t);
		System.out.println(t.getId());//status : persistent 内存里有id值，数据库里有id，缓存里也有
		/*session.flush();*/
	}
	
	@After
	public void destory() {
		transaction.commit();//默认会flush
		session.close();
		//sf必须要在session后关闭否则会报错！！！
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("yy");
		session.update(s);
		session.getTransaction().commit();
		s.setAge(20);
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		//session2.merge(s);//合并，先select出所有的字段比较，只有发生更改的字段才会update
		//session2.update(s);//dynamic-update的时候此处会更新所有字段
		Query q = session2.createQuery("update Student s set s.name='haha' where s.id=1");
		q.executeUpdate();
		session2.getTransaction().commit();
		sf.close();
		System.out.println(t.getId());//status : detached 内存里有，缓存里没有，数据可有
		
	}

}
