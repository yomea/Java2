package youth.hong;

public class Cat implements Comparable {
	private int id;
	private CatComparator ccp = new CatComparator();
	
	public Cat(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Object o) throws TypeException {
		return ccp.compare(this, o);
		/*if(o instanceof Cat) {
			Cat oo = (Cat)o;
			if(this.getId() > oo.getId()) {
				return 1;
			} else if(this.getId() < oo.getId()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			
			throw new TypeException("ÀàÐÍ´íÎó£¡");
		}*/
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + "]";
	}
	
	
	
}
