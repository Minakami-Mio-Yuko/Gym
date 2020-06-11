package com.ugm.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.site.po.SiteDetail;
import com.ugm.site.service.AdminService;

@Controller
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping("queryIndex")
	public ModelAndView queryIndex() throws Exception {
		ModelAndView modelandview=new ModelAndView();
		List<SiteDetail> list=service.selectall();
		modelandview.addObject("list",list);
		modelandview.setViewName("success");
		return modelandview;
	}
	
	@RequestMapping("likequery")
	public ModelAndView likequery(String position,String name) throws Exception {
		ModelAndView modelandview=new ModelAndView();
		List<SiteDetail> list=service.selectbyindex(position,name);
		modelandview.addObject("list",list);
		modelandview.setViewName("success");
		System.out.println(name);
		System.out.println(position);
		return modelandview;
	}
	
	@RequestMapping("newone")
	public String newone() {
		return "newone";		
	}
	
	@RequestMapping("newsub")
	public String newsub(SiteDetail detail) throws Exception {
		service.insertsite(detail);
		return "redirect:queryIndex";
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(int id) throws Exception {
		ModelAndView modelandview=new ModelAndView();
		SiteDetail detail=service.selectbyid(id);
		modelandview.addObject("detail",detail);
		modelandview.setViewName("edit");
		return modelandview;
	}

	
	@RequestMapping("editsub")
	public String editsub(SiteDetail detail) throws Exception {
		System.out.println(detail.getSiteId());
		service.edit(detail);
		return "redirect:queryIndex";
	}
	
	@RequestMapping("delete")
	public String deleteone(int id)throws Exception{
		service.deleteone(id);
		return "redirect:queryIndex";
	}

}
