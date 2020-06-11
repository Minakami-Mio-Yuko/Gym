package com.ugm.equipmentmanager.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugm.equipmentmanager.dao.EquipmentDao;
import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Order;
import com.ugm.equipmentmanager.service.EquipmentService;
@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;	
	@Override
	public Equipment findByEquID(int equId){
		// TODO Auto-generated method stub
		return equipmentDao.findByEquID(equId);
	}
	@Override
	public int newEqu(Equipment equipment,int newQuantity) {
		List<Object>list=new ArrayList<Object>();
		for(int i=0;i<newQuantity;i++) {
			list.add(equipment);
		}
		return equipmentDao.newEqu(list);
	}
	@Override
	public int deleteEqu(Integer equId[],String choseType) {
		if(choseType.equals("undelete_tb")) {
			return equipmentDao.deleteEqu(equId);		
		}else {
			return equipmentDao.cancelDeleteEqu(equId);
		}
	}
	@Override
	public int updateEqu(Integer[] equId,BigDecimal[] maintenancePrice,
			BigDecimal[] buyPrice,int[]brokenCondition) {
		List<Equipment>list = new ArrayList<Equipment>();

		for (int i=0;i<equId.length;i++) {
			Equipment equipment=new Equipment();
			equipment.setEquId(equId[i]);
            equipment.setBrokenCondition(brokenCondition[i]);
            equipment.setMaintenancePrice(maintenancePrice[i]);
            equipment.setBuyPrice(buyPrice[i]);
			list.add(equipment);
		}
		return equipmentDao.updateEqu(list);
	}
	@Override
	public List<Equipment> findlist(Map<String,Object>map) {
		return equipmentDao.findlist(map);
	}
	@Override
	public int getTotal(Map<String,Object>map) {
		return equipmentDao.getTotal(map);
	}
	@Override	
	public List<Equipment> findUndelete() {
		return equipmentDao.findUndelete();
	}
	@Override
	public List<Equipment> findHaddelete() {
		// TODO Auto-generated method stub
		return equipmentDao.findHaddelete();
	}
	@Override
	public List<Equipment> findUndeleteGroup() {
		
		return equipmentDao.findUndeleteGroup();
	}
	@Override
	public int updateEquGroup(String[] equName,BigDecimal[] reservationPrice,
			BigDecimal[] rentPrice) {
		List<Equipment>list = new ArrayList<Equipment>();

		for (int i=0;i<equName.length;i++) {
			Equipment equipment=new Equipment();
			equipment.setEquName(equName[i]);
			equipment.setRentPrice(rentPrice[i]);
			equipment.setReservationPrice(reservationPrice[i]);
			list.add(equipment);
		}
		return  equipmentDao.updateEquGroup(list);
	}

}
