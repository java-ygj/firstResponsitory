package com.hqyj.personel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransfer {
	public static Date stringToDate(String date) {
		if(date!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return sdf.parse(date);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
		}
		return null;
	}
}
