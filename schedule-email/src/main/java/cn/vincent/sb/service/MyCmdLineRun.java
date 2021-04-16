package cn.vincent.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动直接跑，借助Windows的【计划任务】实现定时效果
 */
@Component
@Order(value = 1)
public class MyCmdLineRun implements CommandLineRunner {
    @Autowired
    MySendMailService mySendMailService;
    @Override
    public void run(String... args) throws Exception {
        String msg = mySendMailService.getOneS();
        System.out.println(msg);
        mySendMailService.sendMail("帅帅爱小七", msg);
    }
}
