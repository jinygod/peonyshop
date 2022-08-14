package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.session.RowBounds;

import beans.NoticeBean;

public interface NoticeMapper {
	
	//오류 추정
	// CHECKLIST 확인
	//@SelectKey(statement = "select notice_seq.nextval from dual", keyProperty = "notice_idx", before = true, resultType = int.class)
	
	@Insert("insert into notice_table "
			+ "(notice_idx, notice_title, notice_content, notice_date) "
			+ "values (#{notice_idx}, #{notice_title}, #{notice_content}, sysdate)")
	void addNoticeInfo(NoticeBean writeNoticeBean);
	
	@Select("select notice_idx, notice_title, to_char(notice_date, 'YYYY-MM-DD') as notice_date "
			+ "from notice_table")
	List<NoticeBean> getNoticeList(NoticeBean noticeBean);
}
