package cn.cxf.sayhello;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "��Һã����ǣ�" + name;
    }
}
