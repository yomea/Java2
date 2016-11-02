package youth.hong.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import youth.hong.entity.Category;
import youth.hong.model.CategoryDao;

@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport {
	private List<Category> categories = new ArrayList<Category>();
	private static CategoryDao  cd = null;
	private Category category = null;
	static {
		cd = new CategoryDao();
		
	}
	private int page = 0;
	private int pageNo = 0;
	private int pageSize = 3;
	private int id;
	
	public String list() {
		System.out.println("list");
		page = cd.list(categories, pageNo, pageSize);
		return SUCCESS;
	}
	
	public String add() throws SQLException {
		cd.add(category);
		return SUCCESS;
	}
	
	public String update() {
		cd.update(category);
		return SUCCESS;
	}
	
	public String delete() {
		cd.deleteById(id);
		return SUCCESS;
	}
	
	public String addInput(){
		
		return INPUT;
	}
	
	public String updateInput(){
		category = cd.getById(id);
		return INPUT;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public static CategoryDao getCd() {
		return cd;
	}

	public static void setCd(CategoryDao cd) {
		CategoryAction.cd = cd;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
