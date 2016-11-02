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
		
		//���hibernate session�����Ա�����ݿ���в���
		Session session = executionContext.getJbpmContext().getSession();
		
		//������ʵ���л���ĵ���ID
		int documentId = (Integer)executionContext.getContextInstance().getVariable("document");
		
		//�ӹ��Ķ����л�ö�̬���������ֵ
		Map props = ((Document)session.load(Document.class, documentId)).getProps();
		
		Map target = new HashMap();
		Set entries = props.entrySet();
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			DocumentProperty prop = (DocumentProperty)entry.getValue();
			
			//�����ж��Ƿ�ǿգ�����ֵ���õ�����ʵ������
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
		
		//�������Ķ�̬��������ֵ��������ʵ������
		executionContext.getContextInstance().addVariables(target);
		
	}

}
