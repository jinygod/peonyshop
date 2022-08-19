package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.BasketBean;
import dao.BasketDao;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
	public BasketBean addBasketInfo(BasketBean basketInfoBean) {
		return basketDao.addBasketInfo(basketInfoBean);
	}
}
