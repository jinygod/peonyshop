package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.BasketBean;
import mapper.BasketMapper;

@Repository
public class BasketDao {

	@Autowired
	private BasketMapper basketMapper;
	
	public BasketBean addBasketInfo(BasketBean basketInfoBean) {
		return basketMapper.addBasketInfo(basketInfoBean);
	}
}
