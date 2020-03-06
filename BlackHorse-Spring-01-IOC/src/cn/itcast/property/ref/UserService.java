package cn.itcast.property.ref;

public class UserService {
	 private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void test(){
		System.out.println("Service call dao:" + userDao);
		userDao.query();
	}
}
