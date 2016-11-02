package youth.hong.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import youth.hong.entity.User;

public class DatabaseUtil {
	
	private static final String url = "jdbc:mysql://localhost:3306/easyui";
	private static final String username = "root";
	private static final String password = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn() {
		Connection conn = null;
		if(conn == null){
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return conn;
		
	}
	
	public static <E> List<E> $(Connection conn, String sql, List<Object> params, Class<E> clazz) {
		PreparedStatement pStmt = null;
		List<E> list = new ArrayList<E>(); 
		try {
			pStmt = conn.prepareStatement(sql);
			if(params != null && params.size() > 0) {
				
				for(int i = 0; i < params.size(); i++) {
					pStmt.setObject(i + 1, params.get(i));
					
				}
				
			}
			System.out.println(sql);
			ResultSet rs = pStmt.executeQuery();
			
			ResultSetMetaData m = rs.getMetaData();
			int count = m.getColumnCount();
			while(rs.next()) {
				E instance =  clazz.newInstance();
				for(int i = 1; i <= count; i++) {
					String columnName = m.getColumnName(i);
					try {
						Field field = clazz.getDeclaredField(columnName);
						field.setAccessible(true);
						field.set(instance, rs.getObject(columnName));
					} catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
				
				list.add(instance);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
