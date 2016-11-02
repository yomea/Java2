package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testOne2One() {
		Session session = HibernateUtil.getSession();
		HibernateUtil.close(session);
	}
}
