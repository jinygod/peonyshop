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

import beans.NoticeBean;
import service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	//오류 추정
	@GetMapping("/main")
	public String main(@RequestParam("notice_idx") int notice_idx, 
						Model model){
		
		List<NoticeBean> noticeList = noticeService.getNoticeList(notice_idx);
		
		model.addAttribute("noticeList", noticeList);
		
		return "notice/main";
	}

	@GetMapping("/read")
	public String read() {
		return "notice/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeNoticeBean") NoticeBean writeNoticeBean) {

		return "notice/write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@ModelAttribute("writeNoticeBean") NoticeBean writeNoticeBean) {

		noticeService.addNoticeInfo(writeNoticeBean);


		return "notice/write_success";
	}
	
}
