package youth.hong;

public class SingleFilter implements Filter {

	@Override
	public void filter(Request request, Response response, FilterChain filterChain) {
		request.setRequestSting(request.getRequestSting().replace("'", ""));
		filterChain.filter(request, response, filterChain);
		response.setResponseSting("SingleFilter");
		
	}

}
