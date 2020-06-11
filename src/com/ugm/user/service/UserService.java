package com.ugm.user.service;
import java.sql.Timestamp;
import java.util.List;
import com.ugm.user.domain.User;
import com.ugm.user.domain.UserInner;
import com.ugm.user.domain.UserNews;
import com.ugm.user.service.UserService;
public interface UserService {	
	//修改密码
	int changePass(String username, String oldpass, String newpass);
	
	//检查登录密码是否正确
	User login(String loginname, String loginpass);

	//检查登录是否符合角色
	User loginRole(String loginname, String loginrole);

	//检查登录是否已被删除
	User loginDeleted(String loginname, String loginpass, String loginrole);

	//检查注册是否本校学工号
	UserInner registerCheckIsInner(String registername);

	//检查注册是否已被注册
	User registerCheckIsRegistered(String registername);

	//注册
	int register(String registername, String registerpass1);

	//读取个人信息
	UserInner userInfo(String loginname);

	//获取所有可见公告
	List<UserNews> userNewsCount();
	//获取所有公告
	List<UserNews> userNews();
	
	//获取所有用户
	List<User> userAll();
	List<User> userAllDelete();
	List<User> userAllRight();
	
	//修改用户的登录许可状态
	int userDelete(String userCode);
	int userRecovery(String userCode);
	
	//修改用户的权限
	int userRight(String userCode, String roleAfter);
	int userRightZero(String userCode, String roleAfter);
	
	//发送公告
	int newsAdd(String newsTitle, String newsContent, String newsWriter, Timestamp newsDate);

	//修改公告状态
	int newsChangeToDeleted(int newsID);
	int newsChangeToNoDeleted(int newsID);

}
