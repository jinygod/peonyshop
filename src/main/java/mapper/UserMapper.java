package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import beans.UserBean;

public interface UserMapper {

	@Insert("insert into user_table (user_idx, user_id, user_pw, user_name, user_birth, " +
			"user_email, user_phone, user_zipcode, user_addr1, user_addr2 ) " +
			"values (user_seq.nextval, #{user_id}, #{user_pw}, #{user_name}, #{user_birth}, " +
			"#{user_email}, #{user_phone}, #{user_zipcode}, #{user_addr1}, #{user_addr2})")
	void addUserInfo(UserBean joinUserBean);
	
	@Select("select user_idx, user_name " + 
			"from user_table " + 
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
}
