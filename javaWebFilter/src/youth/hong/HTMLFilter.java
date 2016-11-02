package youth.hong;

public class HTMLFilter implements Filter {

	@Override
	public void filter(Request request, Response response, FilterChain filterChain) {
		request.setRequestSting(request.getRequestSting().replaceAll("<|>", ""));
		filterChain.filter(request, response, filterChain);
		response.setResponseSting("HTMLFilter");
	}

	
}
