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
		session.setFlushMode(FlushMode.COMMIT);//auto对查询语句，commit，flush都会进行缓存的清理，即整理；对计划发出sql语句的进行发出语句。
		WorldPK wp = new WorldPK();//commit除了查询语句不会发出sql语句，其他的都会。
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
		//注意这里的version与程序中的@version是不一样的。后者是用来处理并发操作的。
		//代理主键是通过判断id是否为null来判断 是否要save还是update。
		session.saveOrUpdate(w);//在自然主键下在当前配置中是根据version的unsaved-value来判断是否是save还是update。
		//session.save(w);
		World wd = (World) session.get(World.class,wp);
		System.out.println(wd.getVersion());//立即发出sql语句
		wd.setVersion(22);
		session.update(wd);//这条update语句在testtest。。。语句后说明它是在commit后执行的。
		//session.delete(wd);同一个session里update和delete听一个主键，即同一个对象那么只执行delete语句。
		System.out.println("testtestetsetstetsttestetstetstetsetetsetset");
		/*Query q = session.createQuery("from Hello");
		List list = q.list();
		Iterator it = q.iterate();
		for (Object hello : list) {
			System.out.println(((Hello)hello).getNam());
		}*/
		session.getTransaction().commit();//清理缓存，所谓清理其实就是对对象属性进行脏检查
		World wdd = (World) session.get(World.class,wp);
		System.out.println(wd == wdd);
	}
	
	@After
	public void close() {
		session.close();
		sessionFactory.close();
	}
}
