package cn.itcast.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	//������Ϊ���ԣ�ע�뵽��һ������
	//01-IOC����ͨ�����вι��졿����setter��ʽ/����Ч�ڱ�������
//	@Autowired
	@Resource(name="userDao")
	private UserDao userDao1;
//	private UserDao userDao = new UserDao();
	public void add(){
		userDao1.add();
		System.out.println("service```````");
	}
}
