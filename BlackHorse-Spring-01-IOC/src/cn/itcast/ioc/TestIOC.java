package cn.itcast.ioc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.property.PropertyDemo1;
import cn.itcast.property.PropertyDemo2;
import cn.itcast.property.PropertyDemo3;
import cn.itcast.property.ref.UserService;

public class TestIOC {
	/**
	 * �����޲ι��� ʵ��������
	 */
	@Test
	public void testUser(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
		//��ӡ�����ĵ�ַ��һ���ġ��ɴ˿ɼ���Ĭ��scopeΪsingleton
		User user2 = (User) context.getBean("user");
		System.out.println(user2);
	}
	/**
	 * ���þ�̬���� ʵ��������
	 */
	@Test
	public void testUser2(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		User2 user2 = (User2) context.getBean("user2");
		System.out.println(user2);
		user2.add();

	}
	/**
	 * ����ʵ������ ʵ��������
	 */
	@Test
	public void testUser3(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		User3 user3 = (User3) context.getBean("user3");
		System.out.println(user3);
		user3.add();

	}

	/**
	 * �����ļ�ͨ�� �вι��췽ʽ ��class��ע������
	 */
	@Test
	public void testProperty1(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		PropertyDemo1 propertyDemo1 = (PropertyDemo1) context.getBean("propertyDemo1");
		System.out.println(propertyDemo1);
		propertyDemo1.test1();
	}
	/**
	 * �����ļ�ͨ�� setter ��class��ע������
	 */
	@Test
	public void testProperty2(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		PropertyDemo2 propertyDemo2 = (PropertyDemo2) context.getBean("propertyDemo2");
		System.out.println(propertyDemo2);
		propertyDemo2.test2();
	}
	/**
	 * �����ļ�ͨ�� setter ��class��ע�롾��������
	 */
	@Test
	public void testPropertyRef(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		UserService userservice = (UserService) context.getBean("userservice");
		System.out.println(userservice);
		userservice.test();
	}
	/**
	 * �����ļ�ͨ�� p���ƿռ� ��class��ע������
	 * ����ע��  ��������
	 */
	@Test
	public void testPropertyP(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

		PropertyDemo3 propertyDemo3 = (PropertyDemo3) context.getBean("propertyDemo3");
		System.out.println(propertyDemo3);
		propertyDemo3.test3();
	}
	
	
	
	
	
}
