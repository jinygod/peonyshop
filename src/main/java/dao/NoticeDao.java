package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.NoticeBean;
import mapper.NoticeMapper;

@Repository
public class NoticeDao {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public void addNoticeInfo(NoticeBean writeNoticeBean) {
		noticeMapper.addNoticeInfo(writeNoticeBean);
	}
	
	public 	List<NoticeBean> getNoticeList(NoticeBean noticeBean) {
		return noticeMapper.getNoticeList(noticeBean);
	}
	
	public NoticeBean getReadNotice(int notice_idx) {
		return noticeMapper.getReadNotice(notice_idx);
	}
	
	public void deleteNotice(NoticeBean deleteNoticeBean) {
		noticeMapper.deleteNotice(deleteNoticeBean);
	}
}
