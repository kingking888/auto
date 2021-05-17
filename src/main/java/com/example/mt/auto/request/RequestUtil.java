package com.example.mt.auto.request;

/**
 * 请求工具类
 */
public class RequestUtil {

    private static String randomA="aaa";
    private static String randomB="bbb";

    public static String getSq(){
        int randomNumber = (int)(1+Math.random()*(2-1+1));
        if (randomNumber == 1) {
            return randomA;
        } else {
            return randomB;
        }
    }
}
