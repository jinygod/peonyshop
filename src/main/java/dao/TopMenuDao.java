package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.TopMenuBean;
import mapper.TopMenuMapper;

@Repository
public class TopMenuDao {

	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<TopMenuBean> getTopMenuList() {
		// List<TopMenuBean> topMenuList = topMenuMapper.getTopMenuList();
		//return topMenuList;
		return topMenuMapper.getTopMenuList();
	}
}
