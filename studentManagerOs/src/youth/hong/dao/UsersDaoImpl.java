package youth.hong.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import youth.hong.model.Users;
import youth.hong.util.HibernateUtil;

public class UsersDaoImpl implements IUsersDao {

	public Session getSession() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		
		return session;
	}

	@Override
	public boolean isLogin(Users user) {
		Session session = this.getSession();

		String username = user.getUsername();

		String password = user.getPassword();

		String hqlStr = "from Users u where u.username=:username and u.password=:password";

		Query hql = session.createQuery(hqlStr).setParameter("username", username).setParameter("password", password);

		List<?> users = hql.list();

		session.getTransaction().commit();

		if (users != null && !users.isEmpty()) {
			return true;
		}

		return false;
	}

	
	

}
