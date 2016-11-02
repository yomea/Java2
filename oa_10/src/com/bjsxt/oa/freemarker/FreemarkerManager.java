package com.bjsxt.oa.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerManager {
	private static Configuration cfg = new Configuration();
	
	static{
		//����ģ���λ�ã�����·���У������FreemarkerManager���ڵ�·������ģ��
		cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerManager.class,"templates"));
		
		//���ö����װ��
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		//�����쳣������
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

	}
	
	public static Configuration getConfiguration(){
		return cfg;
	}
}
