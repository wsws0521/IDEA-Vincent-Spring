package cn.vincent.springbootnetty.client.nettyClientScan;

import org.springframework.context.annotation.Import;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(NettyRpcClientRegistrar.class)
public @interface EnableNettyRpcClient {
    //扫描的包名，如果为空，则根据启动类所在的包名扫描
    String[] basePackages() default {};

    //扫描的字节码类型，可根据字节码类型获取对应的包路径
    Class<?>[] basePackageClasses() default {};
}
