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
import beans.UserBean;
import service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	@GetMapping("/main")
	public String main(@RequestParam("topmenu_name") String topmenu_name,  Model model,
			UserBean loginUserBean) {
		
		List<GoodsBean> goodsList = goodsService.getGoodsList(topmenu_name);
		
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("topmenu_name", topmenu_name);
		model.addAttribute("user_idx", loginUserBean.getUser_idx());
		
		return "goods/main";
	}
	
	@GetMapping("/goods_detail")
	public String goods_detail(@RequestParam("topmenu_name") String topmenu_name,
								@RequestParam("goods_idx") String goods_idx,
								GoodsBean getGoodsDetail, Model model,
								UserBean loginUserBean)  {
		
		GoodsBean goodsDetail = goodsService.getGoodsDetail(goods_idx);
		model.addAttribute("goodsDetail", goodsDetail);
		model.addAttribute("goods_idx", goods_idx);
		model.addAttribute("user_idx", loginUserBean.getUser_idx());
		model.addAttribute("topmenu_name", topmenu_name);

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
	public String goods_list(Model model) {
		
		List<GoodsBean> adminGoodsList = goodsService.getAdminGoodsList();
		
		model.addAttribute("adminGoodsList", adminGoodsList);
		return "goods/goods_list";
	}
	

	@GetMapping("/buy_pro")
	public String buy_pro(UserBean loginUserBean) {

		
		return "goods/basket";
	}
	
	@GetMapping("/basket")
	public String basket2(@RequestParam("user_idx") String user_idx, Model model) {
		
		model.addAttribute("user_idx", user_idx);
		
		return "goods/basket";
	}
	
	@PostMapping("/buy")
	public String buy(@RequestParam("user_idx") String user_idx, Model model) {
		
		model.addAttribute("user_idx", user_idx);
		
		return "goods/buy";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyGoodsBean") GoodsBean modifyGoodsBean,
						@RequestParam("goods_idx") String goods_idx, Model model) {
		
		GoodsBean goodsInfo = goodsService.getModifyGoodsInfo(goods_idx);
		
		model.addAttribute("goodsInfo", goodsInfo);
		model.addAttribute("goods_idx", goods_idx);
		
		return "goods/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@ModelAttribute("modifyGoodsBean") GoodsBean modifyGoodsBean) {
		
		return "goods/modify_success";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("goods_idx") String goods_idx, Model model) {
		
		goodsService.deleteGoods(goods_idx);
		
		model.addAttribute("goods_idx", goods_idx);
		
		return "goods/delete";
	}
	
}
