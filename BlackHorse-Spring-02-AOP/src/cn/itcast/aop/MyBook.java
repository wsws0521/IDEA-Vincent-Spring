package cn.itcast.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyBook {

	public void before1(){
		System.out.println("ǰ����ǿ����������������������������");
	}
	
	public void after1(){
		System.out.println("������ǿ����������������������������");
	}
	
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//����֮ǰ
		System.out.println("�����ڷ���֮ǰ����������");
		
		//ִ�б���ǿ�ķ���
		proceedingJoinPoint.proceed();
		
		//����֮ǰ
		System.out.println("�����ڷ���֮�󡤡�������");
	}
	
}