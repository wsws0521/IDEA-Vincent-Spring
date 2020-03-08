package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.anno.User;
import cn.itcast.anno.UserService;
import cn.itcast.xmlanno.BookService;

public class TestAnno {
	@SuppressWarnings("resource")
	@Test
	public void testUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void testUserAutoWired(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		UserService userService = (UserService) context.getBean("userService");
		System.out.println(userService);
		userService.add();
	}
	
	//【配置文件】与【注解】混合使用
	@SuppressWarnings("resource")
	@Test
	public void testXmlAnno(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		System.out.println(bookService);
		bookService.add();
	}

}
