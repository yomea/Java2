package youth.hong.util;

public class PagerUtil {
	
	public static int totalPages(int totalRecords, int offset) {
		return totalRecords % offset == 0 ? totalRecords / offset : totalRecords / offset + 1;
		
	}
	
	public static int startIndex(int currentPage, int offset) {
		return (currentPage - 1) * offset;
	}
	
}
