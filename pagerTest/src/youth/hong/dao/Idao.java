package youth.hong.dao;

import youth.hong.model.Pager;
import youth.hong.model.Student;

public interface Idao {
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize);
}
