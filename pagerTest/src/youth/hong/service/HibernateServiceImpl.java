package youth.hong.service;

import java.sql.SQLException;

import youth.hong.dao.HibernateDaoImpl;
import youth.hong.dao.Idao;
import youth.hong.model.Pager;
import youth.hong.model.Student;

public class HibernateServiceImpl implements Iservice {
	
	
	private Idao dao = null; 

	public HibernateServiceImpl() {
		super();
		dao = new HibernateDaoImpl();
	}

	@Override
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize) {
		
		return dao.findStudents(searchModel, pageNum, pageSize);
	}
	
	public static void main(String[] args) throws SQLException {
		Pager<Student> pager = new HibernateServiceImpl().findStudents(new Student(), 3, 5);
		
		for (Student student : pager.getDataList()) {
			System.out.println(student);
		}
	}

}
