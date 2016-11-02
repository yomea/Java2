/*package youth.hong;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class TestSession {
	
	@org.junit.Test
	public void testOpenSession() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println(session1 == session2);//false
		if(session != null) {
			System.out.println("��ȡsession�ɹ���");
			session.close();
			sessionFactory.close();
			session = null;
			sessionFactory = null;
		}
		else {
			System.out.println("��ȡsessionʧ�ܣ�");
		}
		
	}
	
	@org.junit.Test
	public void testGetCurrentSession() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session1 = sessionFactory.getCurrentSession();
		Session session2 = sessionFactory.getCurrentSession();
		System.out.println(session1 == session2);//true
		if(session != null) {
			System.out.println("��ȡsession�ɹ���");
			//��openSession��ͬ�����������ύ����Զ��ر�session��
		}
		else {
			System.out.println("��ȡsessionʧ�ܣ�");
		}
		
	}
	
	@org.junit.Test
	public void testSessionWithOpSession() {
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
			Session session1 = sessionFactory.openSession();
			Transaction transaction = session1.beginTransaction();
			Teacher t = new Teacher(1,"youth","�߼�");
			session1.doWork(new Work() {
				
				@Override
				public void execute(Connection conn) throws SQLException {
					System.out.println("connection hashCode��" + conn.hashCode());
					
				}
				
			});
			session1.save(t);
			transaction.commit();
			//session1.close();
			Session session2 = sessionFactory.openSession();
			transaction = session2.beginTransaction();
			t = new Teacher(2,"hong","��ʦ");
			session2.doWork(new Work() {
				
				@Override
				public void execute(Connection conn) throws SQLException {
					System.out.println("connection hashCode��" + conn.hashCode());
					
				}
				
			});
			
			session2.save(t);
			transaction.commit();
			
			
			
	}
	
	@org.junit.Test
	public void testSessionWithGetCurrentSession() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session1 = sessionFactory.getCurrentSession();
		
		
		Transaction transaction = session1.beginTransaction();
		Teacher t = new Teacher(1,"youth","�߼�");
		session1.doWork(new Work() {

			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println("connection hashCode��" + conn.hashCode());
				
			}
			
		});
		session1.save(t);
		transaction.commit();
		Session session2 = sessionFactory.getCurrentSession();
		transaction = session2.beginTransaction();
		t = new Teacher(2,"hong","��ʦ");
		session2.doWork(new Work() {

			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println("connection hashCode��" + conn.hashCode());
				
			}
			
		});
		
		session2.save(t);
		transaction.commit();
		
	}
	
}
*/