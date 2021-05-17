package com.example.mt.auto.model;

import lombok.Data;

/**
 * 用户对象类
 */
@Data
public class AccountVO {
    /**
     * 1、地址：addressId:258871（我的深圳地址），374243(我的贵州地址)，552319（ba深圳地址），601703（ba的贵州地址）     *
     * 2、账号：fundAccount:500103909(18988768578)，500215483（ba的手机）
     * 3、设备：appkey:gl_android_e028d74(安卓手机)
     * 4、UID:20641773(我的)，20883363（ba的）
     *
     * "&addressId=552319&appkey=gl_android_e028d74&branchNo=0" +
     *             "&client=android&deviceId=8d484757-917e-3175-991b-4af6ce248d75&encrypt=1" +
     *             "&erpCode=6973839490059&fundAccount=500215483&orderType=11" +
     *             "&timestamp="+ tick +
     *             "&token=YfbNbnjX3n-JLbLgozKWhw%3D%3D&uid=20883363&version=2.1.1&wineType=0"
     */
    private String addressId;
    private String fundAccount;
    private String appkey;
    private String branchNo;
    private String client;
    private String deviceId;
    private String uid;
    private String encrypt;
    private String erpCode;
    private String orderType;
    private String timestamp;
    private String token;
    private String version;
    private String wineType;
}
