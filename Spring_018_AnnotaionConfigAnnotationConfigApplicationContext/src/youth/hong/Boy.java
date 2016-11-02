package youth.hong;

import org.springframework.stereotype.Component;

@Component
public class Boy implements Person {
	public void init() {
		System.out.println("I am Boy");
	}
}
