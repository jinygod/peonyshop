package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import beans.TopMenuBean;

public interface TopMenuMapper {

	@Select("select topmenu_idx, topmenu_name "
			+ "from topmenu_table "
			+ "order by topmenu_idx")
	List<TopMenuBean> getTopMenuList();
}
