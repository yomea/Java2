package youth.hong;

public class FaceFilter implements Filter {

	@Override
	public String filter(String str) {
		str = str.replaceAll(":\\)", "^V^");
		return str;
	}

}
