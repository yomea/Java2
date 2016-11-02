package youth.hong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youth.hong.dao.OrgDao;
import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;
import youth.hong.pager.Pager;
import youth.hong.service.OrgService;
import youth.hong.util.PagerUtil;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgDao orgDao;

	@Override
	public boolean addOrgnization(Org org) {

		if (org.getName() == null || org.getDecription() == null || org.getSn() == null
				|| "".equals(org.getName().trim()) || "".equals(org.getSn().trim())
				|| "".equals(org.getDecription().trim())) {
			return false;
		}

		int flag = orgDao.addOrgnization(org);

		if (flag > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delOrgnization(int id) {
		int flag = orgDao.delOrgnization(id);
		if (flag > 0) {
			return true;
		} else {

			return false;
		}
	}

	@Override
	public boolean updateOrgnization(Org org) {
		int flag = orgDao.updateOrgnization(org);
		if (flag > 0) {
			return true;
		} else {
			return false;

		}
	}

	@Override
	public Orgnization findOrgById(int id) {
		return orgDao.findOrgById(id);
	}

	@Override
	public List<Orgnization> findOrgs(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Orgnization> findTopOrgnization(int currentPage, int offset, int id) {
		int totalRecords = orgDao.getTotalRecords(id);
		int totalPages = PagerUtil.totalPages(totalRecords, offset);
		int startIndex = PagerUtil.startIndex(currentPage, offset);
		List<Orgnization> orgs = orgDao.findTopOrgnization(startIndex, offset, id);
		if(orgs == null || orgs.size() <= 0) {
			orgs = null;
		}
		Pager<Orgnization> pager = new Pager<Orgnization>(totalPages, totalRecords, currentPage, offset, orgs);
		return pager;
	}

	@Override
	public Pager<Orgnization> findAllOrgnization(int currentPage, int offset) {
		int totalRecords = orgDao.getTotalRecords(null);
		int totalPages = PagerUtil.totalPages(totalRecords, offset);
		int startIndex = PagerUtil.startIndex(currentPage, offset);
		List<Orgnization> orgs = orgDao.findAllOrgnization(startIndex, offset);
		Pager<Orgnization> pager = new Pager<Orgnization>(totalPages, totalRecords, currentPage, offset, orgs);
		return pager;
	}

	@Override
	public int getTotalRecords(Integer id) {
		return orgDao.getTotalRecords(id);
	}

	@Override
	public int getPid(Integer id) {
		Integer pid = orgDao.getPid(id);
		if(pid == null) {
			pid = 0;
		}
		return pid;
	}

}
