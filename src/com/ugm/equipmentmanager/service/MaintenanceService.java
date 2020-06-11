package com.ugm.equipmentmanager.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Maintenance;;

//����Աservice

@Service
public interface MaintenanceService {
	public Maintenance findByMaiID(int maiId);
	public List<Equipment> maiQuery();
	public int maintenanceList(Integer[] equId,Maintenance maintenance);
	public Map<String, Object> maintenancingQuery();
	public int maintenanceComplete(Integer[]maiId);
}
