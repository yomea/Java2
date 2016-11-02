import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("app", Locale.CHINA);
		System.out.println(rb.getString("welcome"));
	}

}
