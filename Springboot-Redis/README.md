## 0 启动redis（master就够了）
## 1 添加依赖
* spring-boot-starter-data-redis
* commons-pool2
* fastjson

## 2 配置application.yml
* redis.host（redis服务配置里面bind本机IP，这里写localhost，写127.0.0.1都会报连不上）
* redis.port（master的端口，而不是sentinel的）

## 3 完活儿，直接测试【TestRedis.class】
@Test要放在主类目录下，否则需要加载上下文@SpringConfiguration
```
cli命令：
>redis-cli -h 192.168.87.106
192.168.87.106>keys *       # 查看所有key
192.168.87.106>get aaa      # 获取key=aaa的value值
192.168.87.106>config set requirepass “你的密码”        # 设置密码
192.168.87.106>auth “你的密码”                          # 验证密码
```

## 改进【RedisTemplateService.class】【User.class】【TestRedis.class】
redis有一个问题，就是在存对象的时候，会序列化成2进制文件。
但是我们需要的是存的json格式的文件，这样方便我们测试，调试。
借助阿里的fastJson，将对象转换成Json串存储进redis


