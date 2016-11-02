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
			
			//���������ģ���ļ�
			cfg.setDirectoryForTemplateLoading(new File(dir));
			
			//���ö����װ��
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			
			//�����쳣������
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

			//��������ģ��
			Map root = new HashMap();
			root.put("abc", "���磬���");
			
			
			//ͨ��freemarker����ģ�棬������Ҫ���Template����
			Template template = cfg.getTemplate("test.ftl");
			
			//����ģ��������֮������
			PrintWriter out
				= new PrintWriter(
						new BufferedWriter(
								new FileWriter(dir+"/out.txt")
						)
				);
			
			//ģ�����
			template.process(root, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
