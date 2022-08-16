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
		
//		System.out.println(tempLoginUserBean2.getUser_idx());
//		System.out.println(tempLoginUserBean2.getUser_name()); //-> tempLoginUserBean2를 Controller에서 출력하는 방법 (안넘어감)
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
			
		}
	
	}
}
