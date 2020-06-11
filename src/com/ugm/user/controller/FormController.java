package com.ugm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 */
@Controller
public class FormController {
	//网站URL
	//功能名
	//文件位置
	
	//用户-二级界面-场地管理
	@RequestMapping(value = "/users_area/site")
	public String users_area_a() {          
		return "users/users_area/site";        
	}

	//用户-二级界面-器材管理
	@RequestMapping(value = "/users_equi/back")
	public String users_equi_back() {          
		return "users/users_equi/back";        
	}
	@RequestMapping(value = "/users_equi/book")
	public String users_equi_book() {          
		return "users/users_equi/book";        
	}
	@RequestMapping(value = "/users_equi/find")
	public String users_equi_find() {          
		return "users/users_equi/find";        
	}
	@RequestMapping(value = "/users_equi/lend")
	public String users_equi_lend() {          
		return "users/users_equi/lend";        
	}

	//用户-二级界面-赛事管理
	@RequestMapping(value = "/users_comp/change")
	public String users_comp_change() {          
		return "users/users_comp/change";        
	}
	@RequestMapping(value = "/users_comp/add")
	public String users_comp_add() {          
		return "users/users_comp/add";        
	}
	@RequestMapping(value = "/users_comp/delete")
	public String users_comp_delete() {          
		return "users/users_comp/delete";        
	}
	@RequestMapping(value = "/users_comp/find")
	public String users_comp_find() {          
		return "users/users_comp/find";        
	}
	
	//用户-二级界面-用户管理
	@RequestMapping(value = "/users_user/change")
	public String users_user_change() {          
		return "users/users_user/change";        
	}
	@RequestMapping(value = {"/users_user/news",
			"/users_user/pageLast","/users_user/pageNext"})
	public String users_user_news() {
		return "users/users_user/news";
	}
	@RequestMapping(value = "/users_user/info")
	public String users_user_info() {
		return "users/users_user/info";
	}

	//用户一级界面
	@RequestMapping(value = "/users_user")
	public String users_user() {
		return "users/users_user";
	}
	@RequestMapping(value = "/users_comp")
	public String users_comp() {
		return "users/users_comp";
	}
	@RequestMapping(value = "/users_equi")
	public String users_equi() {
		return "users/users_equi";
	}
	@RequestMapping(value = "/users_area")
	public String users_area() {
		return "users/users_area";
	}
	
	//管理员-二级界面-场地管理
	@RequestMapping(value = "/admin_area/a")
	public String admin_area_a() {          
		return "admin/admin_area/a";        
	}
	@RequestMapping(value = "/admin_area/b")
	public String admin_area_b() {          
		return "admin/admin_area/b";        
	}
	@RequestMapping(value = "/admin_area/c")
	public String admin_area_c() {          
		return "admin/admin_area/c";        
	}
	//管理员-二级界面-赛事管理
	@RequestMapping(value = "/admin_comp/add")
	public String admin_comp_add() {
		return "admin/admin_comp/add";
	}
	@RequestMapping(value = "/admin_comp/check")
	public String admin_comp_check() {
		return "admin/admin_comp/check";
	}
	@RequestMapping(value = "/admin_comp/delete")
	public String admin_comp_delete() {
		return "admin/admin_comp/delete";
	}
	@RequestMapping(value = "/admin_comp/find")
	public String admin_comp_find() {
		return "admin/admin_comp/find";
	}
	
	//管理员-二级界面-器材管理
	@RequestMapping(value = "/admin_equi/add")
	public String admin_equi_add() {
		return "admin/admin_equi/add";
	}
	@RequestMapping(value = "/admin_equi/change")
	public String admin_equi_change() {
		return "admin/admin_equi/change";
	}
	@RequestMapping(value = "/admin_equi/delete")
	public String admin_equi_delete() {
		return "admin/admin_equi/delete";
	}
	@RequestMapping(value = "/admin_equi/find")
	public String admin_equi_find() {
		return "admin/admin_equi/find";
	}
	@RequestMapping(value = "/admin_equi/fix")
	public String admin_equi_fix() {
		return "admin/admin_equi/fix";
	}

	//管理员-二级界面-用户管理
	@RequestMapping(value = "/admin_user/info")
	public String admin_user_info() {
		return "admin/admin_user/info";
	}
	@RequestMapping(value = "/admin_user/delete")
	public String admin_user_delete() {
		return "admin/admin_user/delete";
	}
	@RequestMapping(value = "/admin_user/news")
	public String admin_user_news() {
		return "admin/admin_user/news";
	}
	@RequestMapping(value = "/admin_user/recovery")
	public String admin_user_recovery() {
		return "admin/admin_user/recovery";
	}
	@RequestMapping(value = "/admin_user/right")
	public String admin_user_right() {
		return "admin/admin_user/right";
	}
	
	//管理员一级界面
	@RequestMapping(value = "/admin_user")
	public String admin_user() {
		return "admin/admin_user";
	}
	@RequestMapping(value = "/admin_comp")
	public String admin_comp() {
		return "admin/admin_comp";
	}
	@RequestMapping(value = "/admin_equi")
	public String admin_equi() {
		return "admin/admin_equi";
	}
	@RequestMapping(value = "/admin_area")
	public String admin_area() {
		return "admin/admin_area";
	}

	// 跳转至首页
	@RequestMapping(value = {"/index", "/login", "/register" })
	public String index0() {
		return "index";
	}

	// 登出重定向中转页面
	@RequestMapping(value = {"/logout","users_user/updatePassword"})
	public String logout() {
		return "logout";
	}
}
