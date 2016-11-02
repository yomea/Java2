package youth.hong;

import youth.hong.ArrayList;

public class Test {
	@org.junit.Test
	public void testArrayList() {
		List arrayList = new ArrayList();
		for(int i = 0; i < 15; i++) {
			arrayList.add(new Cat(i));
		}
		System.out.println(arrayList.size());
		Iterator it = arrayList.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
	
	@org.junit.Test
	public void testLinkedList() {
		List linkedList = new LinkedList();
		for(int i = 0; i < 15; i++) {
			linkedList.add(new Cat(i));
		}
		System.out.println(linkedList.size());
		Iterator it = linkedList.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
}
