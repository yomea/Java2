package youth.hong;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Scope("singleton")
@Component("t")
public class TestScope implements ApplicationContextAware {
	private ApplicationContext applicationConext;
	public void test() {
		Object bean = applicationConext.getBean("t");
		System.out.println(bean.hashCode());
		bean = applicationConext.getBean("t");
		System.out.println(bean.hashCode());
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		//System.out.println("test");
		this.applicationConext = arg0;
		//((TestScope)applicationConext.getBean("t")).test();
		test();
	}
}
