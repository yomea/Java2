package youth.hong.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int currentPage;//µ±Ç°Ò³Êý
	
	private int totalRows;
	
	private int totalPages;
	
	private int pageSize;
	
	private List<T> dataList;
	
	

	public Pager() {
		super();
	}



	public Pager(int currentPage, int totalRows, int totalPages, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
	}



	public Pager(List<T> students, int pageNum, int pageSize) {
		if(students == null || students.isEmpty()) {
			this.dataList = new ArrayList<T>();
			return;
		}
		
		this.totalRows = students.size();
		
		this.totalPages = this.totalRows / pageSize;
		
		this.totalPages = this.totalRows % pageSize == 0 ? this.totalPages : this.totalPages + 1;
		
		this.currentPage = this.totalPages < pageNum ? this.totalPages : pageNum < 1 ? 1 : pageNum;
		
		int fromIndex = (this.currentPage - 1) * pageSize;
		
		int toIndex = this.currentPage * pageSize;
		
	    toIndex = toIndex > this.totalRows ? this.totalRows : toIndex;
		
		this.dataList = students.subList(fromIndex, toIndex);
		
		
	}



	



	public Pager(List<T> students, int pageNum, int pageSize2, int count, int totalPage) {
		if(students == null || students.isEmpty()) {
			this.dataList = new ArrayList<T>();
			return;
		}
		
		this.totalPages = totalPage;
		this.dataList = students;
		this.pageSize = pageSize2;
		this.totalRows = count;
		this.currentPage = pageNum;
		
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getTotalRows() {
		return totalRows;
	}



	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}



	public int getTotalPages() {
		return totalPages;
	}



	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public List<T> getDataList() {
		return dataList;
	}



	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
	
	

}
