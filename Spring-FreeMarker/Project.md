# 2.1.4的freemarker的版本一直unknown，还硬在m2下创建同名文件夹
bug？只能用2.2.0


## http://localhost:8080/hello/index
javax.servlet.ServletException: Circular view path [index]: would dispatch back to the current handler URL [/hello/index] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:210) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:148) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:317) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1373) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1118) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1057) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.2.0.RELEASE.jar:5.2.0.RELEASE]
[原因]
在页面渲染(render)之前，Spring会试图使用RequestDispatcher来继续转发该请求。如下代码：
`if (path.startsWith("/") ? uri.equals(path) : uri.equals(StringUtils.applyRelativePath(uri, path))) {
     throw new ServletException("Circular view path [" + path + "]: would dispatch back " +
                         "to the current handler URL [" + uri + "] again. Check your ViewResolver setup! " +
                         "(Hint: This may be the result of an unspecified view, due to default view name generation.)");
 }`
从这段代码可以看出，如果你的view name和你的path是相同的字符串，根据Spring的转发规则，就等于让自己转发给自己，会陷入死循环。所以Spring会检查到这种情况，于是抛出Circular view path异常。
boot中，使用thymeleaf，会加入starter依赖，引入这个依赖的时候了，boot会自动进行配置转发规则，所以只要记得在pom文件中声明依赖即可。
`<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
 </dependency>`
 spring中也会遇到这种情况的，原理同上，如果不声明viewResolver，就会出现这个问题的。我在controller中，不加@ResponseBody注解，直接返回"index"字符串，来映射
 index.jsp 就会进入上面的代码，判断uri 和 jsp 的name相同，都是index
