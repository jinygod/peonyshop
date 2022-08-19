package mapper;

import org.apache.ibatis.annotations.Insert;

import beans.BasketBean;

public interface BasketMapper {

	
	  @Insert("insert into basket_table(basket_idx, user_idx, user_name, goods_idx, goods_name, goods_sell_price, basket_goods_cnt) " +
	  		  "values(basket_seq.nextval, #{user_idx}, #{user_name}, #{goods_idx}, #{goods_name}, #{goods_sell_price}, #{basket_goods_cnt}")
	  BasketBean addBasketInfo(BasketBean basketInfoBean);
	  
	 
	 
}
