package cn.itcast.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	//对象作为属性，注入到另一个对象
	//01-IOC配置通过【有参构造】、【setter方式/即等效于本方法】
//	@Autowired
	@Resource(name="userDao")
	private UserDao userDao1;
//	private UserDao userDao = new UserDao();
	public void add(){
		userDao1.add();
		System.out.println("service```````");
	}
}
