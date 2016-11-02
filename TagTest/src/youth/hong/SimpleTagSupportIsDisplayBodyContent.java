package youth.hong;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagSupportIsDisplayBodyContent extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		//http://localhost:8888/TagTest/simpletagisdisplaybodycontent.jsp?name=%22%22
		String name = request.getParameter("name");
		
		if(name != null) {
			this.getJspBody().invoke(null);
		}
		
	}
}
