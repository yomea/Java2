package youth.hong;

import org.hibernate.SessionFactory;

public class SuperDao extends org.springframework.orm.hibernate5.support.HibernateDaoSupport {
	
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
