package youth.hong;

public class Main {
	public static void main(String[] args) throws Exception {
		Session session = new Session();
		Student s = new Student();
		s.setId(1);
		s.setAge(22);
		s.setName("youth");
		session.save(s);
	}
}
