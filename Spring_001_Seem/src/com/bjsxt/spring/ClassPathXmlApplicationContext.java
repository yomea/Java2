package com.bjsxt.spring;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjsxt.dao.UserDAO;

public class ClassPathXmlApplicationContext implements BeanFactory {
	
	private Map<String , Object> beans = new HashMap<String, Object>();
	
	
	//IOC Inverse of Control DI Dependency Injection
	public ClassPathXmlApplicationContext() throws Exception {
		/*SAXBuilder sb=new SAXBuilder();
	    
	    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); //构造文档对象
	    Element root=doc.getRootElement(); //获取根元素beans
	    List list=root.getChildren("bean");//取名字为bean的所有元素
	    for(int i=0;i<list.size();i++){
	       Element element=(Element)list.get(i);
	       String id=element.getAttributeValue("id");
	       String clazz=element.getAttributeValue("class");
	       Object o = Class.forName(clazz).newInstance();
	       System.out.println(id);
	       System.out.println(clazz);
	       beans.put(id, o);
	       
	       for(Element propertyElement : (List<Element>)element.getChildren("property")) {
	    	   String name = propertyElement.getAttributeValue("name"); //userDAO
	    	   String bean = propertyElement.getAttributeValue("bean"); //u
	    	   Object beanObject = beans.get(bean);//UserDAOImpl instance
	    	   
	    	   String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	    	   System.out.println("method name = " + methodName);
	    	   
	    	   Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
	    	   m.invoke(o, beanObject);
	       }
	       
	       
	    }  */
		  SAXReader saxReader = new SAXReader();
		  System.out.println(ClassPathXmlApplicationContext.class.getClassLoader().getResource("beans.xml"));
		  Document document = saxReader.read(ClassPathXmlApplicationContext.class.getClassLoader().getResource("beans.xml"));
		  Element element = document.getRootElement();
		  @SuppressWarnings("unchecked")
		  Iterator<Element> it = element.elementIterator("bean");
		  Element e = null;
		  while(it.hasNext()) {
			  e = it.next();
			  String id = e.attributeValue("id");
			  String className = e.attributeValue("class");
			  System.out.println(id + "---" + className);
			  Object o = Class.forName(className).newInstance();
			  beans.put(id, o);
			  @SuppressWarnings("unchecked")
			  Iterator<Element> property = e.elementIterator("property");
			  while(property.hasNext()) {
				  Element e2 = property.next();
				  String name = e2.attributeValue("name");
				  String bean = e2.attributeValue("bean");
				  String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				  System.out.println(methodName);
				  @SuppressWarnings("rawtypes")
				  Class userService = beans.get("userService").getClass();
				  //注意不能用这个Class UserDAOImpl = beans.get("u").getClass();
				  @SuppressWarnings("unchecked")
				  Method m = userService.getMethod(methodName, new Class[]{UserDAO.class});
				  m.invoke(beans.get("userService"), beans.get(bean));
			  }
		  }
		 for (Map.Entry<String, Object> entry : beans.entrySet()) {
			System.out.println(entry);
		}
	}



	public Object getBean(String id) {
		return beans.get(id);
	}

}
