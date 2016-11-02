package com.imooc.page.service;

import com.imooc.page.dao.HibernateStudentDaoImpl;
import com.imooc.page.dao.StudentDao;
import com.imooc.page.model.Pager;
import com.imooc.page.model.Student;

public class HibernateStudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public HibernateStudentServiceImpl(){
		studentDao = new HibernateStudentDaoImpl();
	}
	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		Pager<Student> result = studentDao.findStudent(searchModel, pageNum,
				pageSize);
		return result;
	}

}
