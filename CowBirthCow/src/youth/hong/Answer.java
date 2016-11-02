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
	 * ÿ�곤��һ��
	 */
	public void grow() {
		this.age++;
	}

	/*
	 * ĸţ��Сţ���������ﵽ5�꣬�����ÿ�궼��һͷСĸţ����֮����������������null
	 */
	public Cow generation() {
		if (this.age >= 5)
			return new Cow(0);
		return null;
	}
}

class Farm {
	// cows���ϴ������ĸţ����
	private List<Cow> cows = new ArrayList<Cow>();

	public List<Cow> getCows() {
		return cows;
	}

	public void setCows(List<Cow> cows) {
		this.cows = cows;
	}

	/*
	 * ��N���ũ����ţ������
	 */
	public int getCowNum(int year) {
		// children���ϴ��ÿ������ĸţ����Сĸţ����
		List<Cow> children = new ArrayList<Cow>();
		for (int i = 0; i < year; i++) {
			for (Cow c : cows) {
				c.grow();
				Cow cc = c.generation();
				if (cc != null) {// �����ĸţ���Բ����ˣ��������Сĸţ����children������
					children.add(cc);
				}
			}
			cows.addAll(children);// ������Сĸţ���ϼ�������ĸţ�ļ�����
			children.clear();// ÿ�����children�������
		}
		return cows.size();
	}

}

public class Answer {

	public static void main(String[] args) {
		Farm farm = new Farm();
		// ���ȴ���һ���Ѿ����Բ��е�ĸţ����
		Cow c = new Cow(5);
		// �����ĸţ��ӵ�ũ����
		farm.getCows().add(c);
		int num = farm.getCowNum(20);// 20���ũ����ţ������
		System.out.println(num);// �����431
	}
}
