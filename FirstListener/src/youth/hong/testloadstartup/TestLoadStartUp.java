package youth.hong.testloadstartup;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestLoadStartUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestLoadStartUp() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("loadonstartup");
	}
	
	
}
