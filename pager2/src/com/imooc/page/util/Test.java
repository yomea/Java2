package com.imooc.page.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imooc.page.HibernateSessionFactory;
import com.imooc.page.dao.HibernateStudentDaoImpl;
import com.imooc.page.dao.StudentDao;
import com.imooc.page.model.Pager;
import com.imooc.page.model.Student;

public class Test {

	public void baseTest() {
		Session session = HibernateSessionFactory.getSession();
		Student stu = (Student) session.get(Student.class, 1);
		System.out.println(stu);
		session.close();
	}

	public static void testStuList() {
		Student searchModel = new Student();
		searchModel.setGender(1);
		searchModel.setStuName("李");
		StudentDao dao = new HibernateStudentDaoImpl();
		Pager<Student> pager = dao.findStudent(searchModel, 1, 10);

		System.out.println(pager.getCurrentPage() + "--"
				+ pager.getPageSize() + "--" + pager.getTotalPage() + "--"
				+ pager.getTotalRecord() + "");
		
		List<Student> resultList = pager.getDataList();
		if(null!=resultList){
			for(Student st : resultList){
				System.out.println(st);
			}
		}
	}
	
	public static void testSave(){
		Student stu = new Student();
		stu.setStuName("董博");
		stu.setAge(56);
		stu.setGender(1);
		stu.setAddress("北京市菜市口");
		Session s = null;
		try{
			s = HibernateSessionFactory.getSession();
			Transaction trans = s.beginTransaction();
			s.save(stu);
			trans.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}

	public static void main(String[] args) {
		testStuList();
		//testSave();
	}
}
