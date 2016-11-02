package com.bjsxt.oa.freemarker;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerManager {
	private static Configuration cfg = new Configuration();
	
	static{
		//定义模版的位置，从类路径中，相对于FreemarkerManager所在的路径加载模版
		cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerManager.class,"templates"));
		
		//设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		//设置异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

	}
	
	public static Configuration getConfiguration(){
		return cfg;
	}
}
