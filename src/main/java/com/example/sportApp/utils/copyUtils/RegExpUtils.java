package com.example.sportApp.utils.copyUtils;

import com.google.common.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegExpUtils {


    /**
     * 邮箱校验
     *
     * @param email 邮箱
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 判断是否是正确的IP地址
     *
     * @param ip ip地址
     */
    public static boolean isIp(String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return false;
        }

        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        return ip.matches(regex);
    }


    /**
     * 判断是否是正确的邮箱地址
     *
     * @param email 邮箱
     */
    public static boolean isEmail(String email) {
        if (Strings.isNullOrEmpty(email)) {
            return false;
        }

        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }


    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点
     *
     * @param text 字符串
     */
    public static boolean isChinese(String text) {
        if (Strings.isNullOrEmpty(text)) {
            return false;
        }

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(text);
        return m.find();
    }


    /**
     * 判断是否为正整数
     *
     * @param number 数字
     */
    public static boolean isNumber(String number) {
        if (Strings.isNullOrEmpty(number)) {
            return false;
        }

        String regex = "[0-9]*";
        return number.matches(regex);
    }


    /**
     * 判断几位小数(正数，decimal 数字，count   小数位数)
     *
     * @param decimal 数字
     * @param count   小数位数
     */
    public static boolean isDecimal(String decimal, int count) {
        if (Strings.isNullOrEmpty(decimal)) {
            return false;
        }

        String regex = "^(-)?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){" + count
                + "})?$";
        return decimal.matches(regex);
    }


    /**
     * 判断是否是移动手机号码
     *
     * @param phoneNumber 移动手机号码
     */
    public static boolean isMobilePhoneNumber(String phoneNumber) {
        if (Strings.isNullOrEmpty(phoneNumber)) {
            return false;
        }

        String regex = "^((13[0-9])|(15[0-9])|(18[1-9]))\\d{8}$";
        return phoneNumber.matches(regex);
    }


    /**
     * 判断是否是手机号码
     *
     * @param phoneNumber 移动手机号码
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        if (Strings.isNullOrEmpty(phoneNumber)) {
            return false;
        }

        String regex = "^1\\d{10}$";
        return phoneNumber.matches(regex);
    }


    /**
     * 判断是否含有特殊字符（true表示不包含）
     *
     * @param text 文本
     */
    public static boolean hasSpecialChar(String text) {
        if (Strings.isNullOrEmpty(text)) {
            return false;
        }

        if (text.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            // 不包含特殊字符
            return true;
        }
        return false;
    }


    /**
     * 验证身份证号码
     *
     * @param idCard 居民身份证号码 15位或18位，最后一位可能是数字或字母
     */
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex, idCard);
    }


    /**
     * 验证整数（正整数和负整数）
     *
     * @param digit 一位或多位0-9之间的整数
     */
    public static boolean checkDigit(String digit) {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex, digit);
    }


    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     *
     * @param decimals 一位或多位0-9之间的浮点数
     */
    public static boolean checkDecimals(String decimals) {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex, decimals);
    }


    /**
     * 验证空白字符
     *
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
     */
    public static boolean checkBlankSpace(String blankSpace) {
        String regex = "\\s+";
        return Pattern.matches(regex, blankSpace);
    }


    /**
     * 验证中文
     *
     * @param chinese 中文字符
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex, chinese);
    }


    /**
     * 验证日期（年月日 格式：yyyy-MM-dd yyyy/MM/dd）
     *
     * @param birthday 日期，格式：1992-09-03，或1992.09.03
     */
    public static boolean checkDate(String birthday) {
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
        return Pattern.matches(regex, birthday);
    }


    /**
     * 验证URL地址
     *
     * @param url 格式：
     */
    public static boolean checkURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }


    /**
     * 匹配中国邮政编码
     *
     * @param postcode 邮政编码
     */
    public static boolean checkPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }


    public static void main(String[] args) {
    }
}
