package controller;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

	@PostMapping("/order_pro")
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
							@RequestParam("goods_idx") String goods_idx,
							@RequestParam(value = "order_basket", required = false) String order_basket, 
							@RequestParam(value = "topmenu_name", required = false) String topmenu_name,
							OrderBean payInfoBean, 
							HttpServletRequest request,
							Model model) {
		
		System.out.println(orderInfoBean.getGoods_name());
		// String[] basket_check_values = request.getParameterValues("goods_idx");
		
		model.addAttribute("goods_idx", goods_idx);
		model.addAttribute("topmenu_name", topmenu_name);
		model.addAttribute("orderInfoBean", orderInfoBean);
		//model.addAttribute("loginUserBean", loginUserBean);
		System.out.println(loginUserBean.isUserLogin());
		if (loginUserBean.isUserLogin() == true) {

			if (order_basket.equals("장바구니")) {
				basketService.addBasketInfo(orderInfoBean);
				return "redirect:/basket/basket_success";

			} else {
				orderService.addOrderInfo(orderInfoBean);
				OrderBean userInfo = orderService.getUserInfo(orderInfoBean);
				model.addAttribute("userInfo", userInfo);

				if (order_basket.equals("바로구매")) {
					List<OrderBean> orderList = orderService.getOrderInfo(orderInfoBean);
					model.addAttribute("orderList", orderList);

				} else {
					/*for (String value : basket_check_values) {
						String basket_check_idx = value;
						System.out.printf("basket_check : (%s)\n", basket_check_idx);*/
					List<OrderBean> orderList = orderService.getOrderInfo(orderInfoBean);
					model.addAttribute("orderList", orderList);
//						List<OrderBean> basketToOrderList = orderService.getBasketToOrderInfo(orderInfoBean);
//						model.addAttribute("basketToOrderList", basketToOrderList);
					
				}

			}
			return "order/main";
		}
		return "user/not_login";
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
