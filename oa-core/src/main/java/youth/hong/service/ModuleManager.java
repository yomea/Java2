package youth.hong.service;

import youth.hong.dto.ModuleDto;
import youth.hong.entity.Module;
import youth.hong.pager.Pager;

public interface ModuleManager {
	
	/**
	 * ���ģ����Ϣ�������ģ���IDΪ0������Ӷ���ģ��
	 * @param module ģ����Ϣ
	 * @param parentid ��ģ���ID
	 */
	public boolean addModule(ModuleDto module);
	
	/**
	 * ɾ��ģ��
	 * @param moduleId
	 */
	public boolean delModule(int moduleId);
	
	/**
	 * ����ģ����Ϣ
	 * @param module
	 * @param parentid
	 */
	public boolean updateModule(ModuleDto module);
	
	/**
	 * ��ѯ�ض���ģ��
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);
	
	/**
	 * ��ҳ��ѯģ�����Ϣ
	 * @param parentId
	 * @return
	 */
	public Pager<Module> searchModules(int parentId);
}
