package youth.hong.service.impl;

import java.util.List;

import youth.hong.entity.Module;
import youth.hong.service.AclManager;

public class AclManagerImpl implements AclManager {

	@Override
	public void addOrUpdatePermission(String principalType, int principalSn, int resourceSn, int permission,
			boolean yes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delPermission(String principalType, int principalSn, int resourceSn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOrUpdateUserExtends(int userId, int resourceSn, boolean yes) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasPermission(int userId, int reourceSn, int permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Module> searchModules(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
