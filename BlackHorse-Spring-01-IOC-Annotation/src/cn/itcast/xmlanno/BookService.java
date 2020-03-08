package cn.itcast.xmlanno;

import javax.annotation.Resource;

public class BookService {
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	public void add(){
		bookDao.book();
		ordersDao.buy();
		System.out.println("Service `````````````");
	}
}
