package com.bjsxt.oa;

import java.util.List;

public class PagerModel {
	
	/**
	 * �ܼ�¼��
	 */
	private int total;
	
	/**
	 * ��ǰҳ�����
	 */
	private List datas;

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
