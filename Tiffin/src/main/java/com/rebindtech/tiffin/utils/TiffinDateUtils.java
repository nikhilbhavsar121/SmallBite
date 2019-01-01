package com.rebindtech.tiffin.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Sagar
 */
public class TiffinDateUtils {

    public static final String date_time_format = "MMMM dd, yyyy HH:mm:ss";
    public static final String timeFormat_hh_mm = "HH:mm";
    public static final String dateFormat_hh_mm_a = "h:mm a";
    public static final String dateFormat_YYYY_MM_DD = "yyyy-MM-dd";

    public static Date getCurrentDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = getTimeZoneDate("Asia/Kolkata");
        String strDt = (String) dateFormat.format(date);
        try {
            date = dateFormat.parse(strDt);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static Date getCurrentDate() {
        return getTimeZoneDate("Asia/Kolkata");
    }

    public static String getFormattedDateString(Date date) {
        if (date != null) {
            String formatDt = "";
            SimpleDateFormat dateFormat = new SimpleDateFormat(date_time_format);
            formatDt = dateFormat.format(date);
            return formatDt;
        }
        return null;
    }

    public static Date getFormatedTimeHH_MMFromString(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat_hh_mm);
        Date date = null;
        try {
            date = dateFormat.parse(dateTime);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static String getTimeStringFor12HrsFromDateTime(Date dateTime) {
        SimpleDateFormat SDF = new SimpleDateFormat(dateFormat_hh_mm_a);
        String time = SDF.format(dateTime);
        return time;
    }

    public static Date getFormattedDate(String apptDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormat_YYYY_MM_DD);
        Date date = null;
        try {
            date = dateFormat.parse(apptDate);
        } catch (ParseException ex) {
        }
        return date;
    }

    public static Date getFormatedDate_YYYY_MM_DD_FromString(String dateTime) {
        SimpleDateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try {
            date = originalFormat.parse(dateTime);
        } catch (ParseException ex) {
        }
        return date;
    }
public static Date getCurrentDateOnly(){
    Date date = null;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        date = cal.getTime();
        return date;
}
    public static Date getDateAfterxDays(Date startDate, int days) {
        Date date = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        date = cal.getTime();
        return date;

    }

    public static Date getTimeZoneDate(String timeZone) {
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        Calendar timeZoneDt = Calendar.getInstance(tz);
        Calendar calendar = Calendar.getInstance();
        calendar.set(timeZoneDt.get(Calendar.YEAR), timeZoneDt.get(Calendar.MONTH), timeZoneDt.get(Calendar.DATE),
                timeZoneDt.get(Calendar.HOUR_OF_DAY), timeZoneDt.get(Calendar.MINUTE), (timeZoneDt.get(Calendar.SECOND) + 90));
        return calendar.getTime();
    }

}
