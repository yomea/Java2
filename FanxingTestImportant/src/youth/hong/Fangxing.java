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
		// ������Ϊ�޷�ָ���㵽��Ҫװ����ɶ����ȷ����,�п����ǹ���Ҳ�п�����������
		// collection1.add(new Dog());
		Collection<? super Dog> collection2 = new ArrayList<Object>();
		// ������װDog����Ϊ��װ�����һ������װ����
		collection2.add(new Dog());
		// collection2.add( new Animal());
		Collection<Animal> collection3 = new ArrayList<Animal>();
		collection3.add(new Dog());
		// ��֮ʹ���ˣ�extends T or ? super T�ľͲ�Ҫȥ�������ĺ�����һ��������ʽ�����ڷ�����ֵ��ȡֵʱ�õ�
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
