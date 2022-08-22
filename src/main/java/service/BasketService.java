package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.OrderBean;
import dao.BasketDao;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketDao.addBasketInfo(orderInfoBean);
	}
}
