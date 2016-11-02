package youth.hong.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import youth.hong.DB.DBHelper;
import youth.hong.items.Items;

public class ItemsDao {
	public List<Items> getAllItems() {
		List<Items> items = new ArrayList<Items>();
		Connection conn = DBHelper.getConn();
		Statement stmt = DBHelper.getStmt(conn);
		String sql = "select * from items";
		ResultSet rs = DBHelper.getRs(stmt, sql);
		try {
			while(rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(conn);
		}
		return items;
	}
	
	public Items getItemById(int id) {
		Connection conn = DBHelper.getConn();
		Statement stmt = DBHelper.getStmt(conn);
		Items item = null;
		String sql = "select * from items where id=" + id;
		ResultSet rs = DBHelper.getRs(stmt, sql);
		try {
			while(rs.next()) {
				item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs);
			DBHelper.close(stmt);
			DBHelper.close(conn);
		}
		return item;
	}
	
	public List<Items> getItems(String str) {
		List<Items> items = new ArrayList<Items>();
		if(str != null && str.length() > 0) {
			String[] idArray = str.split(",");
			if(idArray.length > 5) {
				for(int i = idArray.length-1; i >= idArray.length-5; i--) {
					items.add(this.getItemById(Integer.parseInt(idArray[i])));
				}
			
			} else {
				for(int i = idArray.length-1; i >= 0; i--) {
					items.add(this.getItemById(Integer.parseInt(idArray[i])));
				}
			}
		}
		return items;
	}
}
