package com.bjsxt.oa.web;

import com.bjsxt.oa.managers.AclManager;

/**
 * JSTL��������Ҫ�����ǿ������Ȩ�޵ļ�ʱ��֤
 * @author Administrator
 *
 */
public class SecurityFunctions {
	
	private static AclManager aclManager;
	
	public static boolean hasPermission(int userId,String resourceSn,int permission){
		
		return aclManager.hasPermissionByResourceSn(userId, resourceSn, permission);
	}

	//����������ܶ���Ϊstatic����Ϊ�⽫����spring�޷�ע��
	public void setAclManager(AclManager aclManager) {
		SecurityFunctions.aclManager = aclManager;
	}
}
