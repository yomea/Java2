package youth.hong.service;

import java.util.List;

import youth.hong.model.Students;

public interface IStudentsService {
	
public List<Students> getAllStudents();
	
	public Students getStudentBySid(String sid);
	
	public boolean deleteStudent(String sid);
	
	public boolean modifyStudent(Students student);
	
	public boolean addStudent(Students student);
	
	
}
