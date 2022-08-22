package beans;

public class BasketBean {

	private String bakset_idx;
	
	private String user_idx;
	private String user_name;
	private String goods_idx;
	private String goods_name;
	private String goods_sell_price;
	
	private String basket_goods_cnt;
	private String goods_amt;
	
	
	public String getBakset_idx() {
		return bakset_idx;
	}
	public void setBakset_idx(String bakset_idx) {
		this.bakset_idx = bakset_idx;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	public String getGoods_idx() {
		return goods_idx;
	}
	public void setGoods_idx(String goods_idx) {
		this.goods_idx = goods_idx;
	}
	public String getBasket_goods_cnt() {
		return basket_goods_cnt;
	}
	public void setBasket_goods_cnt(String basket_goods_cnt) {
		this.basket_goods_cnt = basket_goods_cnt;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_sell_price() {
		return goods_sell_price;
	}
	public void setGoods_sell_price(String goods_sell_price) {
		this.goods_sell_price = goods_sell_price;
	}
	public String getGoods_amt() {
		return goods_amt;
	}
	public void setGoods_amt(String goods_amt) {
		this.goods_amt = goods_amt;
	}
	
}
