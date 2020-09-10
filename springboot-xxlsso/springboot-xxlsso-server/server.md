## 1-编写配置类：config
## 2-编写核心类：core
model/UserInfo.java
result/ReturnT.java
## 3-编写服务类：service
## 4-编写控制器：controller

## 编写前端



---

## 1-开启redis

## 2-配置redis地址
xxl.sso.redis.address: 本地安装的redis单机默认配置信息
> 还可以通过逗号分隔进行集群,
目前这组件只支持分片集群ShardedJedisPool,
组件后续会支持JedisCluster,
注意redis://{username}:{password}@{ip}:{port}/{db}这种需要密码的配置方式,
密码一定不要带#,!,@,$等特殊符号,ShardedJedisPool初始化链接时会报解析错误。

