package com.ugm.equipmentmanager.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Order;;

//����Աservice

@Service
public interface EquipmentService {
	public Equipment findByEquID(int equId);
	public int newEqu(Equipment equipment,int newQuantity);
	public int deleteEqu(Integer equId[],String choseType);
	public int updateEqu(Integer[] equId,BigDecimal[] reservationPrice,
			BigDecimal[] rentPrice,int[]brokenCondition);

	public List<Equipment> findlist(Map<String,Object>map);
	public int getTotal(Map<String,Object>map);
	public List<Equipment> findUndelete();
	public List<Equipment> findHaddelete();
	public List<Equipment> findUndeleteGroup();
	public int updateEquGroup(String[] equName,BigDecimal[] reservationPrice,
			BigDecimal[] rentPrice);
}
