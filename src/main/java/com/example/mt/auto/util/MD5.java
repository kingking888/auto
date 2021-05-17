package com.example.mt.auto.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */
public class MD5 {

    public static String getSignCode(String str) {
        str = ("e13067a611055bade7b3fb0beff0384d" + str.replace("&", "").replace("=", "").replace("%3D", "=") + "e13067a611055bade7b3fb0beff0384d").toUpperCase();
        return md5(str);
    }

    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("no md5 algorithm");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}