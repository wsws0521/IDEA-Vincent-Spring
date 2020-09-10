package cn.vincent.springbootnetty.client;

import lombok.AccessLevel;
import lombok.Data; // IDEA 需要安装插件支持
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
//@Getter(value = AccessLevel.PUBLIC)
//@Setter(value = AccessLevel.PUBLIC)
public class RpcInfo implements Serializable {
    /**
     * 调用服务的接口名
     */
    private String className;
    /**
     * 调用服务的方法名
     */
    private String methodName;
    /**
     * 调用方法的参数列表类型
     */
    private Class[] paramTypes;
    /**
     * 调用服务传参
     */
    private Object[] params;
}
