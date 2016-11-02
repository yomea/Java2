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
		System.out.println(t.getId());//status : transient �ڴ�����teacher���󣬻�����û��id�����ݿ���û��
		session.save(t);
		session.save(s);
		t.setName("hong");
		session.flush();//ǿ��update
		t.setName("youth");
		//s.setName("hong");
		//session.update(t);
		//session.update(t);//persistent �»Ὣ��ǰ���ڴ���Ķ����뻺��������Ƚϣ������ͬ�����update
		//session.saveOrUpdate(t);
		//session.saveOrUpdate("Teacher", t);//TeacherΪʵ����
		//session.delete(t);
		System.out.println(t.getId());//status : persistent �ڴ�����idֵ�����ݿ�����id��������Ҳ��
		/*session.flush();*/
	}
	
	@After
	public void destory() {
		transaction.commit();//Ĭ�ϻ�flush
		session.close();
		//sf����Ҫ��session��رշ���ᱨ������
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("yy");
		session.update(s);
		session.getTransaction().commit();
		s.setAge(20);
		Session session2 = sf.getCurrentSession();
		session2.beginTransaction();
		//session2.merge(s);//�ϲ�����select�����е��ֶαȽϣ�ֻ�з������ĵ��ֶβŻ�update
		//session2.update(s);//dynamic-update��ʱ��˴�����������ֶ�
		Query q = session2.createQuery("update Student s set s.name='haha' where s.id=1");
		q.executeUpdate();
		session2.getTransaction().commit();
		sf.close();
		System.out.println(t.getId());//status : detached �ڴ����У�������û�У����ݿ���
		
	}

}
