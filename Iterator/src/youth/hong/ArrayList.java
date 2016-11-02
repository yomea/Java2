package youth.hong;

public class ArrayList implements List {
	Object[] objects = new Object[10];
	int index = 0;
	
	public void add(Object obj) {
		if(index == objects.length) {
			Object[] newObjects = new Object[objects.length+1];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects = newObjects;
		}
		objects[index] = obj;
		index++;
	}
	public int size() {
		return index;
	}
	@Override
	public Iterator iterator() {
		
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator {
		
		int currentIndex = 0;
		@Override
		public boolean hasNext() {
			if(currentIndex >= index) {
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			Object obj = objects[currentIndex];
			currentIndex++;
			return obj;
		}
		
	}
}
