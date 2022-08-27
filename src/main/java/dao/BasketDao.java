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
	
	public String checkBasketExist(String goods_idx) {
		return basketMapper.checkBasketExist(goods_idx);
	}
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketMapper.addBasketInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketInfo(OrderBean basketInfoBean){
		  return basketMapper.getBasketInfo(basketInfoBean);
	  }
	
	public OrderBean getModifyBaksetInfo(OrderBean orderInfoBean) {
		return basketMapper.getModifyBaksetInfo(orderInfoBean);
	}
	
	public void modifyBasketInfo(OrderBean modifyBasketBean) {
		basketMapper.modifyBasketInfo(modifyBasketBean);
	}
	
	public void deleteBasketInfo(String basket_idx) {
		basketMapper.deleteBasketInfo(basket_idx);
	}
}
