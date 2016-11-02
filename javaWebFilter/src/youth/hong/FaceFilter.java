package youth.hong;

public class FaceFilter implements Filter {

	@Override
	public void filter(Request request, Response response, FilterChain filterChain) {
		request.setRequestSting(request.getRequestSting().replaceAll(":\\)", "^V^"));
		filterChain.filter(request, response, filterChain);
		response.setResponseSting("faceFilter");
	}

}
