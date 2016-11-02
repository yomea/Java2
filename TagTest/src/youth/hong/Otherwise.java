package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Otherwise extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		Choose choose = (Choose) this.getParent();
		if(!choose.isFlag()){
			this.getJspBody().invoke(null);
		}

		
		
		
		
	}
}
