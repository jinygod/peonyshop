package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import beans.GoodsBean;

public interface GoodsMapper {

	@Insert("INSERT INTO goods_table "
			+ "(goods_idx, goods_name, goods_category, goods_content, "
			+ "goods_sell_price, goods_thumbnail) "
			+ "VALUES "
			+ "(goods_seq.nextval, #{goods_name}, #{goods_category}, #{goods_content}, #{goods_sell_price}, #{goods_thumbnail, jdbcType=VARCHAR})")
	void addGoodsInfo(GoodsBean goodsRegBean);
	
	@Select("select goods_idx, goods_category, goods_name, goods_sell_price, goods_thumbnail "
			+ "from goods_table "
			+ "where goods_category = #{goods_category}")
	GoodsBean getGoodsInfo(GoodsBean getGoodsInfo);
}
