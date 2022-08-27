package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.OrderBean;

public interface BasketMapper {
	
	@Select("select basket_idx "+
			"from basket_table " +
			"where goods_idx = #{goods_idx}")
	String checkBasketExist(String goods_idx);
	
	  @Insert("insert into basket_table(basket_idx, user_idx, user_name, goods_idx, goods_thumbnail, goods_name, goods_sell_price, basket_goods_cnt, order_amt) " +
	  		  "values(basket_seq.nextval, #{user_idx}, #{user_name}, #{goods_idx}, #{goods_thumbnail}, #{goods_name}, #{goods_sell_price}, #{order_cnt}, #{order_amt})")
	  void addBasketInfo(OrderBean orderInfoBean);
	  
	  @Select("select b.basket_idx, b.user_idx, g.goods_thumbnail, g.goods_category, b.goods_idx, b.goods_name, b.basket_goods_cnt as order_cnt, b.goods_sell_price, b.order_amt "
		  		+ "from basket_table b , goods_table g "
		  		+ " where b.user_idx = #{user_idx} and g.goods_idx = b.goods_idx "
		  		+ "order by b.goods_idx")
	  List<OrderBean> getBasketInfo(OrderBean basketInfoBean);
	 
	  @Select("select b.basket_idx, g.goods_idx, g.goods_thumbnail, g.goods_sell_price, b.basket_goods_cnt, b.order_amt, g.goods_content "
				+ "from goods_table g, basket_table b "
				+ "where b.basket_idx=#{basket_idx} and b.goods_idx = g.goods_idx")
		OrderBean getModifyBaksetInfo(OrderBean orderInfoBean);
	  
	  @Update("UPDATE basket_table " +
			  "set basket_goods_cnt = #{order_cnt}, order_amt = #{order_amt} " +
			  "where basket_idx = #{basket_idx}")
	  void modifyBasketInfo(OrderBean modifyBasketBean);
	  
	  @Delete("DELETE from basket_table where basket_idx = #{basket_idx}")
	  void deleteBasketInfo(String basket_idx);
	  
	  
}
