package youth.hong;

import java.awt.Point;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Object value, @SuppressWarnings("rawtypes") Class toType) {
		if(toType == Point.class) {
			Point p = new Point();
			String[] s = (String[])value;
			String[] ss = s[0].split(",");
			p.x = Integer.parseInt(ss[0]);
			p.y = Integer.parseInt(ss[1]);
			return p;
		} else if(toType == String.class) {
			return value.toString();
		}
		return super.convertValue(value, toType);
	}

	
	
}
