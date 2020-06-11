package com.ugm.user.controller;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ugm.user.domain.User;
import com.ugm.user.domain.UserInner;
import com.ugm.user.domain.UserNews;
import com.ugm.user.md5.MD5;
import com.ugm.user.service.UserService;


@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//修改公告状态并刷新页面
	@PostMapping(value = "admin_user/newsChange")
	public ModelAndView newsChange(int newsID,String newsDelete,
			ModelAndView mv,HttpSession session) {
		if(newsDelete.equals("已删除仅管理员可见")) {
			int newsChangeToNoDeleted = userService.newsChangeToNoDeleted(newsID);
			refreshNews(session);
			if(newsChangeToNoDeleted>0) {
				mv.setView(new RedirectView("../admin_user/news"));	
				session.setAttribute("messageUserNewsAdd", "恢复成功");
			}
			else {
				session.setAttribute("messageUserNewsAdd","恢复失败");
			}
		}
		else {
			int newsChangeToDeleted = userService.newsChangeToDeleted(newsID);
			refreshNews(session);
			if(newsChangeToDeleted>0) {
				mv.setView(new RedirectView("../admin_user/news"));	
				session.setAttribute("messageUserNewsAdd", "删除成功");
			}
			else {
				session.setAttribute("messageUserNewsAdd", "删除失败");
			}
		}		
		return mv;
	}
	//写公告并刷新页面
	@PostMapping(value = "admin_user/newsAdd")
	public ModelAndView newsAdd(String newsTitle,String newsContent,
			String newsWriter,String newsDate,
			ModelAndView mv,HttpSession session) {
		Timestamp nd = Timestamp.valueOf(newsDate);  
		if(newsTitle.equals("")||newsContent.equals("")) {
			mv.setView(new RedirectView("../admin_user/news"));	
			session.setAttribute("messageUserNewsAdd", "不能有空的输入");
		}
		else {
			int newsAdd = userService.newsAdd(newsTitle,newsContent,newsWriter,nd);
			if(newsAdd>0) {
				session.setAttribute("messageUserNewsAdd", "发送成功");
				refreshNews(session);	
				mv.setView(new RedirectView("../admin_user/news"));	
			}
		}
		return mv;		
	}
	//权限管理
	@PostMapping(value = "admin_user/userRight")
	public ModelAndView userRight(String userRoleU,String userRoleC,
			String userRoleE,String userRoleA,String userCode,
			ModelAndView mv,HttpSession session) {		
		StringBuilder role_primary =new StringBuilder("0000");
		String role = userRoleU+userRoleC+userRoleE+userRoleA;
		for(int i=0;i<4;i++) {
			if(role.contains((i+1)+"")) {
				role_primary.replace(i,i+1,"1");
			}
		}
		String roleAfter = role_primary.toString();
		if(roleAfter.equals("0000")) {
			int userRightZero = userService.userRightZero(userCode,roleAfter);
			if(userRightZero>0) {			
				refresh(session);	
				mv.setView(new RedirectView("../admin_user/right"));	
				session.setAttribute("messageUserRight", userCode+"降为普通用户");
			}
			else {
				session.setAttribute("messageUserRight", "相同的修改");
			}
		}
		else {
			int userRight = userService.userRight(userCode,roleAfter);
			if(userRight>0) {			
				refresh(session);	
				mv.setView(new RedirectView("../admin_user/right"));	
				session.setAttribute("messageUserRight", userCode+"改为"+getRole(roleAfter));
			}
			else {	
				session.setAttribute("messageUserRight", "相同的修改");
			}
		}

		return mv;
	}	
	//恢复账号（使之可以登录）
	@PostMapping(value = "admin_user/userRecovery")
	public ModelAndView userRecovery(String userCode,
			ModelAndView mv,HttpSession session) {
		int userRecovery = userService.userRecovery(userCode);
		if(userRecovery>0) {			
			refreshUser(session);					
			mv.setView(new RedirectView("../admin_user/recovery"));		
			session.setAttribute("messageUserRecovery", userCode+"被恢复，可以登陆");
		}
		else {
			session.setAttribute("messageUserRecovery", "恢复失败");
		}
		return mv;
	}
	//删除账号（使之不能登录）
	@PostMapping(value = "admin_user/userDelete")
	public ModelAndView userDelete(String userCode,
			ModelAndView mv,HttpSession session) {
		
		int userDelete = userService.userDelete(userCode);		
		if(userDelete>0) {			
			refreshUser(session);			
			mv.setView(new RedirectView("../admin_user/delete"));
			session.setAttribute("messageUserDelete", userCode+"被删除，将无法登陆");
		}
		else {
			session.setAttribute("messageUserDelete", "删除失败");
		}
		return mv;
	}
	//删除或恢复后刷新session
	public void refreshUser(HttpSession session) {
		List<User> userAll = userService.userAll();
		getUsers(userAll,session);
		session.setAttribute("userCount", userAll.size());	
		
		List<User> userAllDelete = userService.userAllDelete();
		getUsersDeleted(userAllDelete,session);
		session.setAttribute("userCountR", userAllDelete.size());
		refreshTips (session);
	}	
	//修改权限后刷新session
	public void refresh(HttpSession session) {
		List<User> userAllRight = userService.userAllRight();
		getUsersRight(userAllRight,session);
		session.setAttribute("userCountRR", userAllRight.size());
		refreshTips (session);
	}
	//发布公告后刷新session
	public void refreshNews(HttpSession session) {
		List<UserNews>  userNewsAll   = userService.userNews();
		getNewsAll(userNewsAll,session);
		refreshTips (session);
	}
	//初始化所有红字提示
	public void refreshTips (HttpSession session) {
		session.setAttribute("messageUserRight", " ");
		session.setAttribute("messageUserDelete", " ");
		session.setAttribute("messageUserRecovery", " ");
		session.setAttribute("messageUserNewsAdd", " ");
	}
	//更改密码
	@PostMapping(value = "users_user/updatePassword")
	public ModelAndView updatePassword(String currentpassword, 
			String newpassword1,String newpassword2, 
			ModelAndView mv,HttpSession session) {
		
		String currentusername =(String) session.getAttribute("username");
		User user = userService.login(currentusername, currentpassword);		
		if(currentpassword.equals("")||newpassword1.equals("")||newpassword2.equals("")) {
			mv.setViewName("users/users_user/change");
			mv.addObject("messageChangePassword", "三个输入值中有空值，请重新输入");
		}
		else if(!newpassword1.equals(newpassword2)){
			mv.setViewName("users/users_user/change");
			mv.addObject("messageChangePassword", "两次新密码不一致，请重新输入");
		}
		else if(user == null){
			mv.setViewName("users/users_user/change");
			mv.addObject("messageChangePassword", "旧密码错误，请重新输入");
		}
		else if (newpassword1.length() > 32) {
			mv.setViewName("users/users_user/change");
			mv.addObject("messageChangePassword", "新密码过长，请重新输入");
		} 
		else{
			int change = userService.changePass(currentusername,currentpassword, newpassword1);
			if(change>0) {
			session.invalidate();
			mv.addObject("messageLogin", "密码已修改，请重新登录");
			mv.setView(new RedirectView("../index"));
			}
			else if(change==0){
				mv.setViewName("users/users_user/change");
				mv.addObject("messageChangePassword", "新密码和旧密码相同，请重新输入");
			}
			else {
				mv.setViewName("users/users_user/change");
				mv.addObject("messageChangePassword", "数据库异常-修改密码失败,请留意官网公告或联系管理员");
			}
		}
		return mv;
	}

	//登录账号（包括读取个人信息和最新的五条公告）
	@PostMapping(value = "/login")
	public ModelAndView login(String loginname, String loginpass, String loginrole,
			ModelAndView mv,HttpSession session) {
		User user = userService.login(loginname, loginpass);
		User userRole = userService.loginRole(loginname, loginrole);
		User userDeleted = userService.loginDeleted(loginname, loginpass, loginrole);
		UserInner userInner  = userService.userInfo(loginname);			
		//显示部分密码
		String Upass = loginpass.substring(0,4);	
		for(int i=0;i<loginpass.length();i++) {
			Upass +="*";
		}
		
		//用户界面数据读取
		if(!(getRole(user.getUseRright()).equals("普通用户")) ){
			//所有未删除的账号
			List<User> userAll = userService.userAll();
			getUsers(userAll,session);
			session.setAttribute("userCount", userAll.size());
			//所有已删除的账号
			List<User> userAllDelete = userService.userAllDelete();
			getUsersDeleted(userAllDelete,session);
			session.setAttribute("userCountR", userAllDelete.size());
			//所有账号
			List<User> userAllRight = userService.userAllRight();
			getUsersRight(userAllRight,session);
			session.setAttribute("userCountRR", userAllRight.size());
			//所有公告
			List<UserNews>  userNewsAll   = userService.userNews();
			getNewsAll(userNewsAll,session);			
			session.setAttribute("newsCountAll", userNewsAll.size());
			
			refreshTips (session);
		}
		else {
			//读取所有可见公告
			List<UserNews>  userNews   = userService.userNewsCount();
			getNews(userNews,session);
			session.setAttribute("newsCount", userNews.size());
		}
		//页面提示、跳转
		getPage(user,loginname,loginpass,loginrole,userInner,
				Upass,userRole,userDeleted,mv,session);
		return mv;
	}
    //登录-读取角色字符串
	public String getRole(String roleCode) {	
		String Urole = ""; 
		String UrightTextUser[] = {"","用户-"};
		String UrightTextComp[] = {"","赛事-"};
		String UrightTextEqui[] = {"","器材-"};
		String UrightTextArea[] = {"","场地-"};
		String Uright[] = {
				roleCode.substring(0,1),
				roleCode.substring(1,2),
				roleCode.substring(2,3),
				roleCode.substring(3,4)
		};
		if(roleCode.equals("0000")){
			Urole +="普通用户";
		}
		else {
			Urole += UrightTextUser[Integer.parseInt(Uright[0])];
			Urole += UrightTextComp[Integer.parseInt(Uright[1])];
			Urole += UrightTextEqui[Integer.parseInt(Uright[2])];
			Urole += UrightTextArea[Integer.parseInt(Uright[3])];
			Urole += "管理员";
		}
		return Urole;
	}
	//保存个人信息到session
	public void getSession(String loginname, String loginpass,
			String loginrole,ModelAndView mv,HttpSession session,
			User user,UserInner userInner,String Upass) {
		if (loginrole.equals("0")) {				
			mv.setView(new RedirectView("/equipmentmanager/users_user"));			
			session.setAttribute("username", loginname);
			session.setAttribute("user", user);
			session.setAttribute("userRole", getRole(user.getUseRright()));
			session.setAttribute("userName", userInner.getUsername());
			session.setAttribute("userClass",userInner.getUserclass());
			session.setAttribute("userSex",  userInner.getUsersex());
			session.setAttribute("userHome", userInner.getUserhome());				
		} 
		else {
			mv.setView(new RedirectView("/equipmentmanager/admin_user"));
			session.setAttribute("username", loginname);
			session.setAttribute("user", user);
			session.setAttribute("userRole", getRole(user.getUseRright()));
			session.setAttribute("userName", userInner.getUsername());
			session.setAttribute("userClass",userInner.getUserclass());
			session.setAttribute("userSex",  userInner.getUsersex());
			session.setAttribute("userHome", userInner.getUserhome());	
		}
		
	}
	//保存已删除的账号信息
	public void getUsersDeleted(List<User> u,HttpSession session) {
		for(int i=0;i<u.size();i++) {
			session.setAttribute("userAll" + i + "codeR",u.get(i).getUserName());
			session.setAttribute("userAll" + i + "roleR",getRole(u.get(i).getUseRright()));	
		}
	}	
    //保存未删除的账号信息
	public void getUsers(List<User> u,HttpSession session) {
		for(int i=0;i<u.size();i++) {
			session.setAttribute("userAll" + i + "code",u.get(i).getUserName());
			session.setAttribute("userAll" + i + "role",getRole(u.get(i).getUseRright()));			
		}
	}
	//保存所有账号的权限信息
	public void getUsersRight(List<User> u, HttpSession session) {
		for (int i = 0; i < u.size(); i++) {
			session.setAttribute("userAll" + i + "codeRR", u.get(i).getUserName());
			session.setAttribute("userAll" + i + "roleRR", getRole(u.get(i).getUseRright()));
		}
	}
	//读取所有可见公告
	public void getNews(List<UserNews> un, HttpSession session) {
		for(int i=0;i<un.size();i++) {
			session.setAttribute("userNews" + i + "title", 
					un.get(i).getNewsTitle());
			session.setAttribute("userNews" + i + "content",
					un.get(i).getNewsContent());
			session.setAttribute("userNews" + i + "writer", 
					un.get(i).getNewsWriter());
			session.setAttribute("userNews" + i + "date",
					un.get(i).getNewsDate().toString());
		}
	}
	//读取所有公告
	public void getNewsAll(List<UserNews> un, HttpSession session) {
		for(int i=0;i<un.size();i++) {
			session.setAttribute("userNews" + i + "titleA", 
					un.get(i).getNewsTitle());
			session.setAttribute("userNews" + i + "contentA",
					un.get(i).getNewsContent());
			
			session.setAttribute("userNews" + i + "idA",
					un.get(i).getNewsId());
			if(un.get(i).getNewsIsdeleted()) {
				session.setAttribute("userNews" + i + "deleteA","已删除仅管理员可见");
			}
			else {
				session.setAttribute("userNews" + i + "deleteA","未删除-全部人可见");
			}			
		}
	}
	//页面跳转
	public void getPage(User user,String loginname,String loginpass,
			String loginrole,UserInner userInner,String Upass,User userRole,
			User userDeleted,ModelAndView mv,HttpSession session) {
		if (user == null) {
			mv.setViewName("index");
			mv.addObject("messageLogin", "账号不存在或密码错误，请重新输入");
		} 
		else if (userRole == null) {
			mv.setViewName("index");
			mv.addObject("messageLogin", "账号角色不匹配，请重新选择");
		} 
		else if (userDeleted != null) {
			mv.setViewName("index");
			mv.addObject("messageLogin", "账号已被删除，请联系管理员进行恢复");
		} 
		else {
			getSession(loginname, loginpass,loginrole,
				mv, session,user, userInner, Upass);			
		}
	}
	
	//注册账号
	@PostMapping(value = "/register")
	public ModelAndView register(String registername, String registerpass1, 
		String registerpass2,ModelAndView mv, HttpSession session) {
		UserInner userInner = userService.registerCheckIsInner(registername);
		User userAlready = userService.registerCheckIsRegistered(registername);
		if (userInner == null) {
			mv.setViewName("index");
			mv.addObject("messageRegister", "该账号不属于本校学工号，请重新输入");
		} else if (registerpass1.equals("") || registerpass2.equals("")) {
			mv.setViewName("index");
			mv.addObject("messageRegister", "密码不能为空");
		} else if (!registerpass1.equals(registerpass2)) {
			mv.setViewName("index");
			mv.addObject("messageRegister", "两次密码不一致，请重新输入");
		} else if (registerpass1.length() > 12) {
			mv.setViewName("index");
			mv.addObject("messageRegister", "密码过长，请重新输入");
		} else if (userAlready != null) {
			mv.setViewName("index");
			mv.addObject("messageRegister", "该学工号已被注册使用，请重新输入");
		} else {
			MD5 md5 = new MD5();
			String md5Password = md5.Encrypt_md5(registerpass1); 
			System.out.println(md5Password);
			int userRegister = userService.register(registername,md5Password);
			if(userRegister>0) {
				mv.setViewName("index");
				mv.addObject("messageRegisterSuccess", "账号" + registername + "注册成功");
			}
			else if(userRegister==0) {
				mv.setViewName("index");
				mv.addObject("messageRegister", "该学工号已被注册使用，请重新输入");
			}
			else {
				mv.setViewName("index");
				mv.addObject("messageChangePassword", "数据库异常-注册失败,请留意官网公告或联系管理员");
			}
		}
		return mv;
	}
}
