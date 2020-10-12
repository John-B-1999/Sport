package com.example.sportApp.utils.copyUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 */
public class DateUtils {

    /**
     * String(yyyy-MM-dd)转换为Date类型
     *
     * @param date 日期字符串
     */
    public static Date stringToDate(String date) throws Exception {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.parse(date);
    }

    /**
     * String根据格式转换为Date类型
     *
     * @param date   日期字符串
     * @param format 格式
     *               yyyy-MM-dd hh:mm:ss,  HH指12小时制
     *               yyyy-MM-dd HH:mm:ss,  HH指24小时制
     *               yyyy-MM-dd
     */
    public static Date stringToDate(String date, String format) throws Exception {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        return formater.parse(date);
    }


    /**
     * 格式化日期
     *
     * @param before 日期
     * @param format 格式
     *               yyyy-MM-dd hh:mm:ss,  HH指12小时制
     *               yyyy-MM-dd HH:mm:ss,  HH指24小时制
     *               yyyy-MM-dd
     */
    public static Date formatDate(Date before, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date after = formatter.parse(formatter.format(before));
        return after;
    }


    /**
     * 格式化日期
     *
     * @param before 日期
     *               默认格式化为yyyy-MM-dd hh:mm:ss
     */
    public static Date formatDate(Date before) throws Exception {
        return formatDate(before, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 格式化日期返回String
     *
     * @param before 日期
     * @param format 格式
     *               yyyy-MM-dd hh:mm:ss,  HH指12小时制
     *               yyyy-MM-dd HH:mm:ss,  HH指24小时制
     *               yyyy-MM-dd
     */
    public static String formatString(Date before, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(before);
    }


    /**
     * 获取本月1号0时0分0秒
     */
    public static Date getCurrentMonthFirst() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本月最后一天0时0分0秒
     */
    public static Date getCurrentMonthEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定月份1号0时0分0秒
     *
     * @param month 月份
     *              默认当前年份
     */
    public static Date getMonthFirst(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), (month - 1), 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定月份最后一天0时0分0秒
     *
     * @param month 月份
     *              默认当前年份
     */
    public static Date getMonthEnd(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), month, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定年份指定月份1号0时0分0秒
     *
     * @param year  年份
     * @param month 月份
     */
    public static Date getYearMonthFirst(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, (month - 1), 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定年份指定月份最后一天0时0分0秒
     *
     * @param year  年份
     * @param month 月份
     *              默认当前年份
     */
    public static Date getYearMonthEnd(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周一0时0分0秒
     */
    public static Date getCurrentWeekMonday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周二0时0分0秒
     */
    public static Date getCurrentWeekTuesday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周三0时0分0秒
     */
    public static Date getCurrentWeekWednesday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周四0时0分0秒
     */
    public static Date getCurrentWeekThursday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周五0时0分0秒
     */
    public static Date getCurrentWeekFriday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周六0时0分0秒
     */
    public static Date getCurrentWeekSaturday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取本周周日0时0分0秒
     */
    public static Date getCurrentWeekSunday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周一0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekMonday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周二0时0分0秒
     */
    public static Date getWeekTuesday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周三0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekWednesday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周四0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekThursday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周五0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekFriday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周六0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekSaturday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取指定日期周周日0时0分0秒
     *
     * @param date 日期
     */
    public static Date getWeekSunday(Date date) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        // 设置每周第一个元素，设置为周一
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取两个日期相差天数(toDate - fromDate)
     *
     * @param toDate   日期
     * @param fromDate 日期
     */
    public static int daysBetween(Date fromDate, Date toDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        long fromTime = calendar.getTimeInMillis();

        calendar.setTime(toDate);
        long toTime = calendar.getTimeInMillis();

        long between_days = (toTime - fromTime) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 获取当前年份字符串
     */
    public static String getYear() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy");
        return formater.format(new Date());
    }


    /**
     * 获取当前月份字符串
     */
    public static String getMonth() {
        SimpleDateFormat formater = new SimpleDateFormat("MM");
        return formater.format(new Date());
    }


    /**
     * 获取当前天数字符串
     */
    public static String getDay() {
        SimpleDateFormat formater = new SimpleDateFormat("dd");
        return formater.format(new Date());
    }


    /**
     * 获取当前星期字符串
     */
    public static String getWeek() {
        SimpleDateFormat formater = new SimpleDateFormat("E");
        return formater.format(new Date());
    }


    /**
     * 获取当前日期指定天数之后的日期
     *
     * @param num 指定天数
     */
    public static Date nextDay(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + num);
        return calendar.getTime();
    }


    /**
     * 获取当前日期指定月数之后的日期
     *
     * @param num 指定天数
     */
    public static Date nextMonth(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + num);
        return calendar.getTime();
    }


    /**
     * 获取当前日期指定年数之后的日期
     *
     * @param num 指定天数
     */
    public static Date nextYear(int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + num);
        return calendar.getTime();
    }


    /**
     * 获取与指定日期间隔给定天数的日期
     *
     * @param specifiedDay 指定日期
     * @param num          间隔天数
     *                     默认格式yyyy-MM-dd
     */
    public static String getSpecifiedDayAfter(String specifiedDay, int num) throws Exception {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date specifiedDate = formater.parse(specifiedDay);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specifiedDate);

        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + num);

        return formater.format(calendar.getTime());
    }


    /**
     * 获取与指定日期间隔给定天数的日期
     *
     * @param specifiedDay 指定日期
     * @param num          间隔天数
     * @param format       格式
     *                     yyyy-MM-dd hh:mm:ss,  HH指12小时制
     *                     yyyy-MM-dd HH:mm:ss,  HH指24小时制
     *                     yyyy-MM-dd
     */
    public static String getSpecifiedDayAfter(String specifiedDay, String format, int num) throws Exception {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        Date specifiedDate = formater.parse(specifiedDay);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specifiedDate);

        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + num);

        return formater.format(calendar.getTime());
    }


    /**
     * 获取现在时间小时（24小时制）
     */
    public static String getHours() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        return formatter.format(date);
    }


    /**
     * 获取现在时间小时（12小时制）
     */
    public static String getHour() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh");
        return formatter.format(date);
    }


    /**
     * 获取现在时间分钟
     */
    public static String getMinute() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        return formatter.format(date);
    }


    /**
     * 获取现在时间秒
     */
    public static String getSecond() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ss");
        return formatter.format(date);
    }


    /**
     * 遍历得到时间段的时间列表
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
     */
    public static List<Date> iterateDate(Date startDate, Date endDate) {
        List<Date> dateList = new ArrayList<>();

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startDate);
        c2.setTime(endDate);

        while (c1.before(c2)) {
            dateList.add(c1.getTime());
            c1.add(Calendar.DATE, 1);
        }
        dateList.add(endDate);

        return dateList;
    }

    /**
     * 获取日期的小时和分钟
     *
     * @param date 日期
     *             HH:mm格式
     */
    public static String getHourMinte(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param date        日期
     * @param anotherDate 日期
     */
    public static boolean equalSameDay(Date date, Date anotherDate) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String thisDate = formatter.format(date);
        String another = formatter.format(anotherDate);

        if (thisDate.equals(another)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
    }
}
