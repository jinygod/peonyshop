package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.OrderBean;
import service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/order_pro") 
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean) {
		
		orderService.addOrderInfo(orderInfoBean);
		
		System.out.println(orderInfoBean.getGoods_idx());
		
		return "order/main";
	}
	

}
