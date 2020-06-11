package com.ugm.equipmentmanager.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ugm.equipmentmanager.dao.EquipmentDao;
import com.ugm.equipmentmanager.dao.MaintenanceDao;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.EquMaiRelation;
import com.ugm.equipmentmanager.entity.Maintenance;
import com.ugm.equipmentmanager.service.EquipmentService;
import com.ugm.equipmentmanager.service.MaintenanceService;
@Service
public class MaintenanceServiceImp implements MaintenanceService {

	@Autowired
	private  MaintenanceDao maintenanceDao;	
	@Override
	public Maintenance findByMaiID(int maiId){
		// TODO Auto-generated method stub
		return maintenanceDao.findByMaiID(maiId);
	}
	@Override
	public List<Equipment> maiQuery() {
		// TODO Auto-generated method stub
		return maintenanceDao.maiQuery();
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int maintenanceList(Integer[] equId, Maintenance maintenance) {
		// TODO Auto-generated method stub
		maintenanceDao.maintenanceEqu(equId);

		maintenanceDao.maintenanceList(maintenance);

		maintenanceDao.maintenanceRelation(equId, maintenance.getMaiId());
		return 0;
	}
	@Override
	public Map<String, Object> maintenancingQuery() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();   
		List<String>equList=new ArrayList<String>();   
		int maiId=0;

		List<EquMaiRelation>list=maintenanceDao.maintenancingQuery();
        
		String[] str=new String[list.size()+1];
    	int j=0;
		//移除list和quantity里相同id的数据，并把器材和其数量结合组成与处理过的list对应的字符串组
        for(int i=0;i<list.size();i++) {
        	if(maiId!=list.get(i).getMaiId()) {
            	maiId=list.get(i).getMaiId();	
            	equList.add(str[j]);
                System.out.println(str[j]);
            	j++;
            	str[j]="";
            	str[j]+=list.get(i).getEquName()+"×"+list.get(i).getQuantity();

        	}else {
            	str[j]+=list.get(i).getEquName()+"×"+list.get(i).getQuantity();
        		list.remove(i);   		
        		i--;
        	}
        }
        if(str.length!=0) {
        	equList.add(str[j]);      	
        }

        System.out.println(equList);
        map.put("list", list);
        map.put("equList", equList);
		return map;
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int maintenanceComplete(Integer[] maiId) {
		// TODO Auto-generated method stub
		maintenanceDao.maintenanceCompleteList(maiId);
		Integer[] equId=maintenanceDao.maintenanceCompleteQuery(maiId);
		
		return maintenanceDao.maintenanceCompleteEqu(equId);
	}



}
