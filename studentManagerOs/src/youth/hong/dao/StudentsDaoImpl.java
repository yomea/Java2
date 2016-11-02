package youth.hong.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import youth.hong.model.Students;
import youth.hong.util.HibernateUtil;

public class StudentsDaoImpl implements IStudentsDao {

	public Session getSession() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Students> getAllStudents() {
		Session session = this.getSession();
		List<Students> students = null;
		try {
			String hqlStr = "from Students";
			Query query = session.createQuery(hqlStr);
			
			students = query.list();
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().commit();
			
		}finally {
			
		}

		return students;
	}

	@Override
	public Students getStudentBySid(String sid) {
		Session session = this.getSession();
		
		return session.get(Students.class, sid);
	}

	@Override
	public boolean deleteStudent(String sid) {
		Session session = this.getSession();
		String hql = "delete from Students where sid=?";
		Query query = session.createQuery(hql).setParameter(0, sid);
		int rows = query.executeUpdate();
		System.out.println(rows);
		session.getTransaction().commit();
		if(rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyStudent(Students student) {
		Session session = this.getSession();
		session.merge(student);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean addStudent(Students student) {
		Session session = this.getSession();
		String sid = (String) session.save(student);
		session.getTransaction().commit();
		System.out.println(sid);
		if(sid != null) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<Students> students = new StudentsDaoImpl().getAllStudents();
		
		for(Students student : students) {
			System.out.println(student);
		}
	}

}
