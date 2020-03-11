package edu.fzu.infect.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author xjliang
 */
public class MyUtils {

    /**
     * 自动生成 uuid
     * @return
     */
    public static String getUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 日期转 String "yyyy-MM-dd HH:mm:ss"
     * @param date
     * @param flag
     * @return
     */
    public static String dateToStr(Date date, String flag) {
        SimpleDateFormat sdf = new SimpleDateFormat(flag);
        String str = sdf.format(date);
        return str;
    }

    /**
     * String 转日期 "yyyy-MM-dd HH:mm:ss"
     * @param str
     * @param flag
     * @return
     */
    public static Date strToDate(String str, String flag) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(flag);
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * String 转 int
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        return Integer.parseInt(str);
    }

    /**
     * double 转int
     * @param d
     * @return
     */
    public static int doubleToInt(double d) {
        return new Double(d).intValue();
    }

    /**
     * 得到昨天的日期
     * @return
     */
    public static String getYesterdayByDate() {
        //实例化当天的日期
        Date today = new Date();
        //用当天的日期减去昨天的日期
        Date yesterdayDate = new Date(today.getTime() - 86400000L);
        return new SimpleDateFormat("yyyyMMdd").format(yesterdayDate);
    }

    /**
     * format of date is "yyyy-MM-dd"
     * @param startTime
     * @param endTime
     * @param flag
     * @return
     */
    public static List<String> getDays(String startTime, String endTime, String flag) {
        // 返回的日期集合
        List<String> days = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat(flag);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            // 日期加1(包含结束)
            tempEnd.add(Calendar.DATE, +1);

            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println(dateFormat.format(today));
        List<String> list = MyUtils.getDays("20200210", dateFormat.format(today), "yyyyMMdd");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
