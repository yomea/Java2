package youth.hong;

public class MyProccessor {

	public static void main(String[] args) {
		String msg = "���,:),''����''������ɱ������ɱ��<script>";
		String str = new DoFilter().doFilter(msg);
		System.out.println(str);
	}

}
