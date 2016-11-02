package youth.hong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;

public interface OrgDao {

	public Orgnization findOrgById(int id);

	public int addOrgnization(Org org);
	
	public Integer getPid(Integer id);

	public int delOrgnization(int id);

	public int updateOrgnization(Org org);

	public List<Orgnization> findTopOrgnization(@Param("startIndex") int startIndex, @Param("offset") int offset,
			@Param("id") int id);

	public int getTotalRecords(Integer id);
	
	public List<Orgnization> findAllOrgnization(@Param("startIndex") int startIndex, @Param("offset") int offset);
}
