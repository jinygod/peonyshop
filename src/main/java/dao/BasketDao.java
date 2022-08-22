package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.OrderBean;
import mapper.BasketMapper;

@Repository
public class BasketDao {

	@Autowired
	private BasketMapper basketMapper;
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketMapper.addBasketInfo(orderInfoBean);
	}
}
