package com.bjsxt.logtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Commons-log接口，建议使用
		Log logger = LogFactory.getLog(LogTest2.class);
		
		logger.debug("DEBUG调试信息");
		logger.info("INFO信息");
		logger.warn("WARN信息");
		logger.error("ERROR信息");
		logger.fatal("FATAL信息");
		
	}

}
