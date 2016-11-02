package youth.hong.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Dbutil {
	private static Connection conn;
	private static PreparedStatement pStmt;
	private static ResultSet rs;
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	
	
	static {
		try {
			Properties prop = new Properties();
			prop.load(Dbutil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			username = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(username);
		return conn;
	}
	
	public static PreparedStatement getPstmt(String sql) {
		try {
			pStmt = getConn().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pStmt;
	}
	
	public static ResultSet getRs(String sql, List<?> paramterList) {
		try {
			int index = 1;
			pStmt = getPstmt(sql);
			if(paramterList != null && !paramterList.isEmpty()) {
				for(int i = 0; i < paramterList.size(); i++) {
					pStmt.setObject(index++, paramterList.get(i));
				}
			}
			rs = pStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void close() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pStmt != null) {
				pStmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Dbutil.getConn();
		
	}*/
	
	
}
