package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.GoodsBean;
import service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	@GetMapping("/main")
	public String main(@RequestParam("topmenu_idx") int topmenu_idx,
					   @ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		return "goods/main";
	}
	
	@GetMapping("/goods_detail")
	public String goods_detail(@RequestParam("topmenu_idx") int topmenu_idx,
					   @ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		return "goods/goods_detail";
	}
}
