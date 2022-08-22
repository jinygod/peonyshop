package mapper;

import org.apache.ibatis.annotations.Insert;

import beans.OrderBean;

public interface BasketMapper {

	
	  @Insert("insert into basket_table(basket_idx, user_idx, user_name, goods_idx, goods_name, goods_sell_price, basket_goods_cnt, order_amt) " +
	  		  "values(basket_seq.nextval, #{user_idx}, #{user_name}, #{goods_idx}, #{goods_name}, #{goods_sell_price}, #{order_cnt}, #{order_amt})")
	  void addBasketInfo(OrderBean orderInfoBean);
	  
	 
	 
}
