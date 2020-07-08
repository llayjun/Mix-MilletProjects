package com.llayjun.millet.common.constant;

import java.time.format.DateTimeFormatter;

/**
 * 全局常量
 *
 * @author zhangyinlei
 * @since 2019/12/12
 */
public class Constants {

    /**
     * APP的API
     */
    public static final String APP_URI_V1 = "/api/app";

    /**
     * 活动时间格式
     */
    public static final String ACTIVITY_TIME_FORMAT = "([0-1][0-9]|2[0-3]):[0-5][0-9]";

    public static final String PASSWORD_FORMAT = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$";
    public static final String REGEX_NUMERIC = "[0-9]";
    public static final String REGEX_VIN = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{16,18}";
    public static final String REGEX_PHONE = "[1][0-9]{10}";
    public static final String REGEX_IMAGE_CODE = "[0-9]{4}";
    public static final String REGEX_SMS_CODE = "[0-9]{6}";
    public static final String REGEX_CAR_OWNER_PHONE_NUMBER = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
    public static final String REGEX_VEHICLE_NUMBER = "(^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]([a-hj-zA-HJ-Z][a-hj-np-zA-HJ-NP-Z0-9]{5,6})$)";

    /**
     * LocalDate 和 LocalDateTime 格式
     */
    public static final String DATE_TIME_START = " 00:00:00";
    public static final String DATE_TIME_END = " 23:59:59";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
}
