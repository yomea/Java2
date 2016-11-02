package youth.hong;

public class DoFilter {
	//Filter[] filters = new Filter[]{new HTMLFilter(), new SensitiveFilter(), new FaceFilter()};
 	public String doFilter(String msg) {
		FilterChain fc = new FilterChain();
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new SingleFilter());
		fc.addFilter(new FaceFilter())
		.addFilter(new HTMLFilter())
		.addFilter(fc2)
		.addFilter(new SensitiveFilter());
		msg = fc.filter(msg);
		return msg;
	}
	
}
