package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import beans.OrderBean;

public interface OrderMapper {

	@SelectKey(statement = "select order_seq.nextval from dual", keyProperty = "order_idx", before = true, resultType = String.class)
	
	
	@Insert("insert into order_table (order_idx, goods_category, goods_idx, goods_name, order_price, order_cnt, order_amt, " +
			"user_idx, user_name, user_phone, user_email, user_birth, user_zipcode, user_addr1, user_addr2, order_date) " +
			"values(#{order_idx}, #{goods_category}, #{goods_idx}, #{goods_name}, #{goods_sell_price}, #{order_cnt}, #{order_amt}, " + 
			"#{user_idx}, #{user_name}, #{user_phone}, #{user_email}, #{user_birth}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, sysdate)")
	void addOrderInfo(OrderBean orderInfoBean);
	
	@Insert("insert into order_table(order_idx, user_idx, goods_idx, goods_thumbnail, goods_name, order_price, order_cnt, order_amt) "
			+ "select order_seq.nextval, user_idx, goods_idx, goods_thumbnail, goods_name, goods_sell_price, basket_goods_cnt, order_amt from basket_table")
	void addBasketToOrderInfo(OrderBean basketOrderBean);
	
	@Select("select o.goods_idx,  g.goods_thumbnail, g.goods_name, g.goods_sell_price, o.order_cnt, o.order_amt "
			+ "from order_table o, goods_table g, topmenu_table t " +
			"where g.goods_idx=#{goods_idx} and t.topmenu_name=#{goods_category}" )
	List<OrderBean> getOrderInfo(OrderBean orderInfoBean);
	
	@Select("select order_idx, goods_idx,  goods_thumbnail, goods_name, order_price, order_cnt, order_amt "
			+ "from order_table" )
	List<OrderBean> getBasketToOrderInfo(OrderBean basketOrderBean);
	
	@Select("select u.user_idx, u.user_name, u.user_phone, u.user_birth, u.user_email, u.user_zipcode, u.user_addr1, u.user_addr2, o.order_pay_option "
			+ "from user_table u, order_table o "
			+ "where u.user_idx = #{user_idx} and o.order_idx = #{order_idx}")
	OrderBean getUserInfo(OrderBean orderInfoBean);
	
	@Select("select order_idx, goods_thumbnail, goods_name, order_price, order_cnt, order_amt, order_pay_option, "
			+ "    user_name, user_email, user_phone, user_zipcode, user_addr1, user_addr2 "
			+ "from order_table ")
	List<OrderBean> addPayInfo(OrderBean payInfoBean);
	
	 @Update("UPDATE basket_table " +
			  "set basket_goods_cnt = #{order_cnt}, order_amt = #{order_amt} " +
			  "where goods_idx = #{goods_idx}")
	  void modifyBasketCntInfo(OrderBean orderInfoBean);
	
	 @Update("update order_table " +
			 "set user_name = #{user_name}, user_birth = #{user_birth}, user_phone = #{user_phone}, user_email = #{user_email}, "
			 + " user_zipcode = #{user_zipcode}, user_addr1 = #{user_addr1}, user_addr2 = #{user_addr2}, order_date = sysdate "
			 + "where user_idx = #{user_idx}") 
	 void modifyOrderUserInfo(OrderBean basketOrderBean); 
	 
	 @Delete("delete from basket_table " +
			  "where user_idx = #{user_idx}")
	  void deleteBasketInfo(String user_idx);
}
	