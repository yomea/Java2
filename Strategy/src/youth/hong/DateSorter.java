package youth.hong;

public class DateSorter {
	
	
	public static void dataSort(Object[] a) throws TypeException {
		for(int i = a.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				Comparable o1 = (Comparable)a[j];
				Comparable o2 = (Comparable)a[j+1];
				if(o1.compareTo(o2) > 0) {
					Comparable t = o1;
					o1 = o2;
					o2 = t;
				}
			}
		}
	}
	
	public static void dataSort(int[] a) {
		for(int i = a.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(a[j] > a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}
	}
	
	public static void printlnData(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	
		
	}

	public static void printlnData(Object[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
}
