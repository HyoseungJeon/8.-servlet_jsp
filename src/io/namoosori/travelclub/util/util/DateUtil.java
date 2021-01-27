package io.namoosori.travelclub.util.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	//(
	public static String toString(long dateTime) {
		//
		SimpleDateFormat dateFormat = getDefaultDateFormat();
		return dateFormat.format(dateTime);
	}

	private static SimpleDateFormat getDefaultDateFormat() {
		return new SimpleDateFormat("yyyy.MM.dd");
	}
	
	public static long toLong(String date) {
		long result = 0;
		SimpleDateFormat dateFormat = getDefaultDateFormat();
		try {
			result = dateFormat.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
