package youth.hong.service;

import java.util.List;

import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;
import youth.hong.pager.Pager;

public interface OrgService {
	
	/**
	 * 增加机构，为甚么不直接将parent存到org中拿出来呢
	 * 因为parent的里的大部分信息已存在，为了使controller的代码清净，直接传入parentId
	 * @param org
	 * @param parentId
	 * @return
	 */
	public boolean addOrgnization(Org org);
	
	/**
	 * 通过id删除机构
	 * @param parentId
	 * @return
	 */
	public boolean delOrgnization(int id);
	
	/**
	 * 更新，父id当然也要更新
	 * @param org
	 * @param parentId
	 * @return
	 */
	public boolean updateOrgnization(Org org);
	
	/**
	 * 通过id找到机构
	 * @param id
	 * @return
	 */
	public Orgnization findOrgById(int id);
	
	/**
	 * 通过父亲找到所有的子机构
	 * 如果父id是零，说明是顶级机构，直接查找顶级机构
	 * @param parentId
	 * @return
	 */
	public List<Orgnization> findOrgs(int parentId);
	
	/**
	 * 查询顶级机构
	 * @return
	 */
	public Pager<Orgnization> findTopOrgnization(int currentPage, int offset, int id);
	
	/**
	 * 查询多有的orgnization
	 * @param currentPage
	 * @param offset
	 * @return
	 */
	public Pager<Orgnization> findAllOrgnization(int currentPage, int offset);
	
	/**
	 * 传值为null时查询所有的记录，有值时查询pid
	 * @param id
	 * @return
	 */
	public int getTotalRecords(Integer id);
	
	public int getPid(Integer id);
	
	
}
