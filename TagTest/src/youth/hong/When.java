package youth.hong;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class When extends SimpleTagSupport {
	
	private boolean text;
	
	
	public void setText(boolean text) {
		this.text = text;
	}



	@Override
	public void doTag() throws JspException, IOException {
		System.out.println(text);
		if(text){
			System.out.println(text);
			this.getJspBody().invoke(null);
			Choose choose = (Choose) this.getParent();
			choose.setFlag(true);
		}

	}
}
