package youth.hong;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("msg", Locale.CHINA);
		String str = bundle.getString("pass.msg");
		System.out.println(str);
		Locale[] locales = Locale.getAvailableLocales();
		for(int i=0; i < locales.length; i++) {
			System.out.println(locales[i].getDisplayCountry() + locales[i].getCountry()+"="+locales[i].getDisplayLanguage() + "=" +locales[i].getLanguage());
		}
	}
}
