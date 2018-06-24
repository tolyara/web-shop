package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParserUtil {

	public static java.sql.Date recognizeSqlDate(String string) {
		java.sql.Date enteredDate_sql;
		try {
			enteredDate_sql = new java.sql.Date(
					DateParserUtil.parseDateFromString(string).getTime());
		} catch (ParseException e1) {
			enteredDate_sql = null;
			e1.printStackTrace();
		}
		return enteredDate_sql;
	}

	private static Date parseDateFromString(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy.MM.dd");
		Date creationDate;
		creationDate = format.parse(string);
		return creationDate;
	}

}
