package youth.hong.sqlsessionproxy;

import java.lang.reflect.Proxy;

public class SqlSession {
	
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type) {
		
		
		
		return (T)Proxy.newProxyInstance(SqlSession.class.getClassLoader(), new Class[]{type}, new  MapperProxy());
	}
}
