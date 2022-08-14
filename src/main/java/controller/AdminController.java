package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.AdminBean;
import service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
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
}
