package youth.hong;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

	List<Filter> filters = new ArrayList<Filter>();
	
	
	
	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}



	@Override
	public String filter(String str) {
		for (Filter filter : filters) {
			str = filter.filter(str);
		}
		return str;
	}

}
