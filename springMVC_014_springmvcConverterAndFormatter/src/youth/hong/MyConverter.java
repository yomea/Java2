package youth.hong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyConverter implements Converter<String, Date> {
	private String datePattern;
	
	public MyConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
	}


	@Override
	public Date convert(String dateStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
