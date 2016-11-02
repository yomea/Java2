package youth.hong.util;

import youth.hong.entity.Orgnization;
import youth.hong.pager.Pager;
import youth.hong.service.OrgService;

public class PagerDisplay {
	
	
	public static Pager<Orgnization> getPager(OrgService orgService, int currentPage, int offset, Integer id) {
		int totalRecords = orgService.getTotalRecords(id);
		int totalPages  = PagerUtil.totalPages(totalRecords, offset);
		Pager<Orgnization> pager = new Pager<Orgnization>(totalPages, totalRecords, currentPage, offset, null);
		return pager;
	}
}
