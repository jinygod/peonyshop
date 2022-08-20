package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.NoticeBean;
import dao.NoticeDao;

@Service
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		noticeDao.addNoticeInfo(writeNoticeBean);
	}
	
	public 	List<NoticeBean> getNoticeList(NoticeBean noticeBean){
		return noticeDao.getNoticeList(noticeBean);
	}
	
	public NoticeBean getReadNotice(String notice_idx) {
		return noticeDao.getReadNotice(notice_idx);
	}
	
	public 	NoticeBean getModifyNoticeInfo(String notice_idx) {
		return noticeDao.getModifyNoticeInfo(notice_idx);
	}
	
	public void modifyNoticeInfo(NoticeBean moidfyNoticeBean) {
		noticeDao.modifyNoticeInfo(moidfyNoticeBean);
	}
	
	public void deleteNotice(NoticeBean deleteNoticeBean) {
		noticeDao.deleteNotice(deleteNoticeBean);
	}
}
