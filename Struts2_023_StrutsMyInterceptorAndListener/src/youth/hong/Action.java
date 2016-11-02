package youth.hong;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		/*for(int i = 0; i < 10000; i++) {
			System.out.println("I like java");
		}*/
		System.out.println("hello");
		return SUCCESS;
	}
	
	
	
}
