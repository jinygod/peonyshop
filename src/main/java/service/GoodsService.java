package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.GoodsBean;
import dao.GoodsDao;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	public void addGoodsInfo(GoodsBean goodsRegBean) {
		
		goodsDao.addGoodsInfo(goodsRegBean);
		
	}
		
}
