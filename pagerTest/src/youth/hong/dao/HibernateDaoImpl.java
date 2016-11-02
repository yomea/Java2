package youth.hong.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import youth.hong.hibernate.HibernateUtil;
import youth.hong.model.Pager;
import youth.hong.model.Student;

public class HibernateDaoImpl implements Idao {

private int count = 0;
	
	private int pageNum;
	
	private int pageSize;
	
	private int totalPage;
	

	@Override
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize){
		Pager<Student> pager = null;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		try {
			List<Student> students = findStudents2(searchModel, pageNum, pageSize);
			pager = new Pager<Student>(students, this.pageNum, this.pageSize, this.count, totalPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findStudents2(Student searchModel, int pageNum, int pageSize) throws SQLException {
		
		String username = searchModel.getStuName();
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		int gender = searchModel.getGender();
		
		Session session = HibernateUtil.getSession();
		
		
		StringBuilder sql = new StringBuilder("from Student s where 1=1");
		StringBuilder sqlCount = new StringBuilder("select count(id) from Student s where 1=1");
		
		if(username != null) {
			sql.append(" and s.stuName like :username");
			sqlCount.append(" and s.stuName like :username");
			parameterMap.put("username", "%" + username + "%");
		}
		if(gender > 0 && gender != 3) {
			sql.append(" and s.gender=:gender");
			sqlCount.append(" and s.gender=:gender");
			parameterMap.put("gender", gender);
		}
		
		
		System.out.println("sqlCount:" + sqlCount);
		
		System.out.println(sql);
		
		Query hqlCount = session.createQuery(sqlCount.toString());
		
		hqlCount = this.transferSql(hqlCount, parameterMap);
		
		count = ((Number)hqlCount.uniqueResult()).intValue();
		
		System.out.println("count:" + count);
		
		
		
		totalPage = count / pageSize;
		
		
		totalPage = count % pageSize ==0 ? totalPage : (totalPage + 1);
		
		System.out.println(totalPage + "--totalPage");
		
		this.pageNum = pageNum > totalPage ? totalPage : pageNum < 1 ? 1 : pageNum;
		
		int fromIndex = (this.pageNum - 1) * pageSize;
		
		Query hql = session.createQuery(sql.toString());
		
		hql = this.transferSql(hql, parameterMap);
		
		List<Student> students = hql.setFirstResult(fromIndex).setMaxResults(pageSize).list();
		
		return students;
	}
	
	private Query transferSql(Query hql, Map<String,Object> map) {
		if(map != null && !map.isEmpty()) {
			for(Map.Entry<String,Object> entry : map.entrySet()) {
				hql.setParameter(entry.getKey(), entry.getValue());
			}
		}
		
		return hql;
	}
	


}
