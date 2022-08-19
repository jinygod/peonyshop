package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.BasketBean;
import beans.UserBean;
import service.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	/*
	@GetMapping("/main")
	public String basket(@RequestParam("user_idx") String user_idx, Model model) {
		model.addAttribute("user_idx", user_idx);
		
		return "basket/main";
	}
	*/
	
	@GetMapping("/main")
	public String basket(@RequestParam("price") Integer price,
						 @RequestParam("cnt") Integer cnt,
						 @RequestParam("amt") Integer amt,
						 BasketBean basketInfoBean,
						 Model model) {
		
		// 장바구니 user_idx가 안넘어가서 일시중단
		// basketService.addBasketInfo(basketInfoBean);

		model.addAttribute("loginUserBean", loginUserBean);
		model.addAttribute("basket_price", price);
		model.addAttribute("basket_cnt", cnt);
		model.addAttribute("basket_amt", amt);
		
		return "basket/main";
	}
	
}
