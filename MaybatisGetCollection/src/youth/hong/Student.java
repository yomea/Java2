package youth.hong;

import java.util.List;
import java.util.Map;

public class Student {
	private int id;
	private String name;
	private Group group;
	private List<Book> book;
	// map”√mybatis‘ı√¥”≥…‰ƒÿ£ø
	private List<Map<String, Book>> books;

	public List<Map<String, Book>> getBooks() {
		return books;
	}

	public void setBooks(List<Map<String, Book>> books) {
		this.books = books;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + ", book=" + book + ", books=" + books
				+ "]";
	}

}
