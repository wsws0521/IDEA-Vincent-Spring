package cn.vincent.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 既然用Windows的【任务计划】，就不用schedule了
 */
@Component
public class MyScheduled {
//    @Autowired
//    MySendMailService mySendMailService;
//
//    /**
//     * 每周五晚上20:05
//     */
//    @Scheduled(cron = "0 05 20 ? * FRI")
//    public void dsrw(){
//        String msg = mySendMailService.getOneS();
//        mySendMailService.sendMail("帅帅爱小七", msg);
//    }
}
