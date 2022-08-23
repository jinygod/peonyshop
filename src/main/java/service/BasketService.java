package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.BasketBean;
import beans.OrderBean;
import dao.BasketDao;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketDao.addBasketInfo(orderInfoBean);
	}
	
	public List<BasketBean> getBasketInfo(BasketBean basketInfoBean){
		return basketDao.getBasketInfo(basketInfoBean);
	}
}
