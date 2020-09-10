# IDEA-Vincent-Spring
Spring框架学习

## 【印象笔记】-【BlackHorse】java进阶教程4天精通Spring框架开发

### BlackHorse-Spring-01-IOC

① 创建web项目

② 导核心jar：beans + core + context + expression + （日志输出jar：logging + log4j）
（必须在WEB-INF下面创建lib存放jar，并添加为dependencies路径，项目下建lib则Tomcat-webapp启动找不到依赖！！！！！项目能找到依赖）
（也可以像JUnit4一样，添加为整个项目的External Libraries）
（spring-beans-4.2.4.RELEASE、spring-core-4.2.4.RELEASE、spring-context-4.2.4.RELEASE、spring-expression-4.2.4.RELEASE、commons-logging-1.2、log4j-1.2.16）
如果想通过[注解]，还需要[spring-aop-4.2.4.RELEASE.jar]

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

⑦ 属性注入/DI，基于IOC
1、利用[setter]注入（Spring支持）
简单注入
cn.itcast.property.PropertyDemo2
cn.itcast.ioc.TestIOC.testProperty2()
对象注入-@Resource/@Autowired
cn.itcast.property.ref.UserDao
cn.itcast.property.ref.UserService
cn.itcast.ioc.TestIOC.testPropertyRef()
p名称空间-其实就是该p名称空间直接就有对象里面的属性名
多类型属性注入-比如list
cn.itcast.property.PropertyDemo3
cn.itcast.ioc.TestIOC.testPropertyP()
2、利用[constructor]注入（Spring支持）
cn.itcast.property.PropertyDemo1
cn.itcast.ioc.TestIOC.testProperty1()
3、利用[interface]注入（Spring不支持，少见，其实就是把setter搞成接口）

⑧ @Test中手动加载Bean1.xml自然是很蠢，要学习Tomcat启动自动加载
1、Tomcat启动时，为每个项目创建一个[ServletContext对象]
2、[ServletContextListener]监听器，可以监测到ServletContext对象的创建
3、在ServletContext对象创建时，加载Bean1.xml，便会把创建的Bean放入（setAttribute）到ServletContext域
Spring已经封装了此操作，在web.xml中配置Spring监听器，前提是引入[spring-web-4.2.4.RELEASE.jar]

### BlackHorse-Spring-01-IOC-Annotation

① 创建web项目

② 导核心jar：beans + core + context + expression + （日志输出jar：logging + log4j）
为使用[注解]，还需要[spring-aop-4.2.4.RELEASE.jar]

③ 创建cn.itcast.anno.User

④ 配置文件Bean1.xml
1、在以上bean.xsd约束的基础上，添加[context.xsd]约束
2、开启注解扫描

⑤ cn.itcast.anno.User上添加注解
（四大注解之一）
@自带的4个注解：
@Component
@Controller WEB层
@Service    业务层 
@Repository 持久层
测试：cn.itcast.test.TestAnno.testUser()

⑥ cn.itcast.anno.UserDao注入到cn.itcast.anno.UserService
测试：cn.itcast.test.TestAnno.testUserAutoWired()

⑦ 注解 + XML 一起创建对象
cn.itcast.xmlanno.BookDao
cn.itcast.xmlanno.BookService
cn.itcast.xmlanno.OrdersDao
创建Bean2.xml
测试：cn.itcast.test.TestAnno.testXmlAnno()

### BlackHorse-Spring-02-AOP

抛弃继承[纵向抽取]，采用代理[横向抽取]机制，Spring借助[aspectj]框架
JDK代理：（处理有接口的情况）代理Impl实现类；
cglib代理：（处理无接口的情况）创建&代理对象的子类，在子类里面super.method()前后进行加强

导核心jar：beans + core + context + expression + （日志输出jar：logging + log4j）
还需要[spring-aop-4.2.4.RELEASE.jar] + [spring-aspects-4.2.4.RELEASE.jar] + [aopalliance-1.0.jar + ] + [aspectjweaver-1.8.9.jar]

① 创建对象，其中所有方法都是[Joinpoint]连接点，我们只加强其中一个方法/[Pointcut]切入点
cn.itcast.aop.Book

② 创建[Advice]通知/增强：前置、后置、异常、最终、环绕 5种通知
cn.itcast.aop.MyBook

③ 做[Aspect]切面：②应用到①
创建Bean3.xml（在以上bean.xsd约束的基础上，添加[aop.xsd]约束，如果使用AOP注解则同样需要添加[context.xsd]约束）

④ [Introduction]引介：给对象动态加属性...略

⑤ [Target]目标：Book...

⑥ [Weaving]织入：②应用到⑤...

⑦ [Proxy]代理：最终生成的代理类...

### Spring-CXF

① 创建web项目
lib下面添加jar依赖：
[commons-logging-1.2] + [log4j-1.2.16] + [slf4j-api-1.7.26],
[aop] + [apects] + [beans] + [context] + [core] + [expression] + [web],
[cxf-core-3.3.1],
[cxf-rt-bindings-soap-3.3.1],
[cxf-rt-databinding-jaxb-3.3.1],
[cxf-rt-frontend-jaxws-3.3.1],
[cxf-rt-frontend-simple-3.3.1],
[cxf-rt-transports-http-3.3.1],
[cxf-rt-transports-udp-3.3.1],
[cxf-rt-ws-addr-3.3.1],
[cxf-rt-wsdl-3.3.1],
[stax2-api-3.1.4] + [woodstox-core-asl-4.4.1], -- 兼容soupUI的不安全请求
[wsdl4j-1.6.3] + [xmlschema-core-2.2.4],
[neethi-3.1.1]作用未知

② 创建cxf-webservice接口
cn.cxf.sayhello.HelloService
cn.cxf.sayhello.HelloServiceImpl

③ 创建配置文件：spring-cxf.xml, Bean3.xml

④ 配置web.xml
1、将Bean3添加到web.xml随Tomcat启动加载（前提是引入spring-web.jar）
2、添加servlet单独单独处理cxf请求

⑤ 启动、测试：
http://localhost:8080/CXF/service -- 可以看到Service List
http://localhost:8080/CXF/service/hello?wsdl -- 可用于SoupUI单独测试
报错：Cannot create a secure XMLInputFactory（新版Tomcat导致？）
需要依赖[woodstox-core-asl-4.4.1.jar] + [stax2-api-3.1.4.jar]来兼容不安全的请求

### springboot-xxlsso-server
xxl-sso是一款基于redis轻量级分布式高可用的SSO实现组件(集成起来超级方便)
支持web端(Cookie实现)和app端(Token实现)两种方式，两种方式的验证都是用Filter实现的