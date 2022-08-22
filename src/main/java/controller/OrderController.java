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

import beans.OrderBean;
import beans.UserBean;
import service.BasketService;
import service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BasketService basketService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	
	@RequestMapping("/order_pro") 
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
							@RequestParam("goods_idx") String goods_idx,
							@RequestParam("order_basket") String order_basket, 
							@RequestParam("topmenu_name") String topmenu_name,
							OrderBean payInfoBean,
							UserBean loginUserBean,
							 Model model) {
		
		orderService.addOrderInfo(orderInfoBean);
		OrderBean userInfo = orderService.getUserInfo(orderInfoBean);
		List<OrderBean> orderList = orderService.getOrderInfo(orderInfoBean);
		
		model.addAttribute("goods_idx", goods_idx);
		model.addAttribute("topmenu_name", topmenu_name);
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("orderList", orderList);
		model.addAttribute("orderInfoBean",orderInfoBean);
		model.addAttribute("loginUserBean", loginUserBean);
		
		if(order_basket.equals("장바구니")) {
			basketService.addBasketInfo(orderInfoBean);
			
			return "redirect:/basket/basket_success";
			
			//return "redirect:/goods/goods_detail";
		}else {
//		System.out.println(orderInfoBean.getGoods_idx());
//		System.out.println(orderInfoBean.getOrder_idx());
//		System.out.println(orderInfoBean.getGoods_name());
		
		return "order/main";
		}
	}
	
	
	@PostMapping("/pay_pro")
	public String pay_pro(@ModelAttribute("payInfoBean") OrderBean payInfoBean,
							OrderBean orderInfoBean,
						   Model model) {
		
		List<OrderBean> payInfo = orderService.addPayInfo(payInfoBean);
		OrderBean payUserInfo = orderService.getUserInfo(orderInfoBean);
//		orderService.addOrderInfo(orderInfoBean);
//		model.addAttribute("orderInfoBean",orderInfoBean);
		model.addAttribute("payInfo", payInfo);
		model.addAttribute("payUserInfo", payUserInfo);
		model.addAttribute("order_pay_option", payInfoBean.getOrder_pay_option());
		
		System.out.println(payInfoBean.getOrder_pay_option());
		return "order/pay_success";
	}

}
