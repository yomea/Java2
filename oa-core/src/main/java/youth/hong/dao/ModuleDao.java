package youth.hong.dao;

import java.util.List;

import youth.hong.dto.ModuleDto;
import youth.hong.entity.Module;
import youth.hong.pager.Pager;

public interface ModuleDao {
	/**
	 * ���ģ����Ϣ�������ģ���IDΪ0������Ӷ���ģ��
	 * 
	 * @param module
	 *            ģ����Ϣ
	 * @param parentid
	 *            ��ģ���ID
	 */
	public int addModule(ModuleDto module);

	/**
	 * ɾ��ģ��
	 * 
	 * @param moduleId
	 */
	public int delModule(int moduleId);

	/**
	 * ����ģ����Ϣ
	 * 
	 * @param module
	 * @param parentid
	 */
	public int updateModule(ModuleDto module);

	/**
	 * ��ѯ�ض���ģ��
	 * 
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);

	/**
	 * ��ҳ��ѯģ�����Ϣ
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Module> searchModules(int parentId);
}
