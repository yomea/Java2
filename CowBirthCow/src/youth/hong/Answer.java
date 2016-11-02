package youth.hong;

import java.util.ArrayList;
import java.util.List;

class Cow {
	private int age;

	public Cow(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * 每年长大一岁
	 */
	public void grow() {
		this.age++;
	}

	/*
	 * 母牛生小牛，如果年龄达到5岁，则可以每年都生一头小母牛，反之，则不能生育，返回null
	 */
	public Cow generation() {
		if (this.age >= 5)
			return new Cow(0);
		return null;
	}
}

class Farm {
	// cows集合存放所有母牛对象
	private List<Cow> cows = new ArrayList<Cow>();

	public List<Cow> getCows() {
		return cows;
	}

	public void setCows(List<Cow> cows) {
		this.cows = cows;
	}

	/*
	 * 第N年后农场的牛的数量
	 */
	public int getCowNum(int year) {
		// children集合存放每年所有母牛生的小母牛对象
		List<Cow> children = new ArrayList<Cow>();
		for (int i = 0; i < year; i++) {
			for (Cow c : cows) {
				c.grow();
				Cow cc = c.generation();
				if (cc != null) {// 如果该母牛可以产仔了，则将其产的小母牛加入children集合中
					children.add(cc);
				}
			}
			cows.addAll(children);// 将整个小母牛集合加入所有母牛的集合中
			children.clear();// 每年过后将children集合清空
		}
		return cows.size();
	}

}

public class Answer {

	public static void main(String[] args) {
		Farm farm = new Farm();
		// 首先创建一个已经可以产仔的母牛对象
		Cow c = new Cow(5);
		// 将这个母牛添加到农场中
		farm.getCows().add(c);
		int num = farm.getCowNum(20);// 20年后农场的牛的总数
		System.out.println(num);// 结果：431
	}
}
