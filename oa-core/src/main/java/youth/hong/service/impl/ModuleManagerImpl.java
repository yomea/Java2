package youth.hong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import youth.hong.dao.ModuleDao;
import youth.hong.dto.ModuleDto;
import youth.hong.entity.Module;
import youth.hong.exception.SystemException;
import youth.hong.pager.Pager;
import youth.hong.service.ModuleManager;

public class ModuleManagerImpl implements ModuleManager {
	
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public boolean addModule(ModuleDto module) {
		int flag = moduleDao.addModule(module);
		if(flag > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delModule(int moduleId) {
		int flag = moduleDao.delModule(moduleId);
		if(flag > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateModule(ModuleDto module) {
		int flag = moduleDao.updateModule(module);
		if(flag > 0){
			return true;
		}
		return false;
	}

	@Override
	public Module findModule(int moduleId) {
		Module module = moduleDao.findModule(moduleId);
		if(module == null) {
			new SystemException("此模块不存在！");
		}
		return module;
	}

	@Override
	public Pager<Module> searchModules(int parentId) {
		return null;
	}

}
