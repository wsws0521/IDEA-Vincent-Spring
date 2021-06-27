package cn.vincent.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 如果希望能够在其他项目中使用的时候，
 * 通过yml或property文件对这个属性   进行赋值，
 * 就要写一个对属性进行赋值操作的类，
 * 并使用@ConfigurationProperties注解
 */
@ConfigurationProperties("spring.sayhi")
public class A0MyProperties {
    private String name = "";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
