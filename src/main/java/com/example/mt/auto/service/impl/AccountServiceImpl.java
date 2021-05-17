package com.example.mt.auto.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.mt.auto.model.AccountVO;
import com.example.mt.auto.request.HttpRequest;
import com.example.mt.auto.request.RequestUtil;
import com.example.mt.auto.service.IAccountService;
import com.example.mt.auto.util.DateUtil;
import com.example.mt.auto.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 账号服务接口类
 */
@Service
public class AccountServiceImpl implements IAccountService {

    public static void main(String[] args) {
        accountLogin2();
    }
    @Override
    public void accountLogin() {

    }

    public static void accountLogin2() {
        String pwd = "123456asdfG";
        String uinfo = "18988768578";
        // 获取时间戳（注：13位）
        String tick = String.valueOf(System.currentTimeMillis());
        String url = "https://guilvp.gzlex.com/login/V2.decryption";
        String param = "_s_q__=aaa&appkey=gl_android_e028d74&client=android&deviceId=8d484757-917e-3175-991b-4af6ce248d75" +
                "&encrypt=1&password=" + pwd +
                "&timestamp=" + tick +
                "&uinfo=" + uinfo +
                "&version=2.1.1";
        // 获取加密值
        String postSignCode = MD5.getSignCode(param);
        // 将加密值拼接到请求参数中
        param = param + "&signcode=" + postSignCode;
        System.out.println(param);
        String result = HttpRequest.sendPost("https://guilvp.gzlex.com/api/transaction/purchase/checkRestrictedArea", param);
        System.out.println(result);
        // _s_q__=aaa&appkey=gl_android_e028d74&client=android&deviceId=8d484757-917e-3175-991b-4af6ce248d75
        // &encrypt=1&password=123456asdfG&timestamp=1618885177083&uinfo=18988768578&version=2.1.0&signcode=538da9b767127480c970b6579c3a802e
    }

    @Override
    public List<AccountVO> getTwoAccount(){
        String appkey = "gl_android_e028d74";
        String branchNo = "0";
        String client = "android";
        String deviceId = "8d484757-917e-3175-991b-4af6ce248d75";
        String encrypt = "1";
        String erpCode = "6973839490059";
        String version = "2.1.1";
        String wineType = "0";

        AccountVO accountMy = new AccountVO();
        accountMy.setAddressId("374243");
        accountMy.setFundAccount("500103909");
        accountMy.setUid("20641773");
        accountMy.setErpCode("6973839490011");
        accountMy.setToken("SVU2-rOOYgSJLbLgozKWhw%3D%3D");
        accountMy.setDeviceId(deviceId);
        accountMy.setAppkey(appkey);

        AccountVO accountBa = new AccountVO();
        accountBa.setAddressId("601703");
        accountBa.setFundAccount("500215483");
        accountBa.setUid("20883363");
        accountBa.setErpCode("6973839490059");
        accountBa.setToken("YfbNbnjX3n-JLbLgozKWhw%3D%3D");
        accountBa.setDeviceId(deviceId);
        accountBa.setAppkey(appkey);

        List<AccountVO> list = new ArrayList<>();
        list.add(accountMy);
        list.add(accountBa);
        return list;
    }

    /**
     * 区域限制检查
     * @param vo 对象vo
     * @param index 序号
     */
    @Override
    public void checkRestrictedArea(AccountVO vo,int index) {
        // 获取系统当前时间戳  注：tick为13位
        String tick = String.valueOf(System.currentTimeMillis());
        String sq = RequestUtil.getSq();
        String erpCode = vo.getErpCode();
        String fundAccount = vo.getFundAccount();
        String token = vo.getToken();
        String uid = vo.getUid();
        String appkey = vo.getAppkey();
        String addressid = vo.getAddressId();
        String deviceid = vo.getDeviceId();

        String sr = "";
        String resultCode = "";
        JSONObject object = JSONObject.parseObject(sr);
        // 循环验证2000次
        for (int i = 0; i <= 1; i++) {
            if (!StringUtils.isEmpty(resultCode)) {
                resultCode = object.getJSONObject("message").getString("code");
            }
            if ("-1".equals(resultCode) || StringUtils.isEmpty(resultCode)) {
                String postParam2 = "_s_q__=" + RequestUtil.getSq() + "&addressId=" + addressid +
                        "&appkey=" + appkey +
                        "&branchNo=0" +
                        "&client=android&deviceId=" + deviceid +
                        "&encrypt=1" +
                        "&erpCode=" + erpCode +
                        "&fundAccount=" + fundAccount +
                        "&orderType=11" +
                        "&timestamp=" + tick +
                        "&token=" + token +
                        "&uid=" + uid +
                        "&version=2.1.1&wineType=0";

                // 获取加密值
                String postSignCode2 = MD5.getSignCode(postParam2);
                // 将加密值拼接到请求参数中
                postParam2 = postParam2 + "&signcode=" + postSignCode2;
                //发送 POST 请求
                sr = HttpRequest.sendPost("https://guilvp.gzlex.com/api/transaction/purchase/checkRestrictedArea", postParam2);

                System.out.println("erpCode=" + erpCode + "__i=" + i + "__index=" + index + "____" + DateUtil.getDateToString(System.currentTimeMillis()) + "__" + sr);
                /*
                String resultMessage = object.getJSONObject("message").getString("message");
                if(!StringUtil.isBlank(resultMessage) && "商品库存不足！".equals(resultMessage)) {
                    break;
                }
                */
            }
        }

    }
}
