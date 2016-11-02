package youth.hong.dao;

import java.util.List;

import youth.hong.dto.ModuleDto;
import youth.hong.entity.Module;
import youth.hong.pager.Pager;

public interface ModuleDao {
	/**
	 * 添加模块信息，如果父模块的ID为0，则添加顶级模块
	 * 
	 * @param module
	 *            模块信息
	 * @param parentid
	 *            父模块的ID
	 */
	public int addModule(ModuleDto module);

	/**
	 * 删除模块
	 * 
	 * @param moduleId
	 */
	public int delModule(int moduleId);

	/**
	 * 更新模块信息
	 * 
	 * @param module
	 * @param parentid
	 */
	public int updateModule(ModuleDto module);

	/**
	 * 查询特定的模块
	 * 
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);

	/**
	 * 分页查询模块的信息
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Module> searchModules(int parentId);
}
