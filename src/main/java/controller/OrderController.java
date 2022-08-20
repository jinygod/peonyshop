package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.GoodsBean;
import beans.OrderBean;
import beans.UserBean;
import service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserBean loginUserBean;
	
	@PostMapping("/order_pro") 
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
			GoodsBean getGoodsDetail, Model model) {
		

		OrderBean orderInfo = orderService.addOrderInfo(orderInfoBean);
		
		model.addAttribute("orderInfo", orderInfo);
		
		//System.out.println(orderInfo.getGoods_idx().getClass().getName());
		System.out.println(loginUserBean.getUser_idx());
		System.out.println(orderInfo.getGoods_idx());
		return "order/main";
	}
	

}
