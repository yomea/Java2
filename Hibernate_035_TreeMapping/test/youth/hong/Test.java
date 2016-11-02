package youth.hong;

import org.hibernate.Session;

public class Test {
	
	@org.junit.Test
	
	public void testSave() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Org o = new Org();
		o.setName("总公司");
		Org o1 = new Org();
		o1.setName("分公司1");
		Org o2 = new Org();
		o2.setName("分公司2");
		Org o11 = new Org();
		o11.setName("分公司11");
		Org o12 = new Org();
		o12.setName("分公司12");
		o.getOrgs().add(o1);
		o.getOrgs().add(o2);
		o1.getOrgs().add(o11);
		o1.getOrgs().add(o12);
		o1.setOrg(o);
		o2.setOrg(o);
		o11.setOrg(o1);
		o12.setOrg(o1);
		session.save(o);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
@org.junit.Test
	
	public void testGet() {
		testSave();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Org org = (Org)session.load(Org.class, 1);
		print(org,0);
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}

	public void print(Org org, int level) {
		String str = "";
		for(int i = 0; i < level; i++) {
			str += "---";
		}
		System.out.println(str + org.getName());
		for(Org o : org.getOrgs()) {
			print(o,level+1);
		}
	}
	
	
}
