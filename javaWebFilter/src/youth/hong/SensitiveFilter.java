package youth.hong;

public class SensitiveFilter implements Filter {

	@Override
	public void filter(Request request, Response response, FilterChain filterChain) {
		request.setRequestSting(request.getRequestSting().replace("����ɱ", "��ɱ"));
		filterChain.filter(request, response, filterChain);
		response.setResponseSting("SensitiveFilter");
	}

}
