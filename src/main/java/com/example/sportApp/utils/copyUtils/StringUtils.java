package com.example.sportApp.utils.copyUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 * 字符串工具类
 */
public class StringUtils {


    /**
     * 首字母转换为小写
     *
     * @param str 字符串
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += 32;
            return new String(arr);
        }
        return str;
    }


    /**
     * 首字母转换为大写
     *
     * @param str 字符串
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= 32;
            return new String(arr);
        }
        return str;
    }


    /**
     * 检查子符串出现过几次
     *
     * @param str    源字符串
     * @param subStr 子字符串
     */
    public static int timesOf(String str, String subStr) {
        int foundCount = 0;
        if (subStr.equals("")) {
            return 0;
        }
        int fromIndex = str.indexOf(subStr);
        while (fromIndex != -1) {
            ++foundCount;
            fromIndex = str.indexOf(subStr, fromIndex + subStr.length());
        }
        return foundCount;
    }


    /**
     * 是否可转化为数字
     *
     * @param o 对象
     */
    public static boolean isNum(Object o) {
        try {
            new BigDecimal(o.toString());
            return true;
        } catch (Exception e) {
        }
        return false;
    }


    /**
     * 是否可转化为Long型数字
     *
     * @param o 对象
     */
    public static boolean isLong(Object o) {
        try {
            new Long(o.toString());
            return true;
        } catch (Exception e) {
        }
        return false;
    }


    /**
     * String转换为Integer
     *
     * @param str 字符串
     */
    public static Integer stringToInt(String str) {
        return Integer.parseInt(str);
    }


    /**
     * String转换为Double
     *
     * @param str 字符串
     */
    public static Double stringToDouble(String str) {
        return Double.parseDouble(str);
    }


    /**
     * String转换为Float
     *
     * @param str 字符串
     */
    public static Float stringToFloat(String str) {
        return Float.parseFloat(str);
    }


    /**
     * String转换为Long
     *
     * @param str 字符串
     */
    public static Long stringToLong(String str) {
        return Long.parseLong(str);
    }


    /**
     * 切割字符串转化为List<String>
     *
     * @param str       字符串
     * @param character 字符
     */
    public static List<String> splitString(String str, String character) {
        String[] split = str.split(character);
        return Arrays.asList(split);
    }

    /**
     * 判断字符串不为空
     * 非空返回true
     *
     * @param str 字符串
     */
    public static boolean notEmpty(final String str) {
        return (str != null) && (str.length() > 0);
    }

    /**
     * 判断字符串为空
     * 为空返回true
     *
     * @param str 字符串
     */
    public static boolean isEmpty(final String str) {
        return (str == null) || (str.length() == 0);
    }

    public static void main(String[] args) {
    }
}
