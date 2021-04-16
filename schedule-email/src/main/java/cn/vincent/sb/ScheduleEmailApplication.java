package cn.vincent.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScheduleEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduleEmailApplication.class);
    }
}
