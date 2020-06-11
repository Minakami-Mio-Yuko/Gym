package com.ugm.equipmentmanager.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Maintenance;
import com.ugm.equipmentmanager.entity.Order;


//����Աservice

@Service
public interface OrderService {
	public Order findByResID(int equresListId_id);
	public List<Equipment> resQuery(String rentTime,String returnDate);
	public int orderResList(String[]equName,BigDecimal resCost,int[]quantity,String date,String time,BigDecimal rentTotalPrice);
	public Map<String, Object> orderQuery();
	public int orderUnsubscribeList(Integer[] orderListId,String remark);	
	public int reservationApproval (Integer[]orderListId);
	public int rentApproval(Integer[]orderListId);
	public int returnApproval(Integer[]orderListId);
	public int unsubscribeApproval(Integer[]orderListId);
	public Map<String, Object> findResAll();
	public Map<String, Object> findRentAll();
	public Map<String, Object> findReturnAll();
	public Map<String, Object> findUnsubscribeAll();
	public Map<String, Object> rentQuery();
	public Map<String, Object> returnQuery();
	public int rent(Integer[]orderListId);
	public int equReturn(Integer orderListId,String remark,Integer[]equId,int[]returnCondition);
	public Map<String, Object> allOrder();
}
