package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagSupportIteratoin extends SimpleTagSupport {
	
	private String[] items;
	
	private String var;
	
	public void setItems(String[] items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		PageContext pageContext = (PageContext) this.getJspContext();
		
		for(int i = 0; i < items.length; i++) {
			pageContext.setAttribute(var, items[i]);
			this.getJspBody().invoke(null);
		}
	}
}
