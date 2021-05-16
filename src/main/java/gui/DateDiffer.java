package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiffer extends Date {
	private static final long serialVersionUID = 3969233325307777884L;
	
	public static Date toDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}
	public static String toString(Date date) {
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();		
		return year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
	}
}
