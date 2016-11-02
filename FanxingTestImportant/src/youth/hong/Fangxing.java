package youth.hong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Animal {
}

class Dog extends Animal {
	String color;

	public Dog() {

	}

	public Dog(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [color=" + color + "]";
	}

}

class HaBaDog extends Dog {
}

class Cat {
}

public class Fangxing {

	public static void main(String[] args) {
		Collection<? extends Object> collection1 = new ArrayList<Dog>();
		// 报错，因为无法指导你到底要装的是啥，不确定性,有可能是狗，也有可能是其他的
		// collection1.add(new Dog());
		Collection<? super Dog> collection2 = new ArrayList<Object>();
		// 但可以装Dog，因为能装父类的一定可以装子类
		collection2.add(new Dog());
		// collection2.add( new Animal());
		Collection<Animal> collection3 = new ArrayList<Animal>();
		collection3.add(new Dog());
		// 总之使用了？extends T or ? super T的就不要去调用他的函数，一般这种形式出现在方法传值，取值时用的
		test1(collection3);
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog("red"));
		list.add(new Dog("black"));
		test2(list);
		//List<Number> nu = new ArrayList<Integer>();error
		test3(list);
	}

	public static void test1(Collection<? extends Animal> collection) {
		System.out.println(collection.size());
	}

	public static void test2(List<? extends Animal> collection) {
		for (Animal animal : collection) {
			System.out.println(animal);

		}

	}

	public static void test3(List<? super HaBaDog> collection) {
		for (Object object : collection) {
			System.out.println(object);
		}
	}

}
