package youth.hong;

public class SingleFilter implements Filter {

	@Override
	public String filter(String str) {
		str = str.replace("'", "");
		return str;
	}

}
