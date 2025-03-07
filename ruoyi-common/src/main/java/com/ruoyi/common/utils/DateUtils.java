package com.ruoyi.common.utils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /** 学校年历 */
    //第一周
    private static LocalDateTime firstStart = LocalDateTime.of(2025, 2, 17, 0, 0, 0);
    private static LocalDateTime firstEnd = LocalDateTime.of(2025, 2, 23, 23, 59, 59);

    //第二周
    private static LocalDateTime secondStart = LocalDateTime.of(2025, 2, 24, 0, 0, 0);
    private static LocalDateTime secondEnd = LocalDateTime.of(2025, 3, 2, 23, 59, 59);

    //第三周
    private static LocalDateTime thirdlyStart = LocalDateTime.of(2025, 3, 3, 0, 0, 0);
    private static LocalDateTime thirdlyEnd = LocalDateTime.of(2025, 3, 9, 23, 59, 59);

    //第四周
    private static LocalDateTime fourthlyStart = LocalDateTime.of(2025, 3, 10, 0, 0, 0);
    private static LocalDateTime fourthlyEnd = LocalDateTime.of(2025, 3, 16, 23, 59, 59);

    //第五周
    private static LocalDateTime fifthStart = LocalDateTime.of(2025, 3, 17, 0, 0, 0);
    private static LocalDateTime fifthEnd = LocalDateTime.of(2025, 3, 23, 23, 59, 59);

    //第六周
    private static LocalDateTime sixthStart = LocalDateTime.of(2025, 3, 24, 0, 0, 0);
    private static LocalDateTime sixthEnd = LocalDateTime.of(2025, 3, 30, 23, 59, 59);

    //第七周
    private static LocalDateTime seventhStart = LocalDateTime.of(2025, 3, 31, 0, 0, 0);
    private static LocalDateTime seventhEnd = LocalDateTime.of(2025, 4, 06, 23, 59, 59);

    //第八周
    private static LocalDateTime eighthStart = LocalDateTime.of(2025, 4, 7, 0, 0, 0);
    private static LocalDateTime eighthEnd = LocalDateTime.of(2025, 4, 13, 23, 59, 59);

    //第九周
    private static LocalDateTime ninthStart = LocalDateTime.of(2025, 4, 14, 0, 0, 0);
    private static LocalDateTime ninthEnd = LocalDateTime.of(2025, 4, 20, 23, 59, 59);

    //第十周
    private static LocalDateTime tenthStart = LocalDateTime.of(2025, 4, 21, 0, 0, 0);
    private static LocalDateTime tenthEnd = LocalDateTime.of(2025, 4, 27, 23, 59, 59);

    //第十一周
    private static LocalDateTime eleventhStart = LocalDateTime.of(2025, 4, 28, 0, 0, 0);
    private static LocalDateTime eleventhEnd = LocalDateTime.of(2025, 5, 4, 23, 59, 59);

    //第十二周
    private static LocalDateTime twelfthStart = LocalDateTime.of(2025, 5, 5, 0, 0, 0);
    private static LocalDateTime twelfthEnd = LocalDateTime.of(2025, 5, 11, 23, 59, 59);

    //第十三周
    private static LocalDateTime thirteenthStart = LocalDateTime.of(2025, 5, 12, 0, 0, 0);
    private static LocalDateTime thirteenthEnd = LocalDateTime.of(2025, 5, 18, 23, 59, 59);

    //第十四周
    private static LocalDateTime fourteenthStart = LocalDateTime.of(2025, 5, 19, 0, 0, 0);
    private static LocalDateTime fourteenthEnd = LocalDateTime.of(2025, 5, 25, 23, 59, 59);

    //第十五周
    private static LocalDateTime fifteenthStart = LocalDateTime.of(2025, 5, 26, 0, 0, 0);
    private static LocalDateTime fifteenthEnd = LocalDateTime.of(2025, 6, 1, 23, 59, 59);

    //第十六周
    private static LocalDateTime sixteenthStart = LocalDateTime.of(2025, 6, 2, 0, 0, 0);
    private static LocalDateTime sixteenthEnd = LocalDateTime.of(2025, 6, 8, 23, 59, 59);

    //第十七周
    private static LocalDateTime seventeenthStart = LocalDateTime.of(2025, 6, 9, 0, 0, 0);
    private static LocalDateTime seventeenthEnd = LocalDateTime.of(2025, 6, 15, 23, 59, 59);

    //第十八周
    private static LocalDateTime eighteenthStart = LocalDateTime.of(2025, 6, 16, 0, 0, 0);
    private static LocalDateTime eighteenthEnd = LocalDateTime.of(2025, 6, 22, 23, 59, 59);

    //第十九周
    private static LocalDateTime nineteenthStart = LocalDateTime.of(2025, 6, 23, 0, 0, 0);
    private static LocalDateTime nineteenthEnd = LocalDateTime.of(2025, 6, 29, 23, 59, 59);

    //第二十周
    private static LocalDateTime twentiethStart = LocalDateTime.of(2025, 6, 30, 0, 0, 0);
    private static LocalDateTime twentiethEnd = LocalDateTime.of(2025, 7, 6, 23, 59, 59);

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算时间差
     *
     * @param endDate 最后时间
     * @param startTime 开始时间
     * @return 时间差（天/小时/分钟）
     */
    public static String timeDistance(Date endDate, Date startTime)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startTime.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 增加 LocalDateTime ==> Date
     */
    public static Date toDate(LocalDateTime temporalAccessor)
    {
        ZonedDateTime zdt = temporalAccessor.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * 增加 LocalDate ==> Date
     */
    public static Date toDate(LocalDate temporalAccessor)
    {
        LocalDateTime localDateTime = LocalDateTime.of(temporalAccessor, LocalTime.of(0, 0, 0));
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * 根据给定的日期给出是星期几
     * @param date
     * @return
     */
    public static String getWeekStr(Date date){
        // 将 Date 转换为 LocalDate
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        // 获取星期几
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String weekStr = "";
        //选择星期的中文
        switch (dayOfWeek.name()){
            case "MONDAY":
                weekStr = "星期一";
                break;
            case "TUESDAY":
                weekStr = "星期二";
                break;
            case "WEDNESDAY":
                weekStr = "星期三";
                break;
            case "THURSDAY":
                weekStr = "星期四";
                break;
            case "FRIDAY":
                weekStr = "星期五";
                break;
            case "SATURDAY":
                weekStr = "星期六";
                break;
            case "SUNDAY":
                weekStr = "星期日";
                break;
        }
        return weekStr;
    }

    /**
     * 根据日期获取教学周
     * @param date
     * @return
     */
    public static String getSchoolWeekStr(Date date){
        LocalDateTime current = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        String weekStr;

        if (firstStart.isBefore(current) && firstEnd.isAfter(current)){
            weekStr = "第一周";
        }else if (secondStart.isBefore(current) && secondEnd.isAfter(current)){
            weekStr = "第二周";
        }else if (thirdlyStart.isBefore(current) && thirdlyEnd.isAfter(current)){
            weekStr = "第三周";
        }else if (fourthlyStart.isBefore(current) && fourthlyEnd.isAfter(current)){
            weekStr = "第四周";
        }else if (fifthStart.isBefore(current) && fifthEnd.isAfter(current)){
            weekStr = "第五周";
        }else if (sixthStart.isBefore(current) && sixthEnd.isAfter(current)){
            weekStr = "第六周";
        }else if (seventhStart.isBefore(current) && seventhEnd.isAfter(current)){
            weekStr = "第七周";
        }else if (eighthStart.isBefore(current) && eighthEnd.isAfter(current)){
            weekStr = "第八周";
        }else if (ninthStart.isBefore(current) && ninthEnd.isAfter(current)){
            weekStr = "第九周";
        }else if (tenthStart.isBefore(current) && tenthEnd.isAfter(current)){
            weekStr = "第十周";
        }else if (eleventhStart.isBefore(current) && eleventhEnd.isAfter(current)){
            weekStr = "第十一周";
        }else if (twelfthStart.isBefore(current) && twelfthEnd.isAfter(current)){
            weekStr = "第十二周";
        }else if (thirteenthStart.isBefore(current) && thirteenthEnd.isAfter(current)){
            weekStr = "第十三周";
        }else if (fourteenthStart.isBefore(current) && fourteenthEnd.isAfter(current)){
            weekStr = "第十四周";
        }else if (fifteenthStart.isBefore(current) && fifteenthEnd.isAfter(current)){
            weekStr = "第十五周";
        }else if (sixteenthStart.isBefore(current) && sixteenthEnd.isAfter(current)){
            weekStr = "第十六周";
        }else if (seventeenthStart.isBefore(current) && seventeenthEnd.isAfter(current)){
            weekStr = "第十七周";
        }else if (eighteenthStart.isBefore(current) && eighteenthEnd.isAfter(current)){
            weekStr = "第十八周";
        }else if (nineteenthStart.isBefore(current) && nineteenthEnd.isAfter(current)){
            weekStr = "第十九周";
        }else if (twentiethStart.isBefore(current) && twentiethEnd.isAfter(current)){
            weekStr = "第二十周";
        }else{
            weekStr = "无法识别";
        }



        return weekStr;
    }

}
