package youth.hong;

public class DoFilter {
	//Filter[] filters = new Filter[]{new HTMLFilter(), new SensitiveFilter(), new FaceFilter()};
 	public void doFilter(String msg) {
		FilterChain fc = new FilterChain();
		FilterChain fc2 = new FilterChain();
		Response response = new Response();
		
		Request request = new Request();
		request.setRequestSting(msg);
		fc2.addFilter(new SingleFilter());
		fc.addFilter(new FaceFilter())
		.addFilter(new HTMLFilter())
		.addFilter(fc2)
		.addFilter(new SensitiveFilter());
		fc.filter(request,response, fc);
		System.out.println(request.getRequestSting());
		System.out.println(response.getResponseSting());
	}
	
}
