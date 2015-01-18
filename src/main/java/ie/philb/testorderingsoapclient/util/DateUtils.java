package ie.philb.testorderingsoapclient.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {

    public static java.sql.Timestamp dateToSqlTimestamp(java.util.Date uDate) {
        if (uDate == null) {
            return null;
        }
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return new Timestamp(sDate.getTime());
    }

    public static Date sqlTimestampToDate(Timestamp timestamp) {
        if (null == timestamp) {
            return null;
        }
        return new Date(timestamp.getTime());
    }

    public static java.sql.Date dateToSqlDate(java.util.Date uDate) {

        if (uDate == null) {
            return null;
        }

        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static java.util.Date sqlDateToDate(java.sql.Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }

        Date uDate = new Date(sqlDate.getTime());
        return uDate;
    }

    public static Calendar stringToCalendar(String dateStr, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = formatter.parse(dateStr);
        return (DateUtils.dateToCalendar(date));
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal);
    }

    public static String formatDate(XMLGregorianCalendar xgc, String format) {
      
        if (xgc == null) {
            return null;
        }

        return formatDate(xgc.toGregorianCalendar().getTime(), format);
    }

    public static String formatDate(Date date, String format) {
        if (date == null) {
            return ("");
        }

        SimpleDateFormat df = new SimpleDateFormat(format);
        String str = df.format(date);
        return str;
    }

    public static String formatDate(Calendar cal, String format) {
        if (cal == null) {
            return ("");
        }

        return formatDate(cal.getTime(), format);
    }

    public static java.util.Date addDaysToDate(java.util.Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);

        return cal.getTime();
    }

    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    private static Date parseDate(String str, SimpleDateFormat df) throws ParseException {
        if (str == null || str.trim().equals("")) {
            return null;
        }

        return df.parse(str);
    }
}
