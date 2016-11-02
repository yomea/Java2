package youth.hong;

import java.util.Scanner;

public class Calenedar {

	public static void main(String[] args) {
		Calenedar.calendar();
	}

	public static void calendar() {
		Scanner scanner = new Scanner(System.in);
		int year = 0;
		int month = 0;
		boolean flag = false;
		int day = 0;
		int totalDay = 0;
		int week = 0;
		int[] arr = null;
		String space = "";
		System.out.println("���������");
		year = scanner.nextInt();
		System.out.println("�������·�");
		month = scanner.nextInt();
		flag = isRunYear(year);
		arr= getTotalDayByMonth(month, flag);
		totalDay = getTotalDayByYear(year) + arr[0];
		day = arr[1];
		week = 1 + totalDay % 7;
		if(week == 7) {
			week = 0;
		}
		System.out.println(week);
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������\t");
		for(int i = 0; i < week; i++) {
			space += "******\t";
			
		}
		System.out.print(space);
		for(int i = 1; i <= day; i++) {
			System.out.print("**" + i + "**" + "        ");
			if((i + week) % 7 == 0){
				System.out.println();
			}
		}
		
		scanner.close();

	}

	public static boolean isRunYear(int year) {
		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static int getTotalDayByYear(int year) {
		int totalDay = 0;
		for (int i = 1900; i < year; i++) {
			if (isRunYear(i)) {
				totalDay += 366;
			} else {
				totalDay += 365;
			}
		}
		return totalDay;
	}

	public static int[] getTotalDayByMonth(int month, boolean flag) {
		int[] arr = new int[] {0, 0};
		for (int i = 1; i <= month; i++) {
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				arr[1] = 31;
				break;

			case 2:
				if (flag) {
					arr[1] = 29;
					break;
				} else {
					arr[1] = 28;
					break;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				arr[1] = 30;
				break;
			}
			if (i != month) {
				arr[0] += arr[1];

			}

		}
		return arr;
	}

}
