package youth.hong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youth.hong.constant.Constant;
import youth.hong.model.Pager;
import youth.hong.model.Student;
import youth.hong.service.HibernateServiceImpl;
import youth.hong.service.Iservice;
import youth.hong.valdate.Validation;

public class ServletForSubList2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	Iservice service = new HibernateServiceImpl();
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = (Student)req.getSession().getAttribute("searchModel");
		req.setAttribute("stuName", student.getStuName());
		req.setAttribute("gender", student.getGender());
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student student = new Student();
		
		String username = req.getParameter("username");
		
		String genderStr = req.getParameter("gender");
		
		String pageNumStr = req.getParameter("pageNum");
		
		
		int pageNum = 0;
		
		
		if(pageNumStr != null && Validation.valdate(pageNumStr)) {
			pageNum = Integer.valueOf(pageNumStr);
			
		} 
		else {
			req.setAttribute("errorMsg", "²ÎÊý´íÎó£¡");
			req.getRequestDispatcher("/sublistStudent2.jsp").forward(req, resp);
		}

		
		if(username != null && genderStr != null && !"".equals(genderStr)) {
			if(Validation.valdate(genderStr)) {
				
				
				student.setStuName(username);
				int gender = Integer.valueOf(genderStr);
				gender = gender == 1 ? Constant.GENDER_MELA : gender == 2 ? Constant.GENDER_FEMELA : Constant.GENDER_DEFAULT;
				student.setGender(gender);
				
				
			}
			
		}
		Pager<Student> result = service.findStudents(student,pageNum, 5);
		
		req.setAttribute("result", result);
		
		req.getSession().setAttribute("searchModel", student);
		
		req.setAttribute("stuName", student.getStuName());
		req.setAttribute("gender", student.getGender());
		
		req.getRequestDispatcher("/sublistStudent2.jsp").forward(req, resp);
		
		
		
	}
	
	
	
}
