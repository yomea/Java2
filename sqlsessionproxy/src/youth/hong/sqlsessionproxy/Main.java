package youth.hong.sqlsessionproxy;

import java.util.List;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SqlSession session = new SqlSession();
		
		MyInterface myInterface = session.getMapper(MyInterface.class);
		
		List<String> list = (List<String>)myInterface.query();
		
		System.out.println(list.size());
	}
}
