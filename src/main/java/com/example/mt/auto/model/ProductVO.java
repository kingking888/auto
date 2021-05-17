package com.example.mt.auto.model;

import lombok.Data;

/**
 * 商品對象类
 */
@Data
public class ProductVO {
       /* "name": "鲜铁皮石斛粉（礼品装）",
            "price": 1980.00,
            "costPrice": 0.00,
            "status": "0",
            "productIcon": "https://gzwcdn.gzlex.com/group6/M00/01/06/CgEyJmA_MYSALbLIAAZqFck_PlU655_small.jpg",
            "unitName": "1.5g*24支/盒",
            "brand": 221,
            "erpCode": "6927145500032"*/
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private String price;
    private String costPrice;
    private Integer status;
    /**
     * 产品图片
     */
    private String productIcon;
    private String unitName;

    private String brand;
    /**
     * ERP编码
     */
    private String erpCode;
}
