package com.bjsxt.oa.managers;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.model.Module;

public interface ModuleManager {
	
	/**
	 * 添加模块信息，如果父模块的ID为0，则添加顶级模块
	 * @param module 模块信息
	 * @param parentid 父模块的ID
	 */
	public void addModule(Module module,int parentid);
	
	/**
	 * 删除模块
	 * @param moduleId
	 */
	public void delModule(int moduleId);
	
	/**
	 * 更新模块信息
	 * @param module
	 * @param parentid
	 */
	public void updateModule(Module module,int parentid);
	
	/**
	 * 查询特定的模块
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);
	
	/**
	 * 分页查询模块的信息
	 * @param parentId
	 * @return
	 */
	public PagerModel searchModules(int parentId);
}
