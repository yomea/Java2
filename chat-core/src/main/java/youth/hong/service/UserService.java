package youth.hong.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import youth.hong.bean.User;
import youth.hong.mapper.IUserMapping;
import youth.hong.util.SqlSessionFactoryUtil;

@Service
public class UserService implements IService {

	@Override
	public User getUser(User user) {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		IUserMapping userMapping = session.getMapper(IUserMapping.class);
		User u = userMapping.oneUser(user);
		return u;
	}
	
	public static void main(String[] args) {
		UserService service = new UserService();
		User user = new User(1,"youth","youth");
		service.getUser(user);
	}
	
}
