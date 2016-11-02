package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Choose extends SimpleTagSupport {
	
	private boolean flag = false;
	
	

	public boolean isFlag() {
		return flag;
	}



	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	@Override
	public void doTag() throws JspException, IOException {

		this.getJspBody().invoke(null);
		
		
		
	}
}
