package youth.hong;

public class HTMLFilter implements Filter {

	@Override
	public String filter(String str) {
		str = str.replaceAll("<|>", "");
		return str;
	}

	
}
