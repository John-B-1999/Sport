package com.example.sportApp.utils.common;

/**
 * 支付串工具
 * @author eiei
 * @since 2015年12月8日15:26:55
 */
public class XStringUtils {

    /**
     * 判断参数支付串中是否存在空
     * @param ss
     * @return
     */
    public static boolean isExistEmpty(String... ss){
        if(ss == null || ss.length == 0){
            return true;
        }
        for(String s:ss){
            if(s==null || s.trim().length() == 0){
                return true;
            }
        }
        return false;
    }
}
