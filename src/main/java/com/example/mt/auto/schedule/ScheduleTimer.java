package com.example.mt.auto.schedule;

import com.example.mt.auto.model.AccountVO;
import com.example.mt.auto.service.IAccountService;
import com.example.mt.auto.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@EnableScheduling
public class ScheduleTimer {

    @Autowired
    private IAccountService accountService;

    // "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
    // "55 29 9 ? * *" 每天上午9:29 55秒 触发
    // "55 59 10 ? * *" 每天上午10:59:55触发
    // "55 29 14 ? * *" 每天下午2:29:55触发
    // "0/5 * * * * ?" 每5秒钟执行一次

//    @Scheduled(cron = "55 0/1 16 * * ?")
//    public void fetchData() {
//        System.out.println(DateUtil.getDateToString(System.currentTimeMillis())+"____aaaaaaaaaa");
//    }


    @Scheduled(cron = "0/10 * * * * ?")
    public void fetchData2() {
        accountService.accountLogin();
//        List<AccountVO> list = accountService.getTwoAccount();
//        if (list.size() > 0) {
//            accountService.checkRestrictedArea(list.get(0),0);
//        }
        System.out.println(DateUtil.getDateToString(System.currentTimeMillis())+"_____");
    }

}