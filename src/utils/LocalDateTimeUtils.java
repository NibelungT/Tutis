package utils;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shitao.liu
 * @Description:
 * @Date 17:522020/8/4
 */
public class LocalDateTimeUtils {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter DATE_HOUR_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter DATE_FORM = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final DateTimeFormatter DATE_YEAR_NUM = DateTimeFormatter.ofPattern("yyyy");

    private static final String[][] WEEK_ARRAY = {{"MONDAY", "1"}, {"TUESDAY", "2"}, {"WEDNESDAY", "3"}, {"THURSDAY", "4"}, {"FRIDAY", "5"}, {"SATURDAY", "6"}, {"SUNDAY", "7"}};

    private LocalDateTimeUtils() {
        throw new AssertionError();
    }

    /**
     * 获取当前日期字符串
     * @return
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期字符串
     * @return
     */
    public static String getCurrentDateStrNoLine() {
        return LocalDate.now().format(DATE_FORM);
    }
    /**
     * 获取当前年份数字
     * @return
     */
    public static String getCurrentDateYearStr() {
        return LocalDate.now().format(DATE_YEAR_NUM);
    }

    /**
     * 获取当前日期时间字符串
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * 获取秒级别时间戳
     * @return
     */
    public static Long getSecond(){
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 获取毫秒级别时间戳
     * @return
     */
    public static Long getMilliSecond(){
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * Date 转 LocalDate
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * date 转毫秒级别时间戳
     * @param date
     * @return
     */
    public static Long dateTOTimeStamp(Date date){
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    /**
     * Date 转 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {

        if (date == null){
            return null;
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date 转 日期字符串
     * @param date
     * @return
     */
    public static String dateToDateStr(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER);
    }

    /**
     * Date 转 日期时间字符串
     * @param date
     * @return
     */
    public static String dateToDateTimeStr(Date date) {

        if (date == null){
            return null;
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(DATE_TIME_FORMATTER);
    }

    /**
     * 根据时间戳获取时间（秒级别）
     * @param timeStamp 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime  timeStampToLocalDateTime(Long timeStamp){
        return LocalDateTime.ofEpochSecond(timeStamp, 0, ZoneOffset.ofHours(8));
    }

    /**
     * 根据时间戳获取时间（秒级别）
     * @param timeStamp 时间戳
     * @return Date
     */
    public static Date timeStampToDate(Long timeStamp){
        return Date.from(LocalDateTime.ofEpochSecond(timeStamp, 0, ZoneOffset.ofHours(8)).atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * LocalDate 转 Date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime 转 Date
     * @param localDateTime
     * @localDateTimeToDateStr
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate 转 日期字符串
     * @param localDate
     * @return
     */
    public static String localDateToDateStr(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }


    /**
     * LocalDate 转 日期字符串
     * @param localDateTime
     * @return
     */
    public static String localDateTimeToDateStr(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMATTER);
    }

    /**
     * LocalDateTime 转 日期时间字符串
     * @param localDateTime
     * @return
     */
    public static String localDateTimeToDateTimeStr(LocalDateTime localDateTime) {
        if (localDateTime == null){
            return null;
        }

        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * 日期时间字符串 转 LocalDateTime
     * @param dateTimeStr
     * @return
     */
    public static LocalDateTime dateTimeStrToLocalDateTime(String dateTimeStr) {
        if (dateTimeStr == null || "".equals(dateTimeStr)){
            return null;
        }

        return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }

    /**
     * 日期时间字符串 转 LocalDateTime
     * @param dateTimeStr
     * @return
     */
    public static LocalDateTime dateTimeStrToLocalDateHour(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATE_HOUR_FORMATTER);
    }


    /**
     * LocalDate 转 日期字符串
     * @return
     */
    public static String localDateTimeToLocalDateHour(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_HOUR_FORMATTER);
    }

    /**
     * 日期字符串 转 LocalDate
     * @param dateStr
     * @return
     */
    public static LocalDate dateStrToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /**
     * 日期字符串 转 Date
     * @param dateStr
     * @return
     */
    public static Date dateStrToDate(String dateStr) {
        return Date.from(LocalDate.parse(dateStr, DATE_FORMATTER).atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    /**
     * 日期时间字符串 转 Date
     * @param dateStr
     * @return
     */
    public static Date dateTimeStrToDate(String dateStr) {

        return Date.from(LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER).atZone(ZoneId.systemDefault()).toInstant());

    }


    public static Long dateTImeStrToTimeStamp(String dateStr){
       return dateTOTimeStamp(dateTimeStrToDate(dateStr));
    }

    /**
     * 比较第一个日期是否小于第二个日期
     * @param firstDate 第一个日期
     * @param secondDate 第二个日期
     * @return true-小于;false-大于
     */
    public boolean localDateIsBefore(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate);
    }


    /**
     * 比较第一个日期是否大于第二个日期
     * @param firstDate 第一个日期
     * @param secondDate 第二个日期
     * @return true-大于;false-不大于
     */
    public boolean localDateIsAfter(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isAfter(secondDate);
    }

    /**
     * 比较第一个日期是否大于第二个日期
     * @param firstDate 第一个日期
     * @param secondDate 第二个日期
     * @return true-大于;false-不大于
     */
    public boolean localDateTimeIsAfter(LocalDateTime firstDate, LocalDateTime secondDate) {
        return firstDate.isAfter(secondDate);
    }

    /**
     * 比较两个日期是否相等
     * @param firstDate 第一个日期
     * @param secondDate 第二个日期
     * @return true-相等;false-不相等
     */
    public boolean localDateIsEqual(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isEqual(secondDate);
    }

    /**
     * 毫秒级时间戳转LocalDateTime
     * @return LocalDateTime
     */
    public static LocalDateTime millisecondToLocalDateTime(Long millisecond){
        return new Date(millisecond).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    /**
     * 毫秒级别时间戳转Date
     * @param millisecond 毫秒级别时间戳
     * @return Date
     */
    public static Date millisecondToDate(Long millisecond){
        return new Date(millisecond);
    }

    /**
     * 得到两个时间的间隔
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 间隔的毫秒数
     */
    public static Long getTimeInterval(Date startTime,Date endTime){

        LocalDateTime startLocalDateTime = LocalDateTimeUtils.dateToLocalDateTime(startTime);

        LocalDateTime endLocalDateTime = LocalDateTimeUtils.dateToLocalDateTime(endTime);

        Duration duration = Duration.between(startLocalDateTime,endLocalDateTime);
        return duration.toMillis();
    }

    /**
     * 得到两个时间的间隔
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 间隔的毫秒数
     */
    public static Long getTimeIntervalToMinutes(Date startTime,Date endTime){

        LocalDateTime startLocalDateTime = LocalDateTimeUtils.dateToLocalDateTime(startTime);

        LocalDateTime endLocalDateTime = LocalDateTimeUtils.dateToLocalDateTime(endTime);

        Duration duration = Duration.between(startLocalDateTime,endLocalDateTime);
        return duration.toMinutes();
    }


    /**
     * 得到两个时间的间隔
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 间隔的毫秒数
     */
    public static Long getLocalDateTimeIntervalToMinutes(LocalDateTime startTime,LocalDateTime endTime){

        if (startTime == null || endTime == null){
            return null;
        }

        Duration duration = Duration.between(startTime,endTime);
        return duration.toMinutes();
    }

    /**
     * 得到当前时间到指定时间时间的间隔
     * @param endTime 结束时间
     * @return 间隔的毫秒数
     */
    public static Long getTimeInterval(LocalDateTime startTime,LocalDateTime endTime,Long time,ChronoUnit unit){

        Duration duration = Duration.between(startTime,endTime.minus(time,unit));
        return duration.toMillis();
    }


    /**
     * 得到当前时间到指定时间时间的间隔
     * @param endTime 结束时间
     * @return 间隔的毫秒数
     */
    public static Long getTimeInterval(LocalDateTime startTime,LocalDateTime endTime){
        Duration duration = Duration.between(startTime,endTime);
        return duration.toMillis();
    }

    public static long getMinuteDiff(Date date1, Date date2) {

        if (date1 == null || date2 == null){
            return 0;
        }

        long diffInMillies = date2.getTime() - date1.getTime();

        return TimeUnit.MILLISECONDS.toMinutes(diffInMillies);

    }



    /**
     * 得到到今天结束时间所需的时间戳(毫秒)
     * @return 毫秒
     */
    public static Long getToTodayEndForTimeStamp(){
        LocalDateTime startTime = LocalDateTime.now();

        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        Duration duration = Duration.between(startTime,today_end);

        return duration.toMillis();
    }

    /**
     * 得到到今天结束时间所需的时间戳(毫秒)
     * @return 毫秒
     */
    public static Long getToTodayEndMinusForTimeStamp(Long time,ChronoUnit unit){
        LocalDateTime startTime = LocalDateTime.now();

        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).minus(time,unit);

        Duration duration = Duration.between(startTime,today_end);

        return duration.toMillis();
    }



    /**
     * 判断当前时间是否是今天
     * @param localDateTime Java8时间类
     * @return 是否是今天
     */
    public static Boolean isToday(LocalDateTime localDateTime){
        LocalDate today = LocalDate.now();

        LocalDate localDate = localDateTime.toLocalDate();

        return localDate.isEqual(today);

    }

    /**
     * 判断一个时间是否过期
     * @param localDateTime 起始时间
     * @param plusTime 过期时间
     * @param unit 时间单位
     * @return 是否过期
     */
    public static Boolean isExpiredTime(LocalDateTime localDateTime,Long plusTime,ChronoUnit unit){

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime endTime = localDateTime.plus(plusTime,unit);

        return endTime.isBefore(now);
    }
    /**
     * 描述 获取今天星期几
     * @return String
     */
    public static String getDayOfTheWeek() {
        LocalDate currentDate = LocalDate.now();
        String k = String.valueOf(currentDate.getDayOfWeek());
        //获取行数
        for (String[] strings : WEEK_ARRAY) {
            if (k.equals(strings[0])) {
                k = strings[1];
                break;
            }
        }
        return k;
    }


    /**
     *判断当前日期是否在[startDate,endDate]这个区间里，yyyy-MM-dd
     * @param startTime 开始日期
     * @param endTime 结束日期
     * @param time 时间区间
     * @return true在, false不在
     */
    public static boolean isEffectiveDate(LocalDateTime startTime,LocalDateTime endTime,LocalDateTime time){
        if (startTime == null || endTime == null) {
            return false;
        }

        if (time.isEqual(startTime) || time.isEqual(endTime)) {
            return true;
        }

        return time.isAfter(startTime) && time.isBefore(endTime);


    }
}
