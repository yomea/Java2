package com.bjsxt.oa.managers;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Module;

public interface ModuleManager {
	
	/**
	 * ���ģ����Ϣ�������ģ���IDΪ0������Ӷ���ģ��
	 * @param module ģ����Ϣ
	 * @param parentid ��ģ���ID
	 */
	public void addModule(Module module,int parentid);
	
	/**
	 * ɾ��ģ��
	 * @param moduleId
	 */
	public void delModule(int moduleId);
	
	/**
	 * ����ģ����Ϣ
	 * @param module
	 * @param parentid
	 */
	public void updateModule(Module module,int parentid);
	
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
	public PagerModel searchModules(int parentId);
}
