package service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.AdminBean;
import dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	@Resource(name = "loginAdminBean")
	private AdminBean loginAdminBean;

	public void getLoginAdminInfo(AdminBean tempLoginAdminBean) {
		AdminBean tempLoginAdminBean2 = adminDao.getLoginAdminInfo(tempLoginAdminBean);

		if (tempLoginAdminBean2 != null) {
			// loginAdminBean.setAdmin_code(tempLoginAdminBean2.getAdmin_code());
			loginAdminBean.setAdminLogin(true);
		}

	}

}
