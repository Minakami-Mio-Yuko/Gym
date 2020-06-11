package com.ugm.equipmentmanager.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Maintenance;
import com.ugm.equipmentmanager.service.EquipmentService;
import com.ugm.equipmentmanager.service.MaintenanceService;


// 锟斤拷锟斤拷员锟斤拷息锟斤拷锟斤拷

@RequestMapping("/admin_equi")
@Controller
public class MaintenanceController {
	@Autowired
	private MaintenanceService maintenanceService;
	
	
	@RequestMapping(value = "/fix",method=RequestMethod.GET)
	public ModelAndView maiQuery(ModelAndView model){
		model.setViewName("admin/admin_equi/fix");
		return model;
	}
	

	@RequestMapping(value="admin_equi/mai_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintenanceQuery(HttpServletRequest request){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Equipment>list=maintenanceService.maiQuery();
		ret.put("list", list);
		return ret;
	}
	
	@RequestMapping(value="admin_equi/fix",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintenance(HttpServletRequest request,Integer[]equId,Maintenance maintenance){
		Map<String, Object> ret = new HashMap<String, Object>();
		maintenanceService.maintenanceList(equId, maintenance);
		return ret;
	}
	
	@RequestMapping(value="admin_equi/maintenancing_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintenancingQuery(HttpServletRequest request){
		Map<String, Object> ret=maintenanceService.maintenancingQuery();

		return ret;
	}
	
	@RequestMapping(value="admin_equi/maintenancing_complete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> maintenancingComplete(HttpServletRequest request,Integer[]maiId){
		Map<String, Object> ret=new HashMap<String,Object>();
		maintenanceService.maintenanceComplete(maiId);
		return ret;
	}
}

