package youth.hong.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class BaseDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/dvd";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		Connection conn = null;
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	/**
	 * 更新和插入操作
	 * @param sql
	 * @param parameter
	 * @return
	 */
	public boolean operUpdate(String sql, List<Object> parameter) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		conn = getConn();
		int count = 0;
		try {
			pStmt = conn.prepareStatement(sql);
			if(parameter != null) {
				for (Object object : parameter) {
					count ++;
					pStmt.setObject(count, object);
				}
				
			}
			
			row = pStmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pStmt, rs);
		}
		
		return row > 0 ? true : false;
		
	}
	/**
	 * 关闭资源
	 * @param conn
	 * @param pStmt
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement pStmt, ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(pStmt != null) {
				pStmt.close();
				pStmt = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询数据
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 */
	public  <T>  List<T> operQuery(String sql, List<Object> params, Class<T> cls) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		conn = getConn();
		List<T> list = new ArrayList<T>();
		int count = 0;
		try {
			pStmt = conn.prepareStatement(sql);
			if(params != null) {
				for (Object object : params) {
					count ++;
					pStmt.setObject(count, object);
				}
				
			}
			
			rs = pStmt.executeQuery();
			
			if(rs != null) {
				ResultSetMetaData metaData = rs.getMetaData();
				while(rs.next()) {
					T enetity = cls.newInstance();
					for(int i = 0; i < metaData.getColumnCount(); i++) {
						String column_name = metaData.getColumnName(i+1);
						Object value = rs.getObject(column_name);
						Field field = cls.getDeclaredField(column_name);
						//取消它的私有属性，才能设置值
						field.setAccessible(true);
						field.set(enetity, value);
					}
					list.add(enetity);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pStmt, rs);
		}
		return list;
	}
	
}
