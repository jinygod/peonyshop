package service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.UserBean;
import dao.UserDao;

@Service
public class UserService {
	

	
	@Autowired
	private UserDao userDao;

	public boolean checkUserIdExist(String user_id) {
		String user_name = userDao.checkUserIdExist(user_id);

		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUser_birth(tempLoginUserBean2.getUser_birth());
			loginUserBean.setUser_email(tempLoginUserBean2.getUser_email());
			loginUserBean.setUser_phone(tempLoginUserBean2.getUser_phone());
			loginUserBean.setUser_zipcode(tempLoginUserBean2.getUser_zipcode());
			loginUserBean.setUser_addr1(tempLoginUserBean2.getUser_addr1());
			loginUserBean.setUser_addr2(tempLoginUserBean2.getUser_addr2());
			loginUserBean.setUserLogin(true);
			
		}
	
	}
	
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(tempModifyUserBean.getUser_idx());
		modifyUserBean.setUser_birth(tempModifyUserBean.getUser_birth());
		modifyUserBean.setUser_email(tempModifyUserBean.getUser_email());
		modifyUserBean.setUser_phone(tempModifyUserBean.getUser_phone());
		modifyUserBean.setUser_zipcode(tempModifyUserBean.getUser_zipcode());
		modifyUserBean.setUser_addr1(tempModifyUserBean.getUser_addr1());
		modifyUserBean.setUser_addr2(tempModifyUserBean.getUser_addr2());
		
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		userDao.modifyUserInfo(modifyUserBean);
	}
}
