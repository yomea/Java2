package youth.hong;

import java.io.OutputStreamWriter;
import java.io.Writer;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTest {
	public static void main(String[] args) throws Exception {
		User user = new User();
		LatestProduct latestProduct = new LatestProduct();
		user.setLatestProduct(latestProduct);
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.25) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		//��������ʵ����ָ��һ������Ϊ�Ƚ��ȶ��İ汾
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);

		// Specify the source where the template files come from. Here I set a
		// plain directory for it, but non-file-system sources are possible too:
		//����ģ���ļ����صĻ�·��
		//cfg.setDirectoryForTemplateLoading(new File("D:/eclipseworkspace/freemarkerTest/src/youth/hong"));
		cfg.setTemplateLoader(new ClassTemplateLoader(FreemarkerTest.class, ""));
		// Set the preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		//����ģ�崢����ַ���ΪUTF-8�����Ǹ��õ�ѡ��
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		//���ó������ʾ��ʽ����������ʾ��HTMLҳ�棬�����ڿ���̨
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		//���ö����װ��
		cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_25));
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		//�׳��쳣ʱ���������¼�������
		cfg.setLogTemplateExceptions(false);
		
		Template temp = cfg.getTemplate("test.ftlh");
		
		Writer out = new OutputStreamWriter(System.out);
		temp.process(user, out);
		
	}
}
