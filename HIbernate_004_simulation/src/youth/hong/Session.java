package youth.hong;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class Session {
	
	
	Map<String,String> m;
	String[] methodNames;
	
	public Session() {
		m = new HashMap<String,String>();
		m.put("id", "id");
		m.put("name", "name");
		m.put("age", "age");
		methodNames = new String[m.size()];

	}
	
	
	public void save(Student s) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","root","root");
		String sql = createSql();
		PreparedStatement pStmt = conn.prepareStatement(sql);
		Class<? extends Student> student = s.getClass();
		for(int i = 0; i < methodNames.length; i++) {
			String method = "get" + Character.toUpperCase((methodNames[i].charAt(0))) + methodNames[i].substring(1);
			Method m = student.getMethod(method);
			Class<?> returnValue = m.getReturnType();
			String returnName = returnValue.getName();
			//System.out.println(returnName);
			if(returnName.equals("java.lang.String")) {
				String x = (String)m.invoke(s);
				pStmt.setString(i+1, x);
			} else if(returnName.equals("int")) {
				int x = (int)m.invoke(s);
				pStmt.setInt(i+1, x);
			}
		}
		pStmt.executeUpdate();
		
	}
	
	public String createSql() {
		String str1 = "";
		String str2 = "";
		int index = 0;
		for(String string : m.keySet()) {

			str1 += string + ",";
			methodNames[index] = m.get(string);
			index++;
			
		}
		str1 = str1.substring(0,str1.length()-1);
		for(int i = 0; i < m.size(); i++) {
			str2 += "?,";
		}
		str2 = str2.substring(0,str2.length()-1);
		String sql = "insert into student2" +"(" + str1 + ")" +" values (" + str2 + ")";
		System.out.println(sql);
		return sql;
	}
}
