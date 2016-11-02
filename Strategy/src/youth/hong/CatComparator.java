package youth.hong;

public class CatComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Cat c1 = (Cat)o1;
		Cat c2 = (Cat)o2;
		if(c1.getId() > c2.getId()) {
			return 1;
		} else if(c1.getId() < c2.getId()) {
			return -1;
		}
		return 0;
	}

}
