package com.bjsxt.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class AclActionForm extends ActionForm {
	
	private String principalType;
	
	private int principalSn;

	public int getPrincipalSn() {
		return principalSn;
	}

	public void setPrincipalSn(int principalSn) {
		this.principalSn = principalSn;
	}

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}
	
}
