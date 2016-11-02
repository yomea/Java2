package youth.hong;

public class Cow1 implements Runnable {
	private int age;
	private static int year;
	private static CowFarm farm = new CowFarm();;
	
	public Cow1(int year) {
		setYear(year);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getYear() {
		return year;
	}

	public static void setYear(int year) {
		Cow1.year = year;
	}

	public static CowFarm getFarm() {
		return farm;
	}

	public static void setFarm(CowFarm farm) {
		Cow1.farm = farm;
	}

	public Cow1 birth(int year) {
		
			if(age >= 5) {
				Cow1 c = new Cow1(year);
				Thread t = new Thread(c);
				t.start();
				return c;
			} 
		
		return null;
		
	}

	@Override
	public void run() {
		for(int i = getYear(); i <= 9; i++) {
			Cow1.setYear(i);
			//System.out.println(year);
			age++;
			//System.out.println(year);
			Cow1 c = birth(i);
			if(c != null) {
				farm.getCows().add(c);
			}
			
		}
		if(year == 9) {
			System.out.println(farm.getCows().size());
		}
	}
	
	
}
