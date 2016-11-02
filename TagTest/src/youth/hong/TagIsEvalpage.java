package youth.hong;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagIsEvalpage extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
		String from = request.getHeader("referer");
		
		String url = request.getScheme() + "://" + request.getServerName();
		
		if(from != null && from.startsWith(url)) {
			return TagIsEvalpage.EVAL_PAGE;
		} else {
			try {
				pageContext.getOut().print("error!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return TagIsEvalpage.SKIP_PAGE;
	}
	
}
