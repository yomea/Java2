package youth.hong.service;

import java.util.List;

import youth.hong.dto.Org;
import youth.hong.entity.Orgnization;
import youth.hong.pager.Pager;

public interface OrgService {
	
	/**
	 * ���ӻ�����Ϊ��ô��ֱ�ӽ�parent�浽org���ó�����
	 * ��Ϊparent����Ĵ󲿷���Ϣ�Ѵ��ڣ�Ϊ��ʹcontroller�Ĵ����徻��ֱ�Ӵ���parentId
	 * @param org
	 * @param parentId
	 * @return
	 */
	public boolean addOrgnization(Org org);
	
	/**
	 * ͨ��idɾ������
	 * @param parentId
	 * @return
	 */
	public boolean delOrgnization(int id);
	
	/**
	 * ���£���id��ȻҲҪ����
	 * @param org
	 * @param parentId
	 * @return
	 */
	public boolean updateOrgnization(Org org);
	
	/**
	 * ͨ��id�ҵ�����
	 * @param id
	 * @return
	 */
	public Orgnization findOrgById(int id);
	
	/**
	 * ͨ�������ҵ����е��ӻ���
	 * �����id���㣬˵���Ƕ���������ֱ�Ӳ��Ҷ�������
	 * @param parentId
	 * @return
	 */
	public List<Orgnization> findOrgs(int parentId);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public Pager<Orgnization> findTopOrgnization(int currentPage, int offset, int id);
	
	/**
	 * ��ѯ���е�orgnization
	 * @param currentPage
	 * @param offset
	 * @return
	 */
	public Pager<Orgnization> findAllOrgnization(int currentPage, int offset);
	
	/**
	 * ��ֵΪnullʱ��ѯ���еļ�¼����ֵʱ��ѯpid
	 * @param id
	 * @return
	 */
	public int getTotalRecords(Integer id);
	
	public int getPid(Integer id);
	
	
}
