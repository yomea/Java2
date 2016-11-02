package youth.hong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Action extends ActionSupport{
	public static int count = 0;//所有这个类的对象公有的变量，可以用来计数。
	
	public int sCount = 0;//由于每次访问action时都会重新new一个对象，所以不能用来计数。
	
	public Dog dog = new Dog("th");
	
	private List<Dog> dogs = new ArrayList<Dog>();
	
	private Set<Cat> cats = new HashSet<Cat>();
	
	private Cat cat;
	
	public Map<String, Dog> m = new HashMap<String, Dog>();
	
	public static String string="string";
	
	public String hong = "Hong";
	
	public String youth = "youth";
	
	public Action() {
		
		dogs.add(new Dog("a"));
		dogs.add(new Dog("b"));
		dogs.add(new Dog("c"));
		
		cats.add(new Cat(1));
		cats.add(new Cat(2));
		cats.add(new Cat(3));
		
		m.put("dog1", new Dog("m1"));
		m.put("dog2", new Dog("m2"));
		m.put("dog3", new Dog("m3"));
		
	}
	
	public Action(int sCount) {
		this.sCount = sCount;
		
	}
	
	
	public String execute() {
		count++;
		sCount++;
		System.out.println(count);
		System.out.println(sCount);
		return SUCCESS;
	
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public static String test() {
		return "I am static method";
	}

	public String getHong() {
		return hong;
	}

	/*public void setHong(String hong) {
		this.hong = hong;
	}

	public static String getString() {
		return string;
	}*/

	@Override
	public String toString() {
		return "Action [sCount=" + sCount + "]";
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public Set<Cat> getCats() {
		return cats;
	}

	public void setCats(Set<Cat> cats) {
		this.cats = cats;
	}

	
	
	

	
}
