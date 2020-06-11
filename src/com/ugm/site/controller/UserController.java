package com.ugm.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.site.po.SiteDetail;
import com.ugm.site.po.SiteOrder;
import com.ugm.site.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("userIndex")
	public ModelAndView queryIndex() throws Exception {
		ModelAndView modelandview=new ModelAndView();
		List<SiteDetail> list=service.selectall();
		modelandview.addObject("list",list);
		modelandview.setViewName("userIndex");
		return modelandview;
	}
	
	@RequestMapping("likequery")
	public ModelAndView queryuse(String book,String name) throws Exception{
		System.out.println(book);
		System.out.println(name);
		int i;
		if(book.equals("ÊÇ")) {
			i=1;
		}else {
			i=0;
		}
		ModelAndView model=new ModelAndView();
		List<SiteDetail>list=service.selectbyuser(i,name);
		model.addObject("list",list);
		model.setViewName("userIndex");
		return model;
		
	}
	
	@RequestMapping("book")
	public ModelAndView book(int id) throws Exception {
		ModelAndView model=new ModelAndView();
		List<SiteOrder> list=service.userquery(id);
		model.addObject("list",list);
		model.setViewName("book");
		return model;
		
	}
	
	@RequestMapping("insertorder")
	public String insertorder (int id,String starttime,String endtime) throws Exception {
		service.insertorder(id,starttime,endtime);
		return "redirect:userIndex";
	}
	
	
	@RequestMapping("myorder")
	public ModelAndView myorder() throws Exception {
		ModelAndView model=new ModelAndView();
		List<SiteOrder> list=service.orderall();
		model.addObject("list",list);
		model.setViewName("myorder");
		return model;	
	}
	
	

}
