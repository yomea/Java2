import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Sample1 {
  public static void main(String[] args) throws Exception{ 
   
	  SAXReader saxReader = new SAXReader();
	  System.out.println(Sample1.class.getClassLoader().getResource("beans.xml"));
	  Document document = saxReader.read(Sample1.class.getClassLoader().getResource("beans.xml"));
	  Element element = document.getRootElement();
	  @SuppressWarnings("unchecked")
	  Iterator<Element> it = element.elementIterator("bean");
	  Element e = null;
	  while(it.hasNext()) {
		  e = it.next();
		  String id = e.attributeValue("id");
		  String classValue = e.attributeValue("class");
		  System.out.println(id + "---" + classValue);
	  }
       
      
  }
} 