package com.bjsxt.logtest;

import org.apache.log4j.Logger;

public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Log4j�ӿ�
		Logger logger = Logger.getLogger(LogTest.class);
		
		logger.debug("DEBUG������Ϣ");
		logger.info("INFO��Ϣ");
		logger.warn("WARN��Ϣ");
		logger.error("ERROR��Ϣ");
		logger.fatal("FATAL��Ϣ");
		
	}

}
