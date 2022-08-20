package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.OrderBean;
import dao.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public OrderBean addOrderInfo(OrderBean orderInfoBean) {
		return orderDao.addOrderInfo(orderInfoBean);
	}
}
