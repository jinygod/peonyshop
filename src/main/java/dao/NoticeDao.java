package dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	
	//오류 추정
	public 	List<NoticeBean> getNoticeList(NoticeBean noticeBean) {
		return noticeMapper.getNoticeList(noticeBean);
	}
	
	public NoticeBean getReadNotice(NoticeBean readNoticeBean) {
		return noticeMapper.getReadNotice(readNoticeBean);
	}
	
	public void deleteNotice(NoticeBean deleteNoticeBean) {
		noticeMapper.deleteNotice(deleteNoticeBean);
	}
}
