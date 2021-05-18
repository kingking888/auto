package com.example.mt.auto.schedule;

import com.example.mt.auto.model.AccountVO;
import com.example.mt.auto.service.IAccountService;
import com.example.mt.auto.util.DateUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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



    /**
     * 循环check账号 每十秒钟
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void fetchData() {
        accountService.accountLogin();
    }

    /**
     * 定时check,上午九点半,提前2秒
     */
    @Scheduled(cron = "58 29 9 ? * *")
    public void fetchData1() throws InterruptedException {
        this.init();
    }
    /**
     * 定时check,上午十一点,提前2秒
     */
    @Scheduled(cron = "58 59 10 ? * *")
    public void fetchData2() throws InterruptedException {
        this.init();
    }
    /**
     * 定时check,下午两点半,提前2秒
     */
    @Scheduled(cron = "58 29 14 ? * *")
    public void fetchData3() throws InterruptedException {
        this.init();
    }

    private void init() throws InterruptedException {
        List<AccountVO> list = accountService.getTwoAccount();
        for (int i=0;i<list.size();i++){
            // 创建多线程发送请求
            new Thread(""+i){
                @Override
                public void run(){
                    int index = Integer.parseInt(Thread.currentThread().getName());
                    accountService.checkRestrictedArea(list.get(index),index);
                }
            }.start();
        }
        System.out.println(DateUtil.getDateToString(System.currentTimeMillis())+"_____");
    }

}