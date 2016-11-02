package com.bjsxt.logtest;

import org.apache.log4j.Logger;

public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Log4j接口
		Logger logger = Logger.getLogger(LogTest.class);
		
		logger.debug("DEBUG调试信息");
		logger.info("INFO信息");
		logger.warn("WARN信息");
		logger.error("ERROR信息");
		logger.fatal("FATAL信息");
		
	}

}
