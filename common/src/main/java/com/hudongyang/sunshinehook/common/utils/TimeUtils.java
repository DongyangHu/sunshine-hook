package com.hudongyang.sunshinehook.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/18 19:34
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {

    private static final long SECOND_UNIT = 1000;
    private static final long MINUTE_UNIT = SECOND_UNIT * 60;
    private static final long HOUR_UNIT = MINUTE_UNIT * 60;
    private static final long DAY_UNIT = HOUR_UNIT * 24;
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter NORMAL = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);

    /**
     * 格式化时间
     *
     * @param millis 毫秒时间
     * @return 0D-0H-0M-0S
     */
    public static String formatTime(long millis) {
        long remainder = millis;
        long days = millis / DAY_UNIT;
        remainder = remainder - DAY_UNIT * days;
        long hours = remainder / HOUR_UNIT;
        remainder = remainder - HOUR_UNIT * hours;
        long minutes = remainder / MINUTE_UNIT;
        remainder = remainder - MINUTE_UNIT * minutes;
        long seconds = remainder / SECOND_UNIT;
        return days + "D-" + hours + "H-" + minutes + "M-" + seconds + "S";
    }

    /**
     * 格式化时间
     *
     * @param millis 时间戳
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String formatDate(long millis) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), DEFAULT_ZONE_ID).format(NORMAL);
    }

    /**
     * 当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String now() {
        return NORMAL.format(LocalDateTime.now());
    }
}
