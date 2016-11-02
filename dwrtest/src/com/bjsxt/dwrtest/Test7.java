package com.bjsxt.dwrtest;

public class Test7 {
	public boolean hasPermission(String name,int permission){
		if("ÀîËÄ".equals(name) && permission == 1){
			return true;
		}
		return false;
	}
}
