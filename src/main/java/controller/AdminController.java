package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.AdminBean;
import beans.GoodsBean;
import service.AdminService;
import service.GoodsService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Resource(name ="loginAdminBean")
	private AdminBean loginAdminBean;

	@GetMapping("/login")
		public String login(@ModelAttribute("tempLoginAdminBean") AdminBean tempLoginAdminBean) {
			return "admin/login";
		}
	
	@PostMapping("/login_pro")
	public String login_pro(@ModelAttribute("tempLoginAdminBean") AdminBean tempLoginAdminBean) {
		
		adminService.getLoginAdminInfo(tempLoginAdminBean);
		
		if(loginAdminBean.isAdminLogin() == true) {
			return "admin/login_success";
		}
		
		return "admin/login_fail";
	}
	
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}
	
	@GetMapping("/goodsreg")
	public String goodsreg(@ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		
		return "admin/goodsreg";
		
	}
	
	@PostMapping("/goodsreg_pro")
	public String goodsreg_pro(@ModelAttribute("goodsRegBean") GoodsBean goodsRegBean) {
		
		goodsService.addGoodsInfo(goodsRegBean);
		
		return "admin/goodsreg_success";
	}
	
	@GetMapping("/goodslist")
	public String goodslist() {
		
		return "admin/goodslist";
	}
	
	
}
