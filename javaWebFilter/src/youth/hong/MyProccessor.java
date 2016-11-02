package youth.hong;

public class MyProccessor {

	public static void main(String[] args) {
		String msg = "你好,:),''敏感''，被自杀，被自杀，<script>";
		new DoFilter().doFilter(msg);
	}

}
