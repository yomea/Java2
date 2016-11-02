package youth.hong;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext implements BeanFactory {
	Map<String, Object> beans = new HashMap<String, Object>();
	public ClassPathXmlApplicationContext() throws Exception {
		SAXReader sr = new SAXReader();
			Document document = sr.read(new File("src/youth/hong/beans.xml"));
			//System.out.println(document);
			Element root = document.getRootElement();
			Iterator<Element> it = root.elementIterator();
			while(it.hasNext()) {
				Element e = it.next();
				String id = e.attributeValue("id");
				String clazz = e.attributeValue("class");
				Object o = Class.forName(clazz).newInstance();
				beans.put(id, o);
			}
			//System.out.println(beans.size());
	}
	
	public Object getBean(String str) {
		return beans.get(str);
	}
}
