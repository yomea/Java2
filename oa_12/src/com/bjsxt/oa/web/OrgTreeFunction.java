package com.bjsxt.oa.web;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.bjsxt.oa.freemarker.FreemarkerManager;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class OrgTreeFunction {
	
	public static String tree(List orgs){
		try {
			Configuration cfg = FreemarkerManager.getConfiguration();
			Template template = cfg.getTemplate("tree.ftl");
			Writer out = new StringWriter();
			Map rootMap = new HashMap();
			rootMap.put("orgs", orgs);
			template.process(rootMap, out);
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
