package com.example.sportApp.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class MD5 {

    // 日志处理
    private static final Logger logger = LoggerFactory.getLogger(MD5.class);

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 获取MD5加密串
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        if (str==null || str.trim().length()==0) {
            return null;
        }
        try{
            return getMD5(str.getBytes("UTF-8"));
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * @see ：一个字节数组 传出参数：字节数组的MD5结果字符串
     * @author lyz
     * @param bytesSrc
     * @return
     */
    public static String getMD5(byte[] bytesSrc) {
        String result = "";
        // 用来将字节转换成16进制表示的字符
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytesSrc);
            // MD5的计算结果是一个128 位的长整数，字节表示是16个字节
            byte tmp[] = md.digest();
            // 每个字节用16进制表示，使用两个字符，表示成16进制需要32个字符
            char str[] = new char[16 * 2];
            // 表示转换结果中对应的字符位置
            int k = 0;
            // 从第一个字节开始，对 MD5 的每一个字节
            for (int i = 0; i < 16; i++) {
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第i个字节
                // 取字节中高 4 位的数字转换，>>> 为逻辑右移，将符号位一起右移
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                // 取字节中低 4 位的数字转换
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            // 换后的结果转换为字符串
            result = new String(str);
        } catch (Exception e) {
            logger.info("Exception: ", e);
        }
        return result;
    }

    /**
     * 获取md5加密后的字节数组
     *
     * @param src
     * @return
     */
    public static byte[] getMD5Bytes(byte[] src) {
        String resultString = null;
        byte[] dst = new byte[16];

        try {
            resultString = new String(src);
            MessageDigest md = MessageDigest.getInstance("MD5");
            dst = md.digest(resultString.getBytes());
        } catch (Exception ex) {
            return null;
        }

        return dst;
    }

}

