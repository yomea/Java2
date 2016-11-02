package youth.hong;

import java.net.MalformedURLException;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;

public class Test {
	SessionFactory sessionFactory = null;
	Session session = null;
	@Before
	public void ceateSessionFactory() throws MalformedURLException {
		/*Configuration config = new org.hibernate.cfg.Configuration().configure();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(ssr);*/
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			//StandardServiceRegistryBuilder.destroy( registry );
		}
		
	}
	
	@org.junit.Test
	public void test() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		/*Hello h = new Hello();
		session.saveOrUpdate(h);*/
		session.setFlushMode(FlushMode.COMMIT);//auto�Բ�ѯ��䣬commit��flush������л���������������Լƻ�����sql���Ľ��з�����䡣
		WorldPK wp = new WorldPK();//commit���˲�ѯ��䲻�ᷢ��sql��䣬�����Ķ��ᡣ
		wp.setId(1);
		wp.setName("dada");
		World w = new World();
		w.setWorldPK(wp);
		//w.setVersion(2);
		char c = 'a';
		for(int i = 0; i < 10; i++) {
			Hello h = new Hello();
			
			h.setNam(Character.toString(c++));
			h.setWorld(w);
			w.getHellos().add(h);
		}
		//ע�������version������е�@version�ǲ�һ���ġ����������������������ġ�
		//����������ͨ���ж�id�Ƿ�Ϊnull���ж� �Ƿ�Ҫsave����update��
		session.saveOrUpdate(w);//����Ȼ�������ڵ�ǰ�������Ǹ���version��unsaved-value���ж��Ƿ���save����update��
		//session.save(w);
		World wd = (World) session.get(World.class,wp);
		System.out.println(wd.getVersion());//��������sql���
		wd.setVersion(22);
		session.update(wd);//����update�����testtest����������˵��������commit��ִ�еġ�
		//session.delete(wd);ͬһ��session��update��delete��һ����������ͬһ��������ôִֻ��delete��䡣
		System.out.println("testtestetsetstetsttestetstetstetsetetsetset");
		/*Query q = session.createQuery("from Hello");
		List list = q.list();
		Iterator it = q.iterate();
		for (Object hello : list) {
			System.out.println(((Hello)hello).getNam());
		}*/
		session.getTransaction().commit();//�����棬��ν������ʵ���ǶԶ������Խ�������
		World wdd = (World) session.get(World.class,wp);
		System.out.println(wd == wdd);
	}
	
	@After
	public void close() {
		session.close();
		sessionFactory.close();
	}
}
