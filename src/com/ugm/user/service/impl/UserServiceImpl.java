package com.ugm.user.service.impl;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ugm.user.domain.User;
import com.ugm.user.domain.UserInner;
import com.ugm.user.domain.UserNews;
import com.ugm.user.mapper.UserMapper;
import com.ugm.user.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	//修改密码
	@Transactional(readOnly = false)
	@Override
	public int changePass(String username, String oldpass,String newpass) {
		return userMapper.changePassword(username,oldpass,newpass);
	}	
	
	//检查登录密码是否正确
	@Transactional(readOnly = true)
	@Override
	public User login(String loginname, String loginpass) {
		return userMapper.loginCheckIsRightName(loginname, loginpass);
	}
	
	//检查登录是否符合角色
	@Transactional(readOnly = true)
	@Override
	public User loginRole(String loginname, String loginrole) {
		return userMapper.loginCheckIsRightRole(loginname, loginrole);
	}
	
	//检查登录是否已被删除
	@Transactional(readOnly = true)
	@Override
	public User loginDeleted(String loginname, String loginpass,String loginrole) {
		return userMapper.loginCheckIsRightDeleted(loginname, loginpass, loginrole);
	}
	
	//检查注册是否本校学工号
	@Transactional(readOnly = true)
	@Override
	public UserInner registerCheckIsInner(String registername) {
		return userMapper.checkIsInner(registername);
	}
	
	//检查注册是否已被注册
	@Transactional(readOnly = true)
	@Override
	public User registerCheckIsRegistered(String registername) {
		return userMapper.checkIsRegistered(registername);
	}

	//注册
	@Transactional(readOnly = false)
	@Override
	public int register(String registername, String registerpass1) {
		return userMapper.register(registername,registerpass1);
	}
	//读取个人信息
	@Transactional(readOnly = true)
	@Override
	public UserInner userInfo(String loginname) {
		return userMapper.userInfo(loginname);
	}
	
	//获取所有可见公告
	@Override
	public List<UserNews> userNewsCount() {
		return userMapper.userNewsCount();
	}
	//获取所有公告
	@Override
	public List<UserNews> userNews() {
		return userMapper.userNews();
	}

	//获取所有用户
	@Override
	public List<User> userAll() {
		return userMapper.userAll();
	}
	//获取所有已被删除的用户
	@Override
	public List<User> userAllDelete() {
		return userMapper.userAllDelete();
	}
	@Override
	public List<User> userAllRight() {
		return userMapper.userAllRight();
	}

	//修改用户的登录许可状态
	@Override
	public int userDelete(String userCode) {
		return userMapper.userDelete(userCode);
	}
	@Override
	public int userRecovery(String userCode) {
		return userMapper.userRecovery(userCode);
	}
	
	//修改用户的权限	
	@Override
	public int userRight(String userCode, String roleAfter) {
		return userMapper.userRight(userCode,roleAfter);
	}
	@Override
	public int userRightZero(String userCode, String roleAfter) {
		return userMapper.userRightZero(userCode,roleAfter);
	}

	@Override
	public int newsAdd(String newsTitle, String newsContent, String newsWriter, Timestamp newsDate) {
		return userMapper.newsAdd(newsTitle, newsContent,newsWriter,newsDate);
	}

	//修改公告状态
	@Override
	public int newsChangeToDeleted(int newsID) {
		return userMapper.newsChangeToDeleted(newsID) ;
	}
	@Override
	public int newsChangeToNoDeleted(int newsID) {
		return userMapper.newsChangeToNoDeleted(newsID);
	}
}
