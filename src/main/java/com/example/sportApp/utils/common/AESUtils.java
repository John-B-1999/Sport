package com.example.sportApp.utils.common;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES 对称算法加密/解密工具类
 *
 * @author xietansheng
 */
public class AESUtils {

    /** 密钥长度: 128, 192 or 256 */
    private static final int KEY_SIZE = 128;

    /** 加密/解密算法名称 */
    private static final String ALGORITHM = "AES";

    /** 随机数生成器（RNG）算法名称 */
    private static final String RNG_ALGORITHM = "SHA1PRNG";

    /**
     * 生成密钥对象
     */
    private static SecretKey generateKey(byte[] key) throws Exception {
        // 创建安全随机数生成器
        SecureRandom random = SecureRandom.getInstance(RNG_ALGORITHM);
        // 设置 密钥key的字节数组 作为安全随机数生成器的种子
        random.setSeed(key);

        // 创建 AES算法生成器
        KeyGenerator gen = KeyGenerator.getInstance(ALGORITHM);
        // 初始化算法生成器
        gen.init(KEY_SIZE, random);

        // 生成 AES密钥对象, 也可以直接创建密钥对象: return new SecretKeySpec(key, ALGORITHM);
        return gen.generateKey();
    }

    /**
     * 数据加密: 明文 -> 密文
     */
    public static byte[] encrypt(byte[] plainBytes, byte[] key) throws Exception {
        // 生成密钥对象
        SecretKey secKey = generateKey(key);

        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化密码器（加密模型）
        cipher.init(Cipher.ENCRYPT_MODE, secKey);

        // 加密数据, 返回密文
        byte[] cipherBytes = cipher.doFinal(plainBytes);

        return cipherBytes;
    }

    /**
     * 数据解密: 密文 -> 明文
     */
    public static byte[] decrypt(byte[] cipherBytes, byte[] key) throws Exception {
        // 生成密钥对象
        SecretKey secKey = generateKey(key);

        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, secKey);

        // 解密数据, 返回明文
        byte[] plainBytes = cipher.doFinal(cipherBytes);

        return plainBytes;
    }

    /**
     * 加密文件: 明文输入 -> 密文输出
     */
    public static void encryptFile(File plainIn, File cipherOut, byte[] key) throws Exception {
        aesFile(plainIn, cipherOut, key, true);
    }

    /**
     * 解密文件: 密文输入 -> 明文输出
     */
    public static void decryptFile(File cipherIn, File plainOut, byte[] key) throws Exception {
        aesFile(plainOut, cipherIn, key, false);
    }

    /**
     * AES 加密/解密文件
     */
    private static void aesFile(File plainFile, File cipherFile, byte[] key, boolean isEncrypt) throws Exception {
        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 生成密钥对象
        SecretKey secKey = generateKey(key);
        // 初始化密码器
        cipher.init(isEncrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, secKey);

        // 加密/解密数据
        InputStream in = null;
        OutputStream out = null;

        try {
            if (isEncrypt) {
                // 加密: 明文文件为输入, 密文文件为输出
                in = new FileInputStream(plainFile);
                out = new FileOutputStream(cipherFile);
            } else {
                // 解密: 密文文件为输入, 明文文件为输出
                in = new FileInputStream(cipherFile);
                out = new FileOutputStream(plainFile);
            }

            byte[] buf = new byte[1024];
            int len = -1;

            // 循环读取数据 加密/解密
            while ((len = in.read(buf)) != -1) {
                out.write(cipher.update(buf, 0, len));
            }
            out.write(cipher.doFinal());    // 最后需要收尾

            out.flush();

        } finally {
            close(in);
            close(out);
        }
    }

    private static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                // nothing
            }
        }
    }


    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password  加密密码
     * @return
     */
    public static byte[] encrypt2(String content, String password) {
        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**解密
     * 解密的时候要传入byte数组
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        String content = "test";
        String password = "key";
        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        String encryptResultStr = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom,password);
        System.out.println("解密后：" + new String(decryptResult));
    }
}