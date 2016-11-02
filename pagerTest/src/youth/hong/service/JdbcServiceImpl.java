package youth.hong.service;

import java.sql.SQLException;

import youth.hong.dao.Idao;
import youth.hong.dao.JdbcDaoImpl;
import youth.hong.model.Pager;
import youth.hong.model.Student;

public class JdbcServiceImpl implements Iservice {

	@Override
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize) {
		Idao dao = new JdbcDaoImpl();
		
		return dao.findStudents(searchModel, pageNum, pageSize);
	}
	
	public static void main(String[] args) throws SQLException {
		Pager<Student> pager = new JdbcServiceImpl().findStudents(new Student(), 3, 5);
		
		for (Student student : pager.getDataList()) {
			System.out.println(student);
		}
	}
	
}
