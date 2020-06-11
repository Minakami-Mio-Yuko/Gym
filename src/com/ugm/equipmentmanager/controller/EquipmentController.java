package com.ugm.equipmentmanager.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.service.EquipmentService;

/**
 * 器材管理控制层
 *
 */
@RequestMapping("/admin_equi")
@Controller
public class EquipmentController {
	@Autowired
	private EquipmentService equipmentService;
	
	@RequestMapping(value = "/test",method=RequestMethod.GET)
	public ModelAndView equQuery(ModelAndView model){
		model.setViewName("qcgl/test");
		return model;
	}
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public ModelAndView equNew(ModelAndView model){
		model.setViewName("admin/admin_equi/add");
		return model;
	}
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public ModelAndView equDelete(ModelAndView model){
		model.setViewName("admin/admin_equi/delete");
		return model;
	}
	@RequestMapping(value = "/change",method=RequestMethod.GET)
	public ModelAndView equUpdate(ModelAndView model){
		model.setViewName("admin/admin_equi/change");
		return model;
	}
	
	/**
	 * 根据id查询器材
	 *
	 */
	@RequestMapping(value="/equ_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryEquipment(HttpServletRequest request,Integer equId){
		Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("equipment", equipmentService.findByEquID(equId));
        System.out.println(equId);
		return ret;
	}
	
	
	/**
	 * 添加器材
	 *
	 */
	@RequestMapping(value="admin_equi/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> newEquipment(HttpServletRequest request,Equipment equipment,int newQuantity){
		Map<String, Object> ret = new HashMap<String, Object>();
		equipmentService.newEqu(equipment,newQuantity);
        System.out.println(equipment);
		return ret;
	}
	
	/**
	 * 删除器材
	 *
	 */
	@RequestMapping(value="admin_equi/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteEquipment(HttpServletRequest request,Integer[] equId,String choseType){
		Map<String, Object> ret = new HashMap<String, Object>();
		equipmentService.deleteEqu(equId,choseType);
        System.out.println(equId);
		ret.put("success", "success");
		return ret;
	}
	
	/**
	 * 查找未删除的所有器材
	 *
	 */
	@RequestMapping(value="admin_equi/equ_undelete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryUndeleteEquipment(HttpServletRequest request,Equipment equipment){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Equipment>list=equipmentService.findUndelete();
		ret.put("list", list);
		System.out.println(list);
		return ret;
	}
	
	/**
	 * 查找未删除的所有器材并按名称分组
	 *
	 */
	@RequestMapping(value="admin_equi/equ_undelete_group",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryUndeleteGroup(HttpServletRequest request,Equipment equipment){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Equipment>list=equipmentService.findUndeleteGroup();
		ret.put("list", list);
		ret.put("s", "1");
		System.out.println(list);
		return ret;
	}
	
	/**
	 * 查找已删除的所有器材
	 *
	 */
	@RequestMapping(value="admin_equi/equ_had_delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> querydeleteEquipment(HttpServletRequest request,Equipment equipment){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Equipment>list=equipmentService.findHaddelete();
		ret.put("list", list);
		System.out.println(list);
		return ret;
	}
	
	/**
	 * 更新器材
	 *
	 */
	@RequestMapping(value="admin_equi/change",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateEquipment(HttpServletRequest request,Integer[] equId,BigDecimal[] maintenancePrice,
			                                   BigDecimal[] buyPrice,int[]brokenCondition){
		Map<String, Object> ret = new HashMap<String, Object>();
		equipmentService.updateEqu(equId,maintenancePrice,buyPrice,brokenCondition);
		return ret;
	} 

	/**
	 * 更新器材组
	 *
	 */
	@RequestMapping(value="admin_equi/equ_update_group",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateEquipmentGroup(HttpServletRequest request,String[] equName,BigDecimal[] reservationPrice,
			BigDecimal[] rentPrice){
		Map<String, Object> ret = new HashMap<String, Object>();
		equipmentService.updateEquGroup(equName,reservationPrice,rentPrice);
		return ret;
	}
}

