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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Order;
import com.ugm.equipmentmanager.service.EquipmentService;
import com.ugm.equipmentmanager.service.OrderService;


// 锟斤拷锟斤拷员锟斤拷息锟斤拷锟斤拷

@RequestMapping(value= {"/users_equi","/admin_equi"})
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value = "/book",method=RequestMethod.GET)
	public ModelAndView resQuery(ModelAndView model){
		model.setViewName("users/users_equi/book");
		return model;
	}
	@RequestMapping(value = "/lend",method=RequestMethod.GET)
	public ModelAndView rentQuery(ModelAndView model){
		model.setViewName("users/users_equi/lend");
		return model;
	}
	@RequestMapping(value = "/back",method=RequestMethod.GET)
	public ModelAndView returnQuery(ModelAndView model){
		model.setViewName("users/users_equi/back");
		return model;
	}
	
	@RequestMapping(value = "/order",method=RequestMethod.GET)
	public ModelAndView orderList(ModelAndView model){
		model.setViewName("users/users_equi/order");
		return model;
	}
	
	@RequestMapping(value = "/find",method=RequestMethod.GET)
	public ModelAndView equApproval(ModelAndView model){
		model.setViewName("/admin/admin_equi/find");
		return model;
	}
	
	

	//查询可预约器材
	@RequestMapping(value="/users_equi/res_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryEquipment(HttpServletRequest request,String date,String time){
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Equipment>list=orderService.resQuery(date,time);
		ret.put("list", list);
		return ret;
	}
	
	//预约器材
	@RequestMapping(value="/users_equi/book",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> reservation(HttpServletRequest request,String[]equName,BigDecimal resCost,int[]quantity,
			                               String date,String time,BigDecimal rentTotalPrice){
		Map<String, Object> ret = new HashMap<String, Object>();
		if(orderService.orderResList(equName, resCost, quantity, date, time,rentTotalPrice)==1) {
			ret.put("msg","success");
		}else {
			ret.put("msg","error");
		}

		return ret;
	}
	
	//查询已预约审批订单
	@RequestMapping(value="/users_equi/rent_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> rentQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.rentQuery();
		
		return ret;
	}
	
	//租用器材
	@RequestMapping(value="/users_equi/lend",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> rent(HttpServletRequest request,Integer[]orderListId){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.rent(orderListId);
		ret.put("list", "");
		return ret;
	}
	
	//查询已租用审批订单
	@RequestMapping(value="/users_equi/return_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> returnQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.returnQuery();
		
		return ret;
	}
	
	//归还器材
	@RequestMapping(value="/users_equi/back",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> equReturn(HttpServletRequest request,Integer orderListId,String remark,Integer[]equId,int[]returnCondition){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.equReturn(orderListId,remark,equId,returnCondition);
		ret.put("list", "");
		return ret;
	}
	
	//退订
	@RequestMapping(value="/users_equi/order_unsubscribe",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderUnsubscribe(HttpServletRequest request,Integer[] orderListId,String remark){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.orderUnsubscribeList(orderListId,remark);
		return ret;
	}
	
	//查询器材订单
	@RequestMapping(value="/users_equi/order_query",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> orderQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.orderQuery();

		return ret;
	}
	
	
	/**
	 * 预约审批
	 *
	 */
	//找预约审核中的订单
	@RequestMapping(value="/admin_equi/res_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> resApprovalQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.findResAll();
		
		return ret;
	}
	
	@RequestMapping(value="/admin_equi/equ_res_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> reservationApproval(HttpServletRequest request,Integer[]orderListId){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.reservationApproval(orderListId);
		
		return ret;
	}
	
	/**
	 * 租借审批
	 *
	 */

	//找租用审核中的订单
	@RequestMapping(value="/admin_equi/rent_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> rentApprovalQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.findRentAll();
		
		return ret;
	}
	
	@RequestMapping(value="/admin_equi/equ_rent_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> rentApproval(HttpServletRequest request,Integer[]orderListId){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.rentApproval(orderListId);
        
		return ret;
	}
	
	/**
	 * 归还审批
	 *
	 */
	
	//找归还审核中的订单
	@RequestMapping(value="/admin_equi/return_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> returnApprovalQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.findReturnAll();
		
		return ret;
	}
	
	@RequestMapping(value="/admin_equi/equ_return_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> returnApproval(HttpServletRequest request,Integer[]orderListId){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.returnApproval(orderListId);
		
		return ret;
	}
	
	/**
	 * 退订审批
	 *
	 */
	
	//找退订审核中的订单
	@RequestMapping(value="/admin_equi/unsubscribe_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> unsubscribeApprovalQuery(HttpServletRequest request){
		Map<String, Object> ret = orderService.findUnsubscribeAll();
		
		return ret;
	}
	
	@RequestMapping(value="/admin_equi/equ_unsubscribe_approval",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> unsubscribeApproval(HttpServletRequest request,Integer[]orderListId){
		Map<String, Object> ret = new HashMap<String, Object>();
		orderService.unsubscribeApproval(orderListId);

		return ret;
	}
	
	/**
	 * 全部订单
	 *
	 */
	
	@RequestMapping(value="/admin_equi/all_order",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> allOrder(HttpServletRequest request){
		Map<String, Object> ret = orderService.allOrder();

		return ret;
	}
	
}

