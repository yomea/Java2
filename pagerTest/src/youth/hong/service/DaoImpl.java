package youth.hong.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import youth.hong.dao.Idao;
import youth.hong.dbutil.Dbutil;
import youth.hong.model.Pager;
import youth.hong.model.Student;

public class DaoImpl implements Idao {

	@Override
	public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize){
		Pager<Student> pager = null;
		try {
			List<Student> students = findStudents(searchModel);
			pager = new Pager<Student>(students, pageNum, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pager;
	}
	
	public List<Student> findStudents(Student searchModel) throws SQLException {
		
		String username = searchModel.getStuName();
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		List<Object> paramterList = new ArrayList<Object>();
		
		int gender = searchModel.getGender();
		
		StringBuilder sql = new StringBuilder("select * from t_student where 1=1");
		
		if(username != null) {
			sql.append(" and stu_name like ?");
			paramterList.add("%" + username + "%");
		}
		if(gender > 0 && gender != 3) {
			sql.append(" and gender=?");
			paramterList.add(gender);
		}
		System.out.println(sql);
		ResultSet rs = Dbutil.getRs(sql.toString(), paramterList);
		
		while(rs.next()) {
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i = 0; i < columnCount; i++) {
				String columnName = md.getColumnName(i + 1);
				Object columnValue = rs.getObject(columnName);
				map.put(columnName, columnValue);
			}
			listMap.add(map);
		}
		
		
		
		return transferListMap(listMap);
	}
	
	public List<Student> transferListMap(List<Map<String, Object>> listMap) {
		
		List<Student> students = new ArrayList<Student>();
		
		if(listMap != null && !listMap.isEmpty()) {
			for (Map<String, Object> map : listMap) {
				Student student = new Student(map);
				students.add(student);
			}
		}
		
		return students;
	}
	
	
	

}
