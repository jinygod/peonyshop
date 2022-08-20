package service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import beans.GoodsBean;
import beans.UserBean;
import dao.GoodsDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class GoodsService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	
	// 중복된 파일이 들어오면 덮어씌워지지 않게함 (등록시간으로 구분가능하게 함)
	private String saveUploadFile(MultipartFile upload_thumbnail) {
		
		String goods_name = System.currentTimeMillis() + "_" + upload_thumbnail.getOriginalFilename();
		
		try {
			upload_thumbnail.transferTo(new File(path_upload + "/" + goods_name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return goods_name;
	}
	
	public void addGoodsInfo(GoodsBean goodsRegBean) {
		
		
		MultipartFile upload_thumbnail = goodsRegBean.getUpload_thumbnail();
		
		if(upload_thumbnail.getSize() > 0) {
			String goods_name = saveUploadFile(upload_thumbnail);
			goodsRegBean.setGoods_thumbnail(goods_name);
		}
		
		goodsDao.addGoodsInfo(goodsRegBean);
		
	}
	
	public List<GoodsBean> getGoodsList(String topmenu_name) {
		return goodsDao.getGoodsList(topmenu_name);
	}
		
	public GoodsBean getGoodsDetail(String goods_idx) {
		return goodsDao.getGoodsDetail(goods_idx);
	}
	
	public List<GoodsBean> getAdminGoodsList(){
		return goodsDao.getAdminGoodsList();
	}
	
	public GoodsBean getModifyGoodsInfo(String goods_idx) {
		return goodsDao.getModifyGoodsInfo(goods_idx);
	}
	
	public void deleteGoods(String goods_idx) {
		goodsDao.deleteGoods(goods_idx);
	}
}
