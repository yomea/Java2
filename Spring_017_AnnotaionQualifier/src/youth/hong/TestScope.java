package youth.hong;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Scope("singleton")
@Component("t")
public class TestScope implements ApplicationContextAware {
	private ApplicationContext applicationConext;
	
	
	@Autowired
	private List<Person> person;
	@Autowired
	private Map<String, Person> personMap;
	
	@Autowired
	@MyQualifier("girl")
	private Person p;
	
	
	
	public ApplicationContext getApplicationConext() {
		return applicationConext;
	}

	public void setApplicationConext(ApplicationContext applicationConext) {
		this.applicationConext = applicationConext;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public Map<String, Person> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, Person> personMap) {
		this.personMap = personMap;
	}

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public void test() {
		Object bean = applicationConext.getBean("t");
		System.out.println(bean.hashCode());
		bean = applicationConext.getBean("t");
		System.out.println(bean.hashCode());
		System.out.println("--------------------------------------------------");
		if(person != null) {
			System.out.println(person.size());
			for (Person person2 : person) {
				System.out.println(person2.getClass().getName());
			}
		}else {
			System.out.println(" ß∞‹¡À");
		}
		
		if(personMap != null) {
			System.out.println(personMap.size());
			for (Map.Entry<String, Person> person2 : personMap.entrySet()) {
				System.out.println(person2.getKey()+"    "+person2.getValue().getClass().getName());
			}
		}else {
			System.out.println(" ß∞‹¡À");
		}
		
		System.out.println("**********************************************");
		System.out.println(p.getClass().getName());
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		//System.out.println("test");
		this.applicationConext = arg0;
		//((TestScope)applicationConext.getBean("t")).test();
		test();
	}
}
