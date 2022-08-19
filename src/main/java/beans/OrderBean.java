package beans;

public class OrderBean {
	
	private String order_idx;
	private String goods_name;
	private String order_price;
	private String order_cnt;
	private String order_tot;
	
	private String user_idx;
	private String user_name;
	private String user_phone;
	private String user_zipcode;
	private String user_addr1;
	private String user_addr2;
	private String order_pay_option;
	private String order_pay_bank;
	private String order_date;
	
	
	
	/*
	 * public OrderBean(int order_tot) { this.order_tot = order_price * order_cnt; }
	 */
	
	public String getOrder_idx() {
		return order_idx;
	}
	public void setOrder_idx(String order_idx) {
		this.order_idx = order_idx;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(String order_cnt) {
		this.order_cnt = order_cnt;
	}
	public String getOrder_tot() {
		return order_tot;
	}
	public void setOrder_tot(String order_tot) {
		this.order_tot = order_tot;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_zipcode() {
		return user_zipcode;
	}
	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}
	public String getUser_addr1() {
		return user_addr1;
	}
	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	public String getOrder_pay_option() {
		return order_pay_option;
	}
	public void setOrder_pay_option(String order_pay_option) {
		this.order_pay_option = order_pay_option;
	}
	public String getOrder_pay_bank() {
		return order_pay_bank;
	}
	public void setOrder_pay_bank(String order_pay_bank) {
		this.order_pay_bank = order_pay_bank;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	
	
}
