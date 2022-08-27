package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.BasketBean;
import beans.GoodsBean;
import beans.OrderBean;
import beans.UserBean;
import service.BasketService;
import service.GoodsService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	
	@GetMapping("/main")
	public String basket(@RequestParam("price") Integer price,
						 @RequestParam("cnt") Integer cnt,
						 @RequestParam("amt") Integer amt,
						 //BasketBean basketInfoBean,
						 Model model) {
		
		// 장바구니 user_idx가 안넘어가서 일시중단
		// basketService.addBasketInfo(basketInfoBean);

		model.addAttribute("loginUserBean", loginUserBean);
		model.addAttribute("basket_price", price);
		model.addAttribute("basket_cnt", cnt);
		model.addAttribute("basket_amt", amt);
		
		return "basket/main";
	}
	
	@GetMapping("/basket_success")
	public String basket_success(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
								@RequestParam("goods_idx") String goods_idx,
								@RequestParam("topmenu_name") String topmenu_name,
								OrderBean payInfoBean,
								 Model model) {
		
		model.addAttribute("goods_idx", goods_idx);
		model.addAttribute("topmenu_name", topmenu_name);
		//model.addAttribute("userInfo",userInfo);
		//model.addAttribute("orderList", orderList);
		model.addAttribute("orderInfoBean",orderInfoBean);
		model.addAttribute("loginUserBean", loginUserBean);
		
		return "basket/basket_success";
	}
	
	@GetMapping("/basket_list")
	public String basket_list(OrderBean basketInfoBean, 
							  Model model) {

	//	basketInfoBean.setGoods_idx(orderInfoBean.getGoods_idx());
		basketInfoBean.setUser_idx(loginUserBean.getUser_idx());
		basketService.getBasketInfo(basketInfoBean);
		List<OrderBean> basketList = basketService.getBasketInfo(basketInfoBean);
		System.out.println("basketInfoBean : " + basketInfoBean);
		model.addAttribute("basketList", basketList);

		return "basket/basket_list";
	}
	
	@GetMapping("/basket_modify")
	public String basket_modify(@ModelAttribute("modifyBasketBean") OrderBean modifyBasketBean,
								@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
								@RequestParam("goods_idx") String goods_idx,
								@RequestParam("basket_idx") String basket_idx,
								 Model model) {
		
		model.addAttribute("basket_idx", basket_idx);
		model.addAttribute("goods_idx", goods_idx);
		System.out.println("modify:"  + orderInfoBean.getGoods_idx());
//		orderInfoBean.setGoods_idx();
		OrderBean modifyBasketInfo = basketService.getModifyBaksetInfo(orderInfoBean);
//		model.addAttribute("user_idx", loginUserBean.getUser_idx());
		model.addAttribute("modifyBasketInfo", modifyBasketInfo);
		
		
		return "basket/basket_modify";
		
	}
	
	
	@PostMapping("/basket_modify_pro")
	public String basket_modify_pro(@ModelAttribute("modifyBasketBean") OrderBean modifyBasketBean,
									@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
									@RequestParam("goods_idx") String goods_idx,
									@RequestParam(value = "basket_idx") String basket_idx,
									GoodsBean getGoodsDetail,
									Model model) {
		
		model.addAttribute("basket_idx", basket_idx);
		basketService.modifyBasketInfo(modifyBasketBean);
		GoodsBean goodsDetail = goodsService.getGoodsDetail(goods_idx);
		model.addAttribute("goodsDetail", goodsDetail);
		return "basket/basket_modify_success";
		
	}
	
	@GetMapping("/basket_delete")
	public String basket_delete(@RequestParam("basket_idx") String basket_idx) {
		
		basketService.deleteBasketInfo(basket_idx);
		
		return "basket/basket_delete";
	}
}
