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
	
	public void addBasketToOrderInfo(OrderBean basketOrderBean) {
		orderDao.addBasketToOrderInfo(basketOrderBean);
	}
	
	public List<OrderBean> getOrderInfo(OrderBean orderInfoBean){
		return orderDao.getOrderInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketToOrderInfo(OrderBean basketOrderBean){
		return orderDao.getBasketToOrderInfo(basketOrderBean);
	}
	
	public OrderBean getUserInfo(OrderBean orderInfoBean) {
		return orderDao.getUserInfo(orderInfoBean);
		
	}
	public List<OrderBean> getPayInfo(OrderBean payInfoBean) {
		return orderDao.getPayInfo(payInfoBean);
	}
	
	public void modifyOrderUserInfo(OrderBean basketOrderBean) {
		orderDao.modifyOrderUserInfo(basketOrderBean);
	}
	
	public void modifyBasketCntInfo(OrderBean orderInfoBean) {
		orderDao.modifyBasketCntInfo(orderInfoBean);
	}
	
	public void deleteBasketInfo(String user_idx) {
		orderDao.deleteBasketInfo(user_idx);
	}
	
	public void modifyPayOptionInfo(OrderBean payInfoBean) {
		orderDao.modifyPayOptionInfo(payInfoBean);
	}
	
	
	public void modifypayOKInfo(OrderBean payInfoBean) {
		orderDao.modifypayOKInfo(payInfoBean); 
	 }
	 
	
	public List<OrderBean> getOrderManageInfo(OrderBean orderManageBean) {
		return orderDao.getOrderManageInfo(orderManageBean);
	}
	
	
	  public void modifyPayInfo(OrderBean payInfoBean) {
	  orderDao.modifyPayInfo(payInfoBean); }
	 
}
