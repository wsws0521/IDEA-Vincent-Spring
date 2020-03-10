package cn.hexing.encryption.restful;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class RestConfig {
    @Bean
    public ServletRegistrationBean<DispatcherServlet> restDispatcherServlet(){
        AnnotationConfigWebApplicationContext acac = new AnnotationConfigWebApplicationContext();
        acac.scan("cn.hexing.encryption.restful.*");
        DispatcherServlet restDispatcherServlet = new DispatcherServlet(acac);
        ServletRegistrationBean<DispatcherServlet> registrationBean = new ServletRegistrationBean<>(restDispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/rest/*");
        return registrationBean;
    }
}
