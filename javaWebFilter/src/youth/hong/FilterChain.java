package youth.hong;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

	List<Filter> filters = new ArrayList<Filter>();
	int index = 0;
	
	
	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}



	@Override
	public void filter(Request request, Response response, FilterChain filterChain) {
		
		if(index == filters.size()) {
			return; 
		}
		Filter f = filters.get(index);
		index++;
		f.filter(request, response, filterChain);
		
	}

}
