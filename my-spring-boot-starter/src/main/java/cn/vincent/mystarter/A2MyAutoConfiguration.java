package cn.vincent.mystarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 如果希望上面开发的功能在springboot启动的时候就加入项目进行管理，就需要有一个代表当前starer自动装配的类
 */
@Configuration
@ConditionalOnClass
//使配置文件生效
@EnableConfigurationProperties(A0MyProperties.class)
public class A2MyAutoConfiguration {
    @Bean
    //条件注解，仅当ioc容器中不存在指定类型的bean时，才会创建bean
    @ConditionalOnMissingBean
    public A1ISayhi sayhi(){
        return new A1SayhiImplA1();
    }
}
