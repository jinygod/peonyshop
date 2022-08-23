package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.OrderBean;
import beans.UserBean;
import dao.BasketDao;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public void addBasketInfo(OrderBean orderInfoBean) {
		basketDao.addBasketInfo(orderInfoBean);
	}
	
	public List<OrderBean> getBasketInfo(OrderBean basketInfoBean){
	//	OrderBean tempBasketInfoBean = basketDao.getBasketInfo(loginUserBean.getUser_idx());
		
	//	basketInfoBean.setUser_idx(tempBasketInfoBean.getUser_idx());
		
		return basketDao.getBasketInfo(basketInfoBean);
	}
}
