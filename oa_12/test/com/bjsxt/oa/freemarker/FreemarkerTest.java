package com.bjsxt.oa.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import junit.framework.TestCase;

public class FreemarkerTest extends TestCase {
	private String dir = "D:/share/JavaProjects/oa/oa_10/test/com/bjsxt/oa/freemarker";
	public void testFreemarker(){
		try {
			Configuration cfg = new Configuration();
			
			//从哪里加载模版文件
			cfg.setDirectoryForTemplateLoading(new File(dir));
			
			//设置对象包装器
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			
			//设置异常处理器
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

			//定义数据模型
			Map root = new HashMap();
			root.put("abc", "世界，你好");
			
			
			//通过freemarker解释模版，首先需要获得Template对象
			Template template = cfg.getTemplate("test.ftl");
			
			//定义模版解释完成之后的输出
			PrintWriter out
				= new PrintWriter(
						new BufferedWriter(
								new FileWriter(dir+"/out.txt")
						)
				);
			
			//模版解释
			template.process(root, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
