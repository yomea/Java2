package java8NewProperties;

public class Book {
	private String name;
	
	private double price;

	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
	
	
}
