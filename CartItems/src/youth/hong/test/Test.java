package youth.hong.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import youth.hong.cart.Cart;
import youth.hong.items.Items;

public class Test {
	public static void main(String[] args) {
		Cart c = new Cart();
		Items it1 = new Items(1,"haha","江西",100,200,"001.jpg");
		Items it2 = new Items(1,"haha","江西",100,200,"001.jpg");
		Items it3 = new Items(1,"yoyo","江西",100,200,"002.jpg");
		c.addItems(it1, 2);
		c.addItems(it2, 3);
		c.addItems(it3, 3);
		Set<Map.Entry<Items, Integer>> products = c.getItems().entrySet();
		for (Entry<Items, Integer> entry : products) {
			System.out.println(entry);
		}
	}
}
