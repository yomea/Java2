package com.bjsxt.oa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class UtilDateConverter implements Converter {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public Object convert(Class type, Object value) {
		if (value == null) {
			return value;
		}
		if (value instanceof Date) {
			return value;
		}
		if (value instanceof String) {
			try {
				return format.parse((String)value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
