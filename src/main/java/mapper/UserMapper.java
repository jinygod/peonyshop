package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.UserBean;

public interface UserMapper {

	// 회원가입시 유저아이디 중복확인
	@Select("select user_name "+
			"from user_table " +
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
	@Insert("insert into user_table (user_idx, user_id, user_pw, user_name, user_birth, " +
			"user_email, user_phone, user_zipcode, user_addr1, user_addr2 ) " +
			"values (user_seq.nextval, #{user_id}, #{user_pw}, #{user_name}, #{user_birth}, " +
			"#{user_email}, #{user_phone}, #{user_zipcode}, #{user_addr1}, #{user_addr2})")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("select user_idx, user_name, user_birth, user_phone, user_email, user_zipcode, user_addr1, user_addr2 " + 
			"from user_table " + 
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	@Select("select user_id, user_name, user_birth, user_email, "
			+ "user_phone, user_zipcode, user_addr1, user_addr2 "
			+ "from user_table "
			+ "where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(String user_idx);
	
	@Update("update user_table " +
			"set user_pw = #{user_pw}, user_email = #{user_email}, user_phone = #{user_phone} " +
			"user_zipcode = #{user_zipcode}, user_addr1 = #{user_addr1}, user_addr2 = #{user_addr2} " + 
			"where user_idx = #{user_idx}")
	void modifyUserInfo(UserBean modifyUserBean);
}
