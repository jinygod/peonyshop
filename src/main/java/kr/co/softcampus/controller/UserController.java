package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.softcampus.beans.UserBean;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean) {
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean) {
		
		return "login_pro";
	}
}
