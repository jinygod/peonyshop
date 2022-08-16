package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.AdminBean;
import beans.NoticeBean;
import service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Resource(name = "loginAdminBean")
	private AdminBean loginAdminBean;

	@GetMapping("/main")
	public String main(NoticeBean noticeBean, Model model){
		
		List<NoticeBean> noticeList = noticeService.getNoticeList(noticeBean);

		model.addAttribute("noticeList", noticeList);
		
		return "notice/main";
	}

	@GetMapping("/read")
	public String read(@RequestParam("notice_idx") int notice_idx, 
						Model model) {
		
		NoticeBean readNotice = noticeService.getReadNotice(notice_idx);
		
<<<<<<< HEAD
		model.addAttribute("readNotice", readNotice);
		model.addAttribute("notice_idx", notice_idx);
=======
		model.addAttribute("loginAdminBean", loginAdminBean);
		 model.addAttribute("readNotice", readNotice);
		 model.addAttribute("notice_idx", notice_idx);
>>>>>>> 1929d59f65eb9e19052c34a41b64660379ccc7b8
		
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
	
	@GetMapping("/delete")
	public String delete(@RequestParam("notice_idx") int notice_idx, NoticeBean deleteNoticeBean,
						Model model) {
		
		noticeService.deleteNotice(deleteNoticeBean);
		
		return "notice/delete";
	}
	
	@GetMapping("/modify")
	public String modify() {
		
		return "notice/modify";
		
	}
}
