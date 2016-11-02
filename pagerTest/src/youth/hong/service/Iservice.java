package youth.hong.service;

import youth.hong.model.Pager;
import youth.hong.model.Student;

public interface Iservice {
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize);
}
