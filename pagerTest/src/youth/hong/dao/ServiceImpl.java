package youth.hong.dao;

import java.sql.SQLException;

import youth.hong.model.Pager;
import youth.hong.model.Student;
import youth.hong.service.DaoImpl;
import youth.hong.service.Iservice;

public class ServiceImpl implements Iservice {

	@Override
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize) {
		Idao dao = new DaoImpl();
		
		return dao.findStudents(searchModel, pageNum, pageSize);
	}
	
	public static void main(String[] args) throws SQLException {
		Pager<Student> pager = new DaoImpl().findStudents(new Student(), 2, 5);
		
		for (Student student : pager.getDataList()) {
			System.out.println(student);
		}
	}
	

}
