package cn.itcast.test;

import cn.itcast.aop.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import cn.itcast.aop.Book;

public class TestAnno {

	@SuppressWarnings("resource")
	@Test
	public void testAop(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		Book book = (Book) context.getBean("book");
		System.out.println(book);
		book.add();
	}
}
