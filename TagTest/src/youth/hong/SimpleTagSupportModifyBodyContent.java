package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagSupportModifyBodyContent extends SimpleTagSupport {
	

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		
	  /**
	   *    这样获取标签体的内容
	   
	   *    JspFragment jspFragment = getJspBody();
		
	   *    StringWriter stringWriter = new StringWriter();
			
	   *	jspFragment.invoke(stringWriter);
			
	   *	String content = stringWriter.toString();
			
	   *	System.out.println(content);
	   */
		String content = "www.imooc.com";
		
		pageContext.getOut().write(content);
		
	}
}
