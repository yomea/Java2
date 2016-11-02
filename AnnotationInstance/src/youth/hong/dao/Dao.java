package youth.hong.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import youth.hong.annotation.Column;
import youth.hong.annotation.Table;
import youth.hong.entity.User;

public class Dao {
	
	public static void main(String[] agrs) {
		User user = new User();
		user.setId(1);
		user.setUsername("youth,hong");
		user.setPassword("123");
		String sql = new Dao().getSql(user);
		System.out.println(sql);
	}
	
	public String getSql(User user) {
		Class c =  user.getClass();
		boolean isMexist = c.isAnnotationPresent(Table.class);
		if(!isMexist) {
			return null;
		}
		Table t = (Table)c.getAnnotation(Table.class);
		String tableName = t.value();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from " + tableName + " where 1=1");
		Field[] f = c.getDeclaredFields();
		for (Field field : f) {
			boolean isFexist = field.isAnnotationPresent(Column.class);
			if(!isFexist) {
				continue;
			}
			Column cl = field.getAnnotation(Column.class);
			String colName = cl.value();
			String getMethod = "get" + colName.substring(0, 1).toUpperCase() + colName.substring(1);
			Object colValue = "";
			try {
				Method m = c.getMethod(getMethod);
				colValue =  m.invoke(user);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			sb.append(" and ").append(colName);
			if(colValue instanceof String) {
				if(((String)colValue).contains(",")) {
					sb.append(" in (");
					String[] str = ((String) colValue).split(",");
					for (String string : str) {
						sb.append(string + ",");
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");
				} else {
					sb.append("='").append(colValue).append("'");
					
				}
			}
			else if(colValue != null) {
				sb.append("=").append(colValue);

			}
		
		}
//		System.out.println(null instanceof String);
		return sb.toString();
	}
	
}
