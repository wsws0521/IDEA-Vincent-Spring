package cn.vincent.sb.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Component
public class MySendMailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${wmy.mail}")
    private String[] wmyMail;

    public void sendMail(String subject, String msg){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(from);
            helper.setTo(wmyMail);
            helper.setSubject(subject);
            helper.setText(msg);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String getOneS(){
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet("https://chp.shadiao.app/api.php");
            HttpResponse response = httpClient.execute(get);
            HttpEntity httpEntity = response.getEntity();
            String responseString = EntityUtils.toString(httpEntity, "utf-8");
            return responseString;
        } catch (IOException e) {
            throw new RuntimeException("网站获取彩虹屁失败");
        }
    }
}
