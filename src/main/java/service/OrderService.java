package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.OrderBean;
import dao.OrderDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public void addOrderInfo(OrderBean orderInfoBean) {
		orderDao.addOrderInfo(orderInfoBean);
	}
	
	public List<OrderBean> getOrderInfo(OrderBean orderInfoBean){
		return orderDao.getOrderInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketToOrderInfo(OrderBean orderInfoBean){
		return orderDao.getBasketToOrderInfo(orderInfoBean);
	}
	
	public OrderBean getUserInfo(OrderBean orderInfoBean) {
		return orderDao.getUserInfo(orderInfoBean);
		
	}
	public List<OrderBean> addPayInfo(OrderBean payInfoBean) {
		return orderDao.addPayInfo(payInfoBean);
	}
}
