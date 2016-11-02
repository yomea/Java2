package youth.hong.service;

import java.util.List;

import youth.hong.dao.IStudentsDao;
import youth.hong.dao.StudentsDaoImpl;
import youth.hong.model.Students;

public class StudentsServiceImpl implements IStudentsService {
	private IStudentsDao dao = null;
	
	public StudentsServiceImpl() {
		dao = new StudentsDaoImpl();
	}

	@Override
	public List<Students> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

	@Override
	public Students getStudentBySid(String sid) {
		// TODO Auto-generated method stub
		return dao.getStudentBySid(sid);
	}

	@Override
	public boolean deleteStudent(String sid) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(sid);
	}

	@Override
	public boolean modifyStudent(Students student) {
		// TODO Auto-generated method stub
		return dao.modifyStudent(student);
	}

	@Override
	public boolean addStudent(Students student) {
		// TODO Auto-generated method stub
		return dao.addStudent(student);
	}

}
