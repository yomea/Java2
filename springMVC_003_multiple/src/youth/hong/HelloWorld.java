package youth.hong;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//xml��ʽ����ʱӦ��ʵ�ֽӿڻ�̳�multiActionController
public class HelloWorld implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("oh yeah!");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map1", "�ɰ͵�");
		map.put("map2", "����");
		return new ModelAndView("welcome", "map", map);
	}

}
