package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	

	@GetMapping("/main")
	public String main() {
//		System.out.println("[MainController] /main");
		return "main";
	}
}
