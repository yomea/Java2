package youth.hong;

public class LinkedList implements List {
	Node head = null;
	Node tail = null;
	int index;
	
	
	
	
	public void add(Object obj) {
		
		Node node = new Node(obj,null);
		if(head == null) {
			head = node;
			tail = node;
		}
		tail.next = node;
		tail = node;
		index++;
	}
	
	public int size() {
		return index;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator {
		private Node n = head;
		private Node pre = head;
		@Override
		public boolean hasNext() {
			 
			if(n.next != null) {
				
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
				pre = n;
				Object o = n.getObj();
				 n = n.next;
				 Object o2 = n.getObj();
				 if(pre == head) {
					 return o;
				 } else {
					 return o2;
				 }
			
			 
		}
		
	}
}

