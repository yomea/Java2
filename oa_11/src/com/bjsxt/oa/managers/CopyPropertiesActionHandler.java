package com.bjsxt.oa.managers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

import com.bjsxt.oa.model.Document;
import com.bjsxt.oa.model.DocumentProperty;

public class CopyPropertiesActionHandler implements ActionHandler {

	public void execute(ExecutionContext executionContext) throws Exception {
		
		//获得hibernate session对象，以便对数据库进行操作
		Session session = executionContext.getJbpmContext().getSession();
		
		//从流程实例中获得文档的ID
		int documentId = (Integer)executionContext.getContextInstance().getVariable("document");
		
		//从公文对象中获得动态定义的属性值
		Map props = ((Document)session.load(Document.class, documentId)).getProps();
		
		Map target = new HashMap();
		Set entries = props.entrySet();
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			DocumentProperty prop = (DocumentProperty)entry.getValue();
			
			//仅简单判断是否非空，来将值设置到流程实例变量
			if(prop.getJava_io_File() != null){
				target.put(key, prop.getJava_io_File());
			}
			if(prop.getJava_lang_Integer() != null){
				target.put(key, prop.getJava_lang_Integer());
			}
			if(prop.getJava_lang_String() != null){
				target.put(key, prop.getJava_lang_String());
			}
		}
		
		//将真正的动态表单变量的值放入流程实例变量
		executionContext.getContextInstance().addVariables(target);
		
	}

}
