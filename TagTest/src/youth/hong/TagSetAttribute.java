package youth.hong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSetAttribute extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String driver;
	private String sql;
	private String username;
	private String password;
	private String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int doStartTag() throws JspException {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, password);
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					pageContext.getOut().println(rs.getString("username")+"<br />");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return TagSetAttribute.EVAL_PAGE;
	}
	
}
