package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@PostMapping("/main")
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
							@ModelAttribute("basketOrderBean") OrderBean basketOrderBean,
							@RequestParam("goods_idx") String goods_idx,
//							@RequestParam("user_idx") String user_idx,
							@RequestParam(value = "order_basket", required = false) String order_basket, 
							@RequestParam(value = "topmenu_name", required = false) String topmenu_name,
							Model model) {
		
		model.addAttribute("goods_idx", goods_idx);
//		model.addAttribute("user_idx", user_idx);
		model.addAttribute("topmenu_name", topmenu_name);
		model.addAttribute("orderInfoBean", orderInfoBean);
		model.addAttribute("basketOrderBean", basketOrderBean);

		if (loginUserBean.isUserLogin() == true) {

			if (order_basket.equals("장바구니")) {
				
				boolean chk = basketService.checkBasketExist(goods_idx);	// BasketTable에 해당 goods_idx 값을 가져옴
				if(chk == true) {											// BasketTable에 값이 없으면 true
				basketService.addBasketInfo(orderInfoBean);					// BasketTable에 값 추가
				return "redirect:/basket/basket_success";
				} else {
					orderService.modifyBasketCntInfo(orderInfoBean);		// BasketTable에 기존 값(수량) 수정
					return "redirect:/basket/basket_success";
				}
				
			} else {
				if(order_basket.equals("바로구매")){
					orderService.addOrderInfo(orderInfoBean);								// order_table에 값 추가(Insert)
					OrderBean userInfo = orderService.getUserInfo(orderInfoBean);			// user정보 가져옴
					List<OrderBean> orderList = orderService.getOrderInfo(orderInfoBean);	// order_table 리스트 조회(Select)
					model.addAttribute("orderList", orderList);
					model.addAttribute("userInfo", userInfo);
				} else {																	// 장바구니에서 구매하기
					orderService.addBasketToOrderInfo(basketOrderBean);						// order_table에 값 추가(Insert)
					List<OrderBean> orderList = orderService.getBasketToOrderInfo(basketOrderBean);	// order_table 리스트 조회(Select)
					orderService.modifyOrderUserInfo(basketOrderBean);								// order_table에 user정보 추가
					model.addAttribute("orderList", orderList);
				}


			} 
			return "order/main";
		}
		return "user/not_login";
	}
	
	
	@PostMapping("/pay_pro")
	public String pay_pro(@ModelAttribute("payInfoBean") OrderBean payInfoBean,
						  Model model) {
		
		List<OrderBean> payInfo = orderService.getPayInfo(payInfoBean);	 // 주문정보 select
		model.addAttribute("payInfo", payInfo);
//		model.addAttribute("order_pay_option", payInfoBean.getOrder_pay_option());
		
		if(payInfoBean.getPayOK() != "1" ||
				payInfoBean.getPayOK() != "0"	) {	// 장바구니 -> pay_success 라면
			orderService.deleteBasketInfo(loginUserBean.getUser_idx());	// 결제완료 후 basket_table 목록 삭제
		}
		
		orderService.modifyPayOptionInfo(payInfoBean);	// order_pay_option(결제수단) 추가
		orderService.modifypayOKInfo(payInfoBean);		// payOK(결제완료) 0으로 변경
		orderService.modifyPayInfo(payInfoBean);	// order_main -> pay_success '결제정보' 수정 반영
		model.addAttribute("payInfoBean", payInfoBean);
		return "order/pay_success";
	}
	
	@GetMapping("/order_manage")
	public String order_manage(OrderBean orderManageBean, Model model) {
		
		List<OrderBean> orderManageInfo = orderService.getOrderManageInfo(orderManageBean);
		
		model.addAttribute("orderManageInfo", orderManageInfo);
		
		return "admin/order_manage";
	}

}
