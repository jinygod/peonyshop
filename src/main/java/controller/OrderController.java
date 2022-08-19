package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.OrderBean;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderBean orderBean;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order_pro")
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean) {
		return "order_pro2";
	}
	
	@PostMapping("/order_pro2")
	public String order_pro(@ModelAttribute("orderInfoBean") OrderBean orderInfoBean,
							@ModelAttribute("orderInfoBean2") OrderBean orderInfoBean2) {
		
		orderService.addOrderBean(orderInfoBean, orderInfoBean2);
		
		return "order_pro3";
	}
}
