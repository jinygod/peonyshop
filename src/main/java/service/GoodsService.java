package service;

<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import beans.GoodsBean;
=======
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
>>>>>>> Stashed changes
import dao.GoodsDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class GoodsService {

<<<<<<< Updated upstream
	@Autowired
	private GoodsDao goodsDao;
	
	
	
	public void addGoodsInfo(GoodsBean goodsRegBean) {
		
		goodsDao.addGoodsInfo(goodsRegBean);
		
	}
		
=======
	@Value("${path.upload}")
	private String path_upload;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	
	// 중복된 파일이 들어오면 덮어씌워지게함 (업로드되는 파일이름을 구함)
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
>>>>>>> Stashed changes
}
