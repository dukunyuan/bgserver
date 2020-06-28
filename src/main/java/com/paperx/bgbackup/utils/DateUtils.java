package com.paperx.bgbackup.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 取得服务器时间 String格式
     *
     * @return
     */
    public static String dateTimeStr() {
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataString = format.format(currentTime);
        return dataString;
    }

    /**
     * 取得服务器时间 Date格式
     * 格式为yyyy--MM--dd HH:mm:ss
     */
    public static Date dateTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        return date;
    }

    /**
     * 格式为yyyy--MM--dd
     */
    public static Date formatTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM--dd");
        format.format(date);
        return date;
    }

    /**
     * 格式为yyyy--MM--dd
     */
    public static String formatTimeStr() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(date);
        return dateStr;
    }

    /**
     * Date 转换为  yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static String formatTimeStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static Date formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM--dd");
        format.format(date);
        return date;
    }

    /**
     * 获取为  yyyy-MM-dd HH:mm:ss 星期三格式
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getYearDate() {
        Date mydate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tle = format.format(mydate);
        tle += " 星期";
        tle += "天一二三四五六".charAt(mydate.getDay());
        return tle;
    }

    /**
     * 取得服务器时间 String格式
     *
     * @return
     */
    public static String doFindDate() {
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dataString = format.format(currentTime);
        return dataString;
    }

    /**
     * String型日期转换date格式
     *
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dataString = format.parse(date);
        return dataString;
    }

    public static Date strToDateToDay(String date) throws ParseException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataString = format.parse(date);
        return dataString;
    }

    public static Date strToDateToHourse(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataString = format.parse(date);
        return dataString;
    }

    //Date转Timestamp
    public static Timestamp getTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    public static String formatTimeStr(Timestamp date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String format(Long dateTime, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        String date = format.format(dateTime);
        return date;
    }
}