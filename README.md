# IDEA-Vincent-Spring
Spring框架学习

## 【印象笔记】-【BlackHorse】java进阶教程4天精通Spring框架开发

### BlackHorse-Spring-01-IOC

① 创建web项目

② 导核心jar：beans + core + context + expression + （日志输出jar：logging + log4j）
（与Eclipse保持一致，WEB-INF下面创建lib存放jar，并添加为dependencies路径）
（也可以像JUnit4一样，添加为整个项目的External Libraries）
（spring-beans-4.2.4.RELEASE、spring-core-4.2.4.RELEASE、spring-context-4.2.4.RELEASE、spring-expression-4.2.4.RELEASE、commons-logging-1.2、log4j-1.2.16）

③ 创建cn.itcast.ioc.User.class

④ 配置文件
1、名称位置灵活，不过建议：src/applicationContext.xml
2、引入scheme约束：从如下文件中复制>>spring-framework-4.2.4.RELEASE/docs/spring-framework-reference/html>>最后一个最后一行...
无外网时，scheme约束中指向外网xsd地址采用可以指定离线xsd文件：
（eclipse）首选项>>XML>>XML Catalog>>Add>>Catalog Entry.Key填写网络URL|Catalog Entry.Location指定离线xsd文件路径|Catalog Entry.Key type选择Schema Location
（IDEA）报 'URI is not registered' ----Alt+Enter---Fetch external.. 相当于 Settings>>Languages & Frameworks>>Schemas & DTDs>>Add 网络路径&下载到本地文件的对应关系
3、配置User.Bean

⑤ 测试（手动加载Bean1）
cn.itcast.ioc.TestIOC.testUser()

⑥ 如何创建Bean？
1、通过[无参构造]创建Bean：
如上
2、通过[static工厂]创建：
cn.itcast.ioc.User2
cn.itcast.ioc.User2Factory
cn.itcast.ioc.TestIOC.testUser2()
3、通过[实例工厂]创建：
cn.itcast.ioc.User3
cn.itcast.ioc.User3Factory
cn.itcast.ioc.TestIOC.testUser3()

⑦ 属性注入
1、利用[setter]注入（Spring支持）
简单注入
cn.itcast.property.PropertyDemo2
cn.itcast.ioc.TestIOC.testProperty2()
对象注入-@Resource/@Autowired
cn.itcast.property.ref.UserDao
cn.itcast.property.ref.UserService
cn.itcast.ioc.TestIOC.testPropertyRef()
多类型注入-p名称空间
cn.itcast.property.PropertyDemo3
cn.itcast.ioc.TestIOC.testPropertyP()
2、利用[constructor]注入（Spring支持）
cn.itcast.property.PropertyDemo1
cn.itcast.ioc.TestIOC.testProperty1()
3、利用[interface]注入（Spring不支持，少见，其实就是把setter搞成接口）