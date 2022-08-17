package mapper;

import org.apache.ibatis.annotations.Insert;

import beans.GoodsBean;

public interface GoodsMapper {

	@Insert("INSERT INTO goods_table "
			+ "(goods_no, goods_name, goods_category, goods_content, "
			+ "goods_sell_price, goods_thumbnail) "
			+ "VALUES "
			+ "(goods_seq.nextval, #{goods_name} ,#{goods_category}, #{goods_content}, #{goods_sell_price}, #{goods_thumbnail, jdbcType=VARCHAR})")
	void addGoodsInfo(GoodsBean goodsRegBean);
}
