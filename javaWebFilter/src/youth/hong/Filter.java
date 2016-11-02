package youth.hong;

public interface Filter {
	public void filter(Request request, Response response, FilterChain filterChain);
}
