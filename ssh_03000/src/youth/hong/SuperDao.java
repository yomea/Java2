package youth.hong;

import org.hibernate.SessionFactory;
/**
 * ��������Dao��̳У�ʹ����ע��sessionFactory��ʡȥ�ظ�ע����鷳
 * @author may
 *
 */


public class SuperDao extends org.springframework.orm.hibernate5.support.HibernateDaoSupport {
	
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
