package cn.vincent.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现自己的功能需求
 */
@Service
public class A1SayhiImplA1 implements A1ISayhi {
    @Autowired
    A0MyProperties properties;
    @Override
    public void welcome() {
        String name = properties.getName();
        System.out.println(name + " hello spring boot");
    }
}
