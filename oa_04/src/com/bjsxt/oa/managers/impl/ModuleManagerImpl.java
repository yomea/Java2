package com.bjsxt.oa.managers.impl;

import com.bjsxt.oa.PagerModel;
import com.bjsxt.oa.managers.ModuleManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.model.Module;

public class ModuleManagerImpl extends AbstractManager implements ModuleManager {

	public void addModule(Module module, int parentid) {
		if(parentid != 0){
			module.setParent(
				(Module)getHibernateTemplate().load(Module.class, parentid)
			);
		}
		getHibernateTemplate().save(module);
	}

	public void delModule(int moduleId) {
		Module module = (Module)getHibernateTemplate().load(Module.class, moduleId);
		
		if(module.getChildren().size() > 0){
			throw new SystemException("存在子模块，不允许删除！");
		}
		
		getHibernateTemplate().delete(
			module
		);
	}

	public Module findModule(int moduleId) {
		
		return (Module)getHibernateTemplate().load(Module.class, moduleId);
	}

	public PagerModel searchModules(int parentId) {
		return searchPaginated("select m from Module m where " +
				(parentId == 0 ? "m.parent is null" : ("m.parent.id = " + parentId))
		);
	}

	public void updateModule(Module module, int parentid) {
		if(parentid != 0){
			module.setParent(
				(Module)getHibernateTemplate().load(Module.class, parentid)
			);
		}
		getHibernateTemplate().update(module);
	}

}
