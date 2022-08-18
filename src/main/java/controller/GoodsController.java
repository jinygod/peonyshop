package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String main(@RequestParam("topmenu_name") String topmenu_name,  Model model) {
		
		List<GoodsBean> goodsList = goodsService.getGoodsList(topmenu_name);
		
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("topmenu_name", topmenu_name);
		
		return "goods/main";
	}
	
	@GetMapping("/goods_detail")
	public String goods_detail(@RequestParam("topmenu_name") String topmenu_name,
								@RequestParam("goods_idx") String goods_idx,
								GoodsBean getGoodsDetail, Model model)  {
		

		GoodsBean goodsDetail = goodsService.getGoodsDetail(goods_idx);
		model.addAttribute("goodsDetail", goodsDetail);
		
		return "goods/goods_detail";
	}
	
	@GetMapping("/goods_reg")
	public String goods_reg(@ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		
		// 서비스에서 가져온걸 여기왜넣어
		
		return "goods/goods_reg";
		
	}
	
	@PostMapping("/goods_reg_pro")
	public String goods_reg_pro(@ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		
		goodsService.addGoodsInfo(goodsRegBean);
		
		return "goods/goods_reg_success";
	}
	
	@GetMapping("/goods_list")
	public String goods_list() {
		
		return "goods/goods_list";
	}
	
	@GetMapping("/basket")
	public String basket(@RequestParam("user_idx") String user_idx, Model model) {
		model.addAttribute("user_idx", user_idx);
		
		return "goods/basket";
	}
	
}
