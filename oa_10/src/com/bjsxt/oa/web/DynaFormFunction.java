package com.bjsxt.oa.web;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.bjsxt.oa.freemarker.FreemarkerManager;
import com.bjsxt.oa.managers.FormManager;
import com.bjsxt.oa.model.FlowForm;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DynaFormFunction {
	
	private static FormManager formManager;
	private static String defaultTemplate = "document_form.ftl";
	
	public static String form(int workflowId){
		
		try {
			//查找表单定义
			FlowForm form = formManager.findForm(workflowId);
			
			if(form == null){
				return null;
			}
			
			Configuration cfg = FreemarkerManager.getConfiguration();
			
			Template template = null;
			if(form.getTemplate() == null || form.getTemplate().trim().equals("")){
				template = cfg.getTemplate(defaultTemplate);
			}else{
				template = cfg.getTemplate(form.getTemplate());
			}
			
			//最终输出的位置
			Writer out = new StringWriter();
			
			//数据模型
			Map rootMap = new HashMap();
			rootMap.put("form", form);
			
			//模版引擎解释模版
			template.process(rootMap, out);
			
			return out.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void setFormManager(FormManager formManager) {
		DynaFormFunction.formManager = formManager;
	}

	public void setDefaultTemplate(String defaultTemplate) {
		DynaFormFunction.defaultTemplate = defaultTemplate;
	}
}
