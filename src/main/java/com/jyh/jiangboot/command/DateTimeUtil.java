package com.jyh.jiangboot.command;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 时间工具类，所有日期、时间的处理使用Java8 API
 */
public class DateTimeUtil {

    /**
     * 将yyyy-MM-dd格式字符转转换为Date
     * @param s
     * @return
     */
    public static LocalDate string2Date(String s){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(s,formatter);
    }

    /**
     * 日期转字符串 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String date2String4(LocalDateTime date){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    /**
     * 日期转字符串yyyy-MM-dd
     * @param date
     * @return
     */
    public static String date2String(LocalDateTime date){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    /**
     * 给日期date增加day天
     * @param date
     * @param day
     * @return
     */
    public static LocalDateTime dateAddInt(LocalDateTime date,int day){
        return date.minusDays(day);
    }

    /**
     * 下月一号
     * @param date
     * @return
     */
    public static LocalDateTime getfirstDayOfNextMonth(LocalDateTime date){

        return date.with(TemporalAdjusters.firstDayOfNextMonth());

    }

    /**
     * 将yyyy-MM-dd格式字符转转换为DateTime
     * @param s
     * @return
     */
    public static LocalDateTime string2DateYMD(String s) {
        s+=" 00:00:00";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(s,formatter);

    }

    /**
     * 将'%Y/%m/%d %H:%M:%S'格式字符转转换为Date,截取到日
     * @param s
     * @return
     */
    public static LocalDateTime string2DateTime(String s){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return LocalDateTime.parse(s,formatter).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }


    public static LocalDateTime string2DateTime3(String s){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/M/d HH:mm:ss");
        return LocalDateTime.parse(s,formatter).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
    /**
     * 将'MM/dd/yyyy hh:mm:ss 时分秒为0
     * @param s
     * @return
     */
    public static LocalDateTime string2DateTime2(String s){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        return LocalDateTime.parse(s,formatter).withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取传入日期当周星期一
     * @param dateTime
     * @return
     */
    public static LocalDateTime getMonDayOfWeek(LocalDateTime dateTime){

        return dateTime.with(DayOfWeek.MONDAY);

    }


    /**
     * 获取下周一
     * @param date
     * @return
     */
    public static LocalDateTime getMonDayOfNextWeek(LocalDateTime date){
        return date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }


    /**
     * 获取本周一
     * @param date
     * @return
     */
    public static LocalDateTime getWednesdayOfWeek(LocalDateTime date){
        return date.with(DayOfWeek.WEDNESDAY);

    }

    /**
     * 获取传入日期当月的最后一天
     * @param date
     * @return
     */
    public static LocalDateTime getMonthLastDay(LocalDateTime date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }


    /**
     * 计算日期dateTime1跟dateTime2相差的天数，计算时忽略时分秒
     * @param dateTime1
     * @param dateTime2
     * @return
     */
    public static int diffDateByDay(LocalDateTime dateTime1,LocalDateTime dateTime2){
            LocalDate date1=dateTime1.toLocalDate();
            LocalDate date2=dateTime2.toLocalDate();
            Period diff=Period.between(date2,date1);
            return diff.getDays();
    }



}
