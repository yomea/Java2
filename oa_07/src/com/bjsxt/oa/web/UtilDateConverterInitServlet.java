package com.bjsxt.oa.web;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

public class UtilDateConverterInitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		 ConvertUtils.register(new UtilDateConverter(), Date.class);
	}

}
