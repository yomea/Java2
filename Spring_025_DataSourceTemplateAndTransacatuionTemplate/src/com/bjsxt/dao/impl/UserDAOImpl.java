package com.bjsxt.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Repository("u")
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	//private DataSource dataSource;
	
	
	
	/*public DataSource getDataSource() {
		return dataSource;
	}


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/



	public void save(User user) {
		//Connection conn = null;
		
			/*conn = dataSource.getConnection();
			conn.createStatement().executeUpdate("insert into user values(null,'youth')");*/
			this.getJdbcTemplate().update("insert into user values(null,'youth')");
			
		System.out.println("user saved!");
		//throw new RuntimeException("error");
	}

}
