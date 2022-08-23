package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.BasketBean;
import beans.OrderBean;
import mapper.BasketMapper;

@Repository
public class BasketDao {

	@Autowired
	private BasketMapper basketMapper;
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketMapper.addBasketInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketInfo(OrderBean basketInfoBean){
		  return basketMapper.getBasketInfo(basketInfoBean);
	  }
}
