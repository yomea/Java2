package youth.hong;

public class SensitiveFilter implements Filter {

	@Override
	public String filter(String str) {
		str = str.replace("����ɱ", "��ɱ");
		return str;
	}

}
