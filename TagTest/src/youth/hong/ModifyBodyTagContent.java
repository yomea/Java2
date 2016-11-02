package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ModifyBodyTagContent extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	BodyContent bodyContent;
	
	@Override
	public void setBodyContent(BodyContent b) {
		bodyContent = b;
	}
	
	@Override
	public int doEndTag() throws JspException {
		String oldStr = bodyContent.getString();
		System.out.println(oldStr);
		String newStr = "www.imooc.com";
		JspWriter jspWriter = bodyContent.getEnclosingWriter();
		try {
			jspWriter.write(newStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ModifyBodyTagContent.EVAL_PAGE;
	}
	
}
