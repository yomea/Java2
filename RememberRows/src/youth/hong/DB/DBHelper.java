package youth.hong.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBHelper {
	private static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn() {
		Connection conn = null; 
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return conn;
	}
	
	public static Statement getStmt(Connection conn) {
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	public static PreparedStatement getPStmt(Connection conn, String sql) {
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pStmt;
	}
	
	public static ResultSet getRs(Statement stmt, String sql) {
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
