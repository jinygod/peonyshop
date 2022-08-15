package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import beans.NoticeBean;

public interface NoticeMapper {
	
	// CHECKLIST 확인
	//@SelectKey(statement = "select notice_seq.nextval from dual", keyProperty = "notice_idx", before = true, resultType = int.class)
	
	@Insert("insert into notice_table "
			+ "(notice_idx, notice_title, notice_content, notice_date) "
			+ "values (notice_seq.nextval, #{notice_title}, #{notice_content}, sysdate)")
	void addNoticeInfo(NoticeBean writeNoticeBean);
	
	@Select("select notice_idx, notice_title, to_char(notice_date, 'YYYY-MM-DD') as notice_date "
			+ "from notice_table "
			+ "order by notice_idx desc")
	List<NoticeBean> getNoticeList(NoticeBean noticeBean);
	
	@Select("select a1.notice_idx, a2.admin_name as notice_writer, to_char(a1.notice_date, 'YYYY-MM-DD') as notice_date, a1.notice_title, a1.notice_content "
			+ "from notice_table a1, admin_table a2 "
			+ "where a1.notice_idx = #{notice_idx}")
	NoticeBean getReadNotice(int notice_idx);
	
	@Delete("delete from notice_table "
			+ "where notice_idx=#{notice_idx} ")
	void deleteNotice(NoticeBean deleteNoticeBean);
}
