package mapper;

import org.apache.ibatis.annotations.Insert;

import beans.OrderBean;

public interface OrderMapper {

	@Insert("insert into order_table (order_idx, goods_idx, goods_name, order_price, order_cnt, order_tot, " +
			"user_idx, user_name, user_phone, user_zipcode, user_addr, user_addr2, order_pay_option, order_pay_bank, order_date) " +
			"values(#{order_idx}, #{goods_idx}, #{goods_name}, #{order_price}, #{order_cnt}, #{order_tot}, " + 
			"#{user_idx}, #{user_name}, #{user_phone}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, #{order_option}, #{order_bank}, #{order_date})")
	OrderBean addOrderInfo(OrderBean orderInfoBean, OrderBean orderInfoBean2);
	
	
}
