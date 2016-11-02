package youth.hong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyFormatter implements Formatter<Date> {
	
	private String datePattern;
	
	public MyFormatter(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public String print(Date date, Locale arg1) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		String s = sdf.format(date);
		return s;
	}

	@Override
	public Date parse(String arg0, Locale arg1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		return sdf.parse(arg0);
	}

}
