package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.GoodsBean;
import mapper.GoodsMapper;

@Repository
public class GoodsDao {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public void addGoodsInfo(GoodsBean goodsRegBean) {
		goodsMapper.addGoodsInfo(goodsRegBean);
	}
}
