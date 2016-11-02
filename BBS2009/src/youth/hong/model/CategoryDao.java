package youth.hong.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import youth.hong.database.DB;
import youth.hong.entity.Category;

public class CategoryDao {
	
	public boolean add(Category c) throws SQLException {
		Connection conn = DB.getConn();
		String sql = "insert into t_category values (null,?,?)";
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		int check = 0;
		try {
			pStmt.setString(1, c.getName());
			pStmt.setString(2, c.getDescription());
			check = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(check > 0) {
			return true;
		} 
		return false;
	}
	
	public boolean update(Category c) {
		Connection conn = DB.getConn();
		String sql = "update t_category set name=?, description=?";
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		int check = 0;
		try {
			pStmt.setString(1, c.getName());
			pStmt.setString(2, c.getDescription());
			check = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(check > 0) {
			return true;
		} 
		return false;
	}
	
	public int list(List<Category> categories, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		int pageStart = (pageNo - 1)*pageSize;
		String sql = "select * from t_category limit " + pageStart + "," + pageSize;
		String cSql = "select count(id) from t_category";
		PreparedStatement cStmt = DB.getPStmt(conn, cSql);
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		int count = 0;
		try {
			ResultSet rs = pStmt.executeQuery();
			ResultSet cRs = cStmt.executeQuery();
			if(cRs.next()) {
				count = cRs.getInt(1);
				count = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
			}
			while(rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				categories.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean delete(Category c) {
		Connection conn = DB.getConn();
		String sql = "delete from t_category where id = ?";
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		int check = 0;
		try {
			pStmt.setInt(1, c.getId());
			check = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(check > 0) {
			return true;
		} 
		return false;
	}
	public boolean deleteById(int id) {
		Connection conn = DB.getConn();
		String sql = "delete from t_category where id = ?";
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		int check = 0;
		try {
			pStmt.setInt(1, id);
			check = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(check > 0) {
			return true;
		} 
		return false;
	}
	
	public Category getById(int id) {
		Connection conn = DB.getConn();
		String sql = "select * from t_category where id=?";
		PreparedStatement pStmt = DB.getPStmt(conn, sql);
		Category c = null;
		try {
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
