package cn.itcast.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//�Դ���4��ע�⣺
//@Component
//@Controller      WEB��
//@Service           ҵ��� 
//@Repository     �־ò�
//��ʵ��������һ���ģ��������Ի��ã��ֿ�ʹ����Spring���Լ����ĺ�·������POST��GET��PUT����
@Component(value="user")	
@Scope(value="prototype")
public class User {
	public void add(){
		System.out.println("add`````````````````");
	}
}
