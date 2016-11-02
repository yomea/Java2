package youth.hong.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import youth.hong.model.Students;
import youth.hong.service.IStudentsService;
import youth.hong.service.StudentsServiceImpl;

public class StudentsAction extends SuperAction implements ModelDriven<Students> {

	private static final long serialVersionUID = 3L;
	
	private Students student = new Students();
	
	
	private List<Students> students;
	
	IStudentsService service = new StudentsServiceImpl();
	
//	@SkipValidation
	public String query() {
		
		students = service.getAllStudents();
		session.setAttribute("students_list", students);
		
		return "querySuccess";
	}
	
	public String add() {
		if(service.addStudent(student)) {
			return "addSuccess";
		}
		else {
			return "error";
		}
		
	}
	@SkipValidation
	public String delete() {
		if(service.deleteStudent(student.getSid())) {
			System.out.println("aosdfoiasjd");
			return "deleteSuccess";
		}
		else {
			return "error";
		}
		
	}
	
	public String modify() {
		Students stu = service.getStudentBySid(student.getSid());
		if(session.getAttribute("modify_students") != null) {
			session.removeAttribute("modify_students");
			
		}
		session.setAttribute("modify_students", stu);
		return "modify";
	}
	
	public String save() {
		if(service.modifyStudent(student)){
			return "modifySuccess";
		}
		else {
			return "error";
		}
	}
	
	public List<Students> getStudents() {
		return students;
	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return student;
	}


}
