package com.ugm.user.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.sql.Timestamp;

import com.ugm.user.domain.User;
import com.ugm.user.domain.UserInner;
import com.ugm.user.domain.UserNews;
import com.ugm.user.service.UserService;

public interface UserMapper {	
	//修改密码
	@Update("update ugm_user set userpass = #{newpass} "
			+ "where username = #{username} and userpass = #{oldpass}")
	int changePassword(@Param("username")String username,
			@Param("oldpass")String oldpass, @Param("newpass")String newpass);
	
	//检查登录密码是否正确
	@Select("select * from ugm_user where username = #{loginname} and userpass = #{loginpass}")
	User loginCheckIsRightName
	(@Param("loginname") String loginname, @Param("loginpass") String loginpass);
	
	//检查登录是否符合角色
	@Select("select * from ugm_user where username = #{loginname} and is_manager =#{loginrole}")
	User loginCheckIsRightRole
	(@Param("loginname") String loginname, @Param("loginrole") String loginrole);
	
	//检查登录是否已被删除
	@Select("select * from ugm_user where username = #{loginname} and userpass = #{loginpass} "
			+ "and is_manager = #{loginrole} and is_deleted = 1 ")
	User loginCheckIsRightDeleted
	(@Param("loginname") String loginname, @Param("loginpass") String loginpass,
	 @Param("loginrole") String loginrole);

	//检查注册是否本校学工号
	@Select("select * from ugm_user_inner where usercode = #{registername} ")
	UserInner checkIsInner(@Param("registername") String registername);
	
	//检查注册是否已被注册
	@Select("select * from ugm_user where username = #{registername} ")
	User checkIsRegistered(@Param("registername") String registername);
	
	//注册
	@Insert("insert into ugm_user (username,userpass)value(#{registername},#{registerpass1})")
	int register(@Param("registername")String registername, 
			     @Param("registerpass1")String registerpass1);

	//读取个人信息
	@Select("select * from ugm_user_inner where usercode = #{loginname} ")
	UserInner userInfo(@Param("loginname") String loginname);

	//获取所有可见公告
	@Select("select * from ugm_user_news where news_isdeleted = 0 order by news_date desc")
	List<UserNews> userNewsCount();
	//获取所有公告
	@Select("select * from ugm_user_news order by news_date desc")
	List<UserNews> userNews();

	//获取所有用户
	@Select("select * from ugm_user where is_deleted =0 ")
	List<User> userAll();
	@Select("select * from ugm_user where is_deleted =1 ")
	List<User> userAllDelete();
	@Select("select * from ugm_user order by userright desc")
	List<User> userAllRight();

	//修改用户的登录许可状态
	@Update("update ugm_user set is_deleted = 1 where username = #{usercode} ")
	int userDelete(@Param("usercode")String usercode);
	@Update("update ugm_user set is_deleted = 0 where username = #{usercode} ")
	int userRecovery(String userCode);
	
	//修改用户的权限
	@Update("update ugm_user set userright = #{roleAfter},is_manager =1 where username = #{userCode} ")
	int userRight(@Param("userCode")String userCode, 
			      @Param("roleAfter")String roleAfter);
	@Update("update ugm_user set userright = #{roleAfter},is_manager =0 where username = #{userCode} ")
	int userRightZero(@Param("userCode")String userCode, 
			          @Param("roleAfter")String roleAfter);

	//发送公告
	@Insert("insert into ugm_user_news(news_title ,news_content ,news_writer, news_date)" + 
			"value( #{newsTitle}, #{newsContent}, #{newsWriter}, #{newsDate})")
	int newsAdd(@Param("newsTitle")String newsTitle, 
			@Param("newsContent")String newsContent,
			@Param("newsWriter")String newsWriter,
			@Param("newsDate")Timestamp newsDate);

	//修改公告状态
	@Update("update ugm_user_news set news_isdeleted = 1 where news_id=#{newsID}")
	int newsChangeToDeleted(@Param("newsID")int newsID);
	@Update("update ugm_user_news set news_isdeleted = 0 where news_id=#{newsID}")
	int newsChangeToNoDeleted(@Param("newsID")int newsID);

}
