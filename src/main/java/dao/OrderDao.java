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
	
	public List<OrderBean> getOrderInfo(OrderBean orderInfoBean){
		return orderMapper.getOrderInfo(orderInfoBean);
	}
	
	public OrderBean getUserInfo(OrderBean orderInfoBean) {
		return orderMapper.getUserInfo(orderInfoBean);
	}
	
	public List<OrderBean> addPayInfo(OrderBean payInfoBean) {
		return orderMapper.addPayInfo(payInfoBean);
	}

}
