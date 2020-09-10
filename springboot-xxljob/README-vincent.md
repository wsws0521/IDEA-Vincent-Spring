# 我眼中的 xxl-job
## 1-core
* pom
-[x] 集成服务 【netty】、【gson】
-[x] 集成插件 【groovy】、【context】
-[x] 集成工具 【slf4j】、【junit】、【annotation-api】
* core.enums
* core.biz.model.*
* core.util(log(biz-model))
* core.log(core.uti.DateUtil)
--------
* core.context
--------
* core.server(biz、util、thread)
* core.glue(handler、executor)
* core.handler(log、biz-model、Handler、glue、log、util)
* core.thread(biz、executor、log、handler、context)
* core.executor(biz、handler、log、server、thread、util)
* core.biz
## 2-admin
* pom
-[x] 启动依赖 【starter】、【starter-test】
-[x] 前端工具 【starter-freemarker】
-[x] 邮箱工具 【starter-mail】
-[x] 监控工具 【starter-actuator】
-[x] mysql 【mybatis】【mysql-connector】
-[x] mysql 【mybatis】【mysql-connector】

### 启动Admin
1-跑下基础脚本：/xxl-job/doc/db/tables_xxl_job.sql
2-配置：/xxl-job/xxl-job-admin/src/main/resources/application.properties
3-访问：http://localhost:8080/xxl-job-admin
> admin/123456

### 启动执行器（推荐Springboot示例）
启动后会自动注册到Admin的执行器列表，自动检测IP
最终是Admin去调执行器里的Bean定时执行任务

