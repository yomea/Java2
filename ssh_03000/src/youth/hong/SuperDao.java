package youth.hong;

import org.hibernate.SessionFactory;
/**
 * 给其他的Dao类继承，使用它注入sessionFactory，省去重复注入的麻烦
 * @author may
 *
 */


public class SuperDao extends org.springframework.orm.hibernate5.support.HibernateDaoSupport {
	
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
