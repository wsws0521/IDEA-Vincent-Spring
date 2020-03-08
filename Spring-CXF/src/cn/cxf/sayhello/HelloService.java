package cn.cxf.sayhello;

import javax.jws.WebService;

@WebService
public interface HelloService {
    String sayHello(String name);
}
