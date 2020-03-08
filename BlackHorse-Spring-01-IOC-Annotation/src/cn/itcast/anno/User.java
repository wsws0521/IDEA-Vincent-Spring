package cn.itcast.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//自带的4个注解：
//@Component
//@Controller      WEB层
//@Service           业务层 
//@Repository     持久层
//其实，功能是一样的，甚至可以混用，分开使用是Spring给自己留的后路，类似POST、GET、PUT··
@Component(value="user")	
@Scope(value="prototype")
public class User {
	public void add(){
		System.out.println("add`````````````````");
	}
}
