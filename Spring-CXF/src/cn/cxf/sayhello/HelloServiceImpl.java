package cn.cxf.sayhello;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "大家好，我是：" + name;
    }
}
