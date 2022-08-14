package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.AdminBean;
import mapper.AdminMapper;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public AdminBean getLoginAdminInfo(AdminBean tempLoginAdminBean) {
		return adminMapper.getLoginAdminInfo(tempLoginAdminBean);
	}
}
