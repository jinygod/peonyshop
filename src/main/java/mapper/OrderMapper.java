package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import beans.OrderBean;

public interface OrderMapper {

	@SelectKey(statement = "select order_seq.nextval from dual", keyProperty = "order_idx", before = true, resultType = String.class)
	
	
	@Insert("insert into order_table (order_idx, basket_check_idx, goods_idx, goods_name, order_price, order_cnt, order_amt, " +
			"user_idx, user_name, user_phone, user_email, user_birth, user_zipcode, user_addr1, user_addr2, order_date) " +
			"values(#{order_idx}, #{basket_check_idx}, #{goods_idx}, #{goods_name}, #{goods_sell_price}, #{order_cnt}, #{order_amt}, " + 
			"#{user_idx}, #{user_name}, #{user_phone}, #{user_email}, #{user_birth}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, sysdate)")
	void addOrderInfo(OrderBean orderInfoBean);
	
	@Select("select o.order_idx, g.goods_idx,  g.goods_thumbnail, g.goods_name, g.goods_sell_price, o.order_cnt, o.order_amt "
			+ "from order_table o, goods_table g , topmenu_table t "
			+ "where order_idx = #{order_idx} and g.goods_idx= #{goods_idx} and t.topmenu_name = #{topmenu_name}" )
	List<OrderBean> getOrderInfo(OrderBean orderInfoBean);
	
	@Select("select o.order_idx, g.goods_idx,  g.goods_thumbnail, g.goods_name, g.goods_sell_price, o.order_cnt, o.order_amt "
			+ "from order_table o, goods_table g , topmenu_table t "
			+ "where order_idx = #{order_idx} and o.basket_check_idx = #{basket_check_idx} and t.topmenu_name = #{topmenu_name}" )
	List<OrderBean> getBasketToOrderInfo(OrderBean orderInfoBean);
	
	@Select("select u.user_idx, u.user_name, u.user_phone, u.user_birth, u.user_email, u.user_zipcode, u.user_addr1, u.user_addr2, o.order_pay_option "
			+ "from user_table u, order_table o "
			+ "where u.user_idx = #{user_idx} and o.order_idx = #{order_idx}")
	OrderBean getUserInfo(OrderBean orderInfoBean);
	
	@Select("select o.order_idx, g.goods_thumbnail, g.goods_name, g.goods_sell_price, o.order_cnt, o.order_amt, o.order_pay_option, "
			+ "    u.user_name, u.user_email, u.user_phone, u.user_zipcode, u.user_addr1, u.user_addr2 "
			+ "from order_table o, user_table u, goods_table g "
			+ "where order_idx = #{order_idx} and g.goods_idx= #{goods_idx} and u.user_idx = #{user_idx}" )
	List<OrderBean> addPayInfo(OrderBean payInfoBean);
	

	
}
	