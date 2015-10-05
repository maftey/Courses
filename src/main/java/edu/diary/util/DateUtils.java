package edu.diary.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtils {

	  static SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");

	  public static GregorianCalendar convertFromDMY(String dd_mm_yy){
	    String[] splitDate = dd_mm_yy.split("\\p{Punct}");
	    int days = Integer.parseInt(splitDate[0]);
	    int month = (Integer.parseInt(splitDate[1]) - 1);
	    int year = Integer.parseInt(splitDate[2]);

	    GregorianCalendar dateConverted = new GregorianCalendar(year, month, days);
//	    String finalDate = format(dateConverted);
	    return dateConverted;
	  }

	  public static String format(GregorianCalendar calendar){
		    SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		    fmt.setCalendar(calendar);
		    String dateFormatted = fmt.format(calendar.getTime());
		    return dateFormatted;
		}

	  public static java.util.Date sqlDatetoUtilDate(java.sql.Date sqlDate){
			java.util.Date utilDate = sqlDate;
			return utilDate;
		}
		
	  public static java.sql.Date utilDateToSqlDate(Calendar utilDate){
			Date sqlDate = new java.sql.Date((utilDate.getTime()).getTime());
			return sqlDate;
		}
	  }