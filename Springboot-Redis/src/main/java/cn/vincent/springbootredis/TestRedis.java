package cn.vincent.springbootredis;

import cn.vincent.springbootredis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplateService redisTemplateService;
    @Test
    public void set(){
        redisTemplate.opsForValue().set("test:set", "testValue1");
        stringRedisTemplate.opsForValue().set("aaa", "bbb");
    }
    @Test
    public void storeJson(){
        User user = new User();
        user.setId(123);
        user.setUsername("vincent");
        user.setPassworld("0521wsws");
        redisTemplateService.set("user1", user);

        User uu = redisTemplateService.get("user1", User.class);
        System.out.println(uu.getUsername() + "/" + uu.getPassworld());
    }
}
