package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.OrderBean;
import mapper.OrderMapper;

@Repository
public class OrderDao {

	@Autowired
	private OrderMapper orderMapper;
	
	public void addOrderInfo(OrderBean orderInfoBean) {
		 orderMapper.addOrderInfo(orderInfoBean);
	}
	
	public void addBasketToOrderInfo(OrderBean basketOrderBean) {
		orderMapper.addBasketToOrderInfo(basketOrderBean);
	}
	
	public List<OrderBean> getOrderInfo(OrderBean orderInfoBean){
		return orderMapper.getOrderInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketToOrderInfo(OrderBean basketOrderBean){
		return orderMapper.getBasketToOrderInfo(basketOrderBean);
	}
	
	public OrderBean getUserInfo(OrderBean orderInfoBean) {
		return orderMapper.getUserInfo(orderInfoBean);
	}
	
	public List<OrderBean> getPayInfo(OrderBean payInfoBean) {
		return orderMapper.getPayInfo(payInfoBean);
	}
	
	public void modifyOrderUserInfo(OrderBean basketOrderBean) {
		orderMapper.modifyOrderUserInfo(basketOrderBean);
	}
	
	public void modifyBasketCntInfo(OrderBean orderInfoBean) {
		orderMapper.modifyBasketCntInfo(orderInfoBean);
	}
	
	public void deleteBasketInfo(String user_idx) {
		orderMapper.deleteBasketInfo(user_idx);
	}
	
	public void modifyPayOptionInfo(OrderBean payInfoBean) {
		orderMapper.modifyPayOptionInfo(payInfoBean);
	}
	
	
	public void modifypayOKInfo(OrderBean payInfoBean) {
	 orderMapper.modifypayOKInfo(payInfoBean); 
	 }
	 
	public List<OrderBean> getOrderManageInfo(OrderBean orderManageBean) {
		return orderMapper.getOrderManageInfo(orderManageBean);
	}
	
	
	  public void modifyPayInfo(OrderBean payInfoBean) {
	  orderMapper.modifyPayInfo(payInfoBean); }
	 
}
