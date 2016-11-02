package youth.hong;

public class Test {
	public static void main(String[] args) throws TypeException {
		//int cats[] = {0,9,8,7,6,5,4,3,2,1,0};
		Cat[] cats = new Cat[20];
		for(int i = 19; i >= 0; i--) {
			cats[i] = new Cat(i);
		}
		DateSorter.dataSort(cats);
		DateSorter.printlnData(cats);
	}
}
