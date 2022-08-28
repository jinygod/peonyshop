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
	
	// 바로구매 (goods_detail)
	@Insert("insert into order_table (payOK, order_idx, goods_category, goods_idx, goods_thumbnail, goods_name, order_price, order_cnt, order_amt, " +
			"user_idx, user_name, user_phone, user_email, user_birth, user_zipcode, user_addr1, user_addr2, order_date) " +
			"values(1, #{order_idx}, #{goods_category}, #{goods_idx}, #{goods_thumbnail}, #{goods_name}, #{goods_sell_price}, #{order_cnt}, #{order_amt}, " + 
			"#{user_idx}, #{user_name}, #{user_phone}, #{user_email}, #{user_birth}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, sysdate)")
	void addOrderInfo(OrderBean orderInfoBean);
	
	// 장바구니에서 구매(basket_list)
	@Insert("insert into order_table(order_idx, basket_idx, user_idx, goods_idx, goods_thumbnail, goods_name, order_price, order_cnt, order_amt) "
			+ "select order_seq.nextval, basket_idx, user_idx, goods_idx, goods_thumbnail, goods_name, goods_sell_price, basket_goods_cnt, order_amt from basket_table")
	void addBasketToOrderInfo(OrderBean basketOrderBean);
	
	// 바로구매 -> 주문(order_main)
	@Select("select order_idx, payOK, goods_idx,  goods_thumbnail, goods_name, order_price, order_cnt, order_amt "
			+ "from order_table " +
			"where user_idx = #{user_idx} and order_idx = #{order_idx}")
	List<OrderBean> getOrderInfo(OrderBean orderInfoBean);
	
	// 장바구니 -> 주문(order_main)
	@Select("select order_idx, basket_idx, goods_idx,  goods_thumbnail, goods_name, order_price, order_cnt, order_amt "
			+ "from order_table "
			+ "where basket_idx BETWEEN (select min(basket_idx) from basket_table) AND (select max(basket_idx) from basket_table)")
	List<OrderBean> getBasketToOrderInfo(OrderBean basketOrderBean);
	
	// user 정보 가져오기
	@Select("select u.user_idx, u.user_name, u.user_phone, u.user_birth, u.user_email, u.user_zipcode, u.user_addr1, u.user_addr2, o.order_pay_option "
			+ "from user_table u, order_table o "
			+ "where u.user_idx = #{user_idx} and o.order_idx = #{order_idx}")
	OrderBean getUserInfo(OrderBean orderInfoBean);
	
	// 주문(order_main) -> 결제창(pay_success)
	@Select("select order_idx, goods_thumbnail, goods_name, order_price, order_cnt, order_amt, order_pay_option, "
			+ "    user_name, user_email, user_phone, user_zipcode, user_addr1, user_addr2 "
			+ "from order_table "
			+ "where payOK = 1 or "
			+ "(basket_idx BETWEEN (select min(basket_idx) from basket_table) AND (select max(basket_idx) from basket_table))")
	List<OrderBean> getPayInfo(OrderBean payInfoBean);
	
	// 장바구니(수정버튼) 수량 변경
	 @Update("UPDATE basket_table " +
			  "set basket_goods_cnt = #{order_cnt}, order_amt = #{order_amt} " +
			  "where goods_idx = #{goods_idx}")
	  void modifyBasketCntInfo(OrderBean orderInfoBean);
	
	 // 장바구니(basket_table) user 정보 추가
	 @Update("update order_table " +
			 "set user_name = #{user_name}, user_birth = #{user_birth}, user_phone = #{user_phone}, user_email = #{user_email}, "
			 + " user_zipcode = #{user_zipcode}, user_addr1 = #{user_addr1}, user_addr2 = #{user_addr2}, order_date = sysdate "
			 + "where user_idx = #{user_idx}") 
	 void modifyOrderUserInfo(OrderBean basketOrderBean); 
	 
	 // 결제완료 -> 장바구니 삭제
	 @Delete("delete from basket_table " +
			  "where user_idx = #{user_idx}")
	  void deleteBasketInfo(String user_idx);
	 
	 // order_table에 결제정보 추가
	 @Update("update order_table " +
			 "set order_pay_option = #{order_pay_option}"
			 + "where order_idx BETWEEN (select min(order_idx) from order_table) AND (select max(order_idx) from order_table)")
	 void modifyPayOptionInfo(OrderBean payInfoBean);
	 
	 // order_table 결제 완료 구분
	 @Update("update order_table " +
			 "set payOK = 0 "
			 + "where payOK = 1")
	 void modifypayOKInfo(OrderBean payInfoBean);
	 
	 // 관리자페이지에서 결제완료된 주문내역 조회
	 @Select("select * " +
			 "from order_table " +
			 "where order_pay_option is not null")
	 List<OrderBean> getOrderManageInfo(OrderBean orderManageBean);
	 
	 // 결제 전 유저정보 수정
	 @Update("update order_table " +
			 "set user_email = #{user_email}, user_phone = #{user_phone}, user_zipcode = #{user_zipcode}, user_addr1 = #{user_addr1}, user_addr2 = #{user_addr2}")
	 void modifyPayInfo(OrderBean payInfoBean);
	 
}
	