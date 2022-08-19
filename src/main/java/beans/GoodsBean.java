package beans;

import org.springframework.web.multipart.MultipartFile;

public class GoodsBean {

	private String goods_idx;
	private String goods_category;
	private String goods_name;
	private String goods_content;
	private String goods_menu_idx;

	private int goods_sell_price;
	private int goods_tot;
	private String goods_keyword;
	private String goods_readcnt;
	private String goods_pick;
	
	// 브라우저가 보낸 'file data' 를 담기 위한 변수
	private MultipartFile upload_thumbnail;
	
	// 데이터베이스가 저장되어있는 '파일이름'을 담을 변수
	private String goods_thumbnail;

	private String goods_gubun;
	

	
	public String getGoods_idx() {
		return goods_idx;
	}
	public void setGoods_idx(String goods_idx) {
		this.goods_idx = goods_idx;
	}
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_content() {
		return goods_content;
	}
	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}
	public int getGoods_sell_price() {
		return goods_sell_price;
	}
	public void setGoods_sell_price(int goods_sell_price) {
		this.goods_sell_price = goods_sell_price;
	}
	public String getGoods_keyword() {
		return goods_keyword;
	}
	public void setGoods_keyword(String goods_keyword) {
		this.goods_keyword = goods_keyword;
	}
	public String getGoods_readcnt() {
		return goods_readcnt;
	}
	public void setGoods_readcnt(String goods_readcnt) {
		this.goods_readcnt = goods_readcnt;
	}
	public String getGoods_pick() {
		return goods_pick;
	}
	public void setGoods_pick(String goods_pick) {
		this.goods_pick = goods_pick;
	}
	public String getGoods_thumbnail() {
		return goods_thumbnail;
	}
	public void setGoods_thumbnail(String goods_thumbnail) {
		this.goods_thumbnail = goods_thumbnail;
	}
	public String getGoods_gubun() {
		return goods_gubun;
	}
	public void setGoods_gubun(String goods_gubun) {
		this.goods_gubun = goods_gubun;
	}
	public MultipartFile getUpload_thumbnail() {
		return upload_thumbnail;
	}
	public void setUpload_thumbnail(MultipartFile upload_thumbnail) {
		this.upload_thumbnail = upload_thumbnail;
	}
	public String getGoods_menu_idx() {
		return goods_menu_idx;
	}
	public void setGoods_menu_idx(String goods_menu_idx) {
		this.goods_menu_idx = goods_menu_idx;
	}
	public int getGoods_tot() {
		return goods_tot;
	}
	public void setGoods_tot(int goods_tot) {
		this.goods_tot = goods_tot;
	}
	
	
	
	
}
