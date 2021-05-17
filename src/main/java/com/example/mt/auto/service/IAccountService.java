package com.example.mt.auto.service;

import com.example.mt.auto.model.AccountVO;

import java.util.List;

/**
 * 账号服务接口类
 */
public interface IAccountService {

    public void accountLogin();

    /**
     * 获取两个用户信息
     * @return
     */
    public List<AccountVO> getTwoAccount();

    /**
     * 区域限制检查
     * @param vo 对象vo
     * @param index 序号
     */
    public void checkRestrictedArea(AccountVO vo,int index);
}
