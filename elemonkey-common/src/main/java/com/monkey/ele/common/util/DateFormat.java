package com.monkey.ele.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Burgess Li
 */
public final class DateFormat {

    private static final SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private DateFormat() {}

    public static String formatHHMM(Date date) {
        return HHmm.format(date);
    }

    public static String formatYYYYMMDD(Date date) {
        return yyyyMMdd.format(date);
    }

    public static String formatYYYYMMDDHHMMSS(Date date) {
        return yyyyMMddHHmmss.format(date);
    }

    public static Date parseHHMM(String s) {
        Date date = null;
        try {
            date = HHmm.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseYYYYMMDD(String s) {
        Date date = null;
        try {
            date = yyyyMMdd.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseYYYYMMDDHHMMSS(String s) {
        Date date = null;
        try {
            date = yyyyMMddHHmmss.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static boolean compareOpen(String start, String close){
        Date date_now = new Date();
        Calendar c_start = Calendar.getInstance();
        Calendar c_end = Calendar.getInstance();
        c_start.set(Calendar.HOUR_OF_DAY,Integer.parseInt(start.split(":")[0]));
        c_start.set(Calendar.MINUTE,Integer.parseInt(start.split(":")[1]));
        c_end.set(Calendar.HOUR,Integer.parseInt(close.split(":")[0]));
        c_end.set(Calendar.MINUTE,Integer.parseInt(close.split(":")[1]));
        if(Integer.parseInt(start.split(":")[0])>Integer.parseInt(close.split(":")[0]))
        {
            c_end.add(Calendar.DATE,1);
        }
        if(c_start.getTime().before(date_now)&&c_end.getTime().after(date_now)){
            return true;
        }
        return false;
    }

}
