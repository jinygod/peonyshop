package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.TopMenuBean;
import dao.TopMenuDao;

@Service
public class TopMenuService {

	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<TopMenuBean> getTopMenuList() {
//		List<TopMenuBean> topMenuList = topMenuDao.getTopMenuList();
//		return topMenuList;
		return topMenuDao.getTopMenuList();
	}
}
