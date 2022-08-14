package service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	
	//오류 추정
	public 	List<NoticeBean> getNoticeList(NoticeBean noticeBean){
		return noticeDao.getNoticeList(noticeBean);
	}
}
