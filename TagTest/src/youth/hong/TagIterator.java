package youth.hong;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagIterator extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String[] items;
	private String var;
	int index = 1;
	
	public void setItems(String[] items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public int doStartTag() throws JspException {
		if(items == null && items.length <= 0) {
			
			return TagIterator.SKIP_BODY;
		}
		pageContext.setAttribute(var, items[0]);
		return TagIterator.EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		if(index < items.length) {
			
			pageContext.setAttribute(var, items[index]);
			index++;
			return TagIterator.EVAL_BODY_AGAIN;
		} else {
			return TagIterator.SKIP_BODY;
		}
		
	}
	
	
	
}
