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
	public List<NoticeBean> getNoticeList(int notice_idx, RowBounds rowBounds){
		return noticeMapper.getNoticeList(notice_idx, rowBounds);
	}
}
