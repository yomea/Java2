package com.bjsxt.logtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Commons-log�ӿڣ�����ʹ��
		Log logger = LogFactory.getLog(LogTest2.class);
		
		logger.debug("DEBUG������Ϣ");
		logger.info("INFO��Ϣ");
		logger.warn("WARN��Ϣ");
		logger.error("ERROR��Ϣ");
		logger.fatal("FATAL��Ϣ");
		
	}

}
