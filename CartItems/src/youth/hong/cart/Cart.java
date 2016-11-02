package youth.hong.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import youth.hong.items.Items;


public class Cart {
	private HashMap<Items, Integer> items;
	
	private double totalPrice;

	public Cart() {
		this.items = new HashMap<Items, Integer>();
		this.totalPrice = 0.0;
	}

	
	public Map<Items, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Items, Integer> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean addItems(Items item, Integer count) {
		//containKey方法会调用equals和hashcode方法共同判断一个对象是否相等。
		if(items.containsKey(item)) {
			count = items.get(item) + count;
			items.put(item, count);
		} else {
			
			items.put(item, count);
		}
		this.sumPrice();
		return true;
	}
	
	public boolean deleteItem(Items item) {
		items.remove(item);
		return true;
	}
	
	public double sumPrice() {
		Set<Items> keys = items.keySet();
		double sum = 0;
		for (Items it : keys) {
			sum += it.getPrice()*items.get(it);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
}
