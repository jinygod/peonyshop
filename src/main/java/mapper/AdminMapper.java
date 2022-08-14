package mapper;

import org.apache.ibatis.annotations.Select;

import beans.AdminBean;


public interface AdminMapper {

	@Select("select admin_name " + 
			"from admin_table " + 
			"where admin_code = #{admin_code}")
	AdminBean getLoginAdminInfo(AdminBean tempLoginAdminBean);
	
}
