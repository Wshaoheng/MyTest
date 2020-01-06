package com.ygjx.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateType {
	public static Date getDateType(String date) {
		Date date2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
				date2 = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
	}
	public static String getDateType(Date date) {
		String date2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date2 = sdf.format(date);
		return date2;
	}
}

