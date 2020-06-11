package com.ugm.equipmentmanager.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.EquMaiRelation;
import com.ugm.equipmentmanager.entity.Maintenance;;

// ����Աdao

@Repository
public interface MaintenanceDao {
	@Select("select * from equ_maintenance_list where mai_id = #{maiId}")
	public Maintenance findByMaiID(int maiId);
	@Select("select * from equipment where broken_condition<>'2' and broken_condition<>'3'")
	public List<Equipment> maiQuery();
	
	/*
	 * 查找维护单信息
	 */
	@Select("SELECT *,COUNT(*) quantity FROM equ_maintenance_list m,equ_mai_relation mr,equipment e "
			+ "WHERE m.mai_id=mr.mai_id AND mr.equ_id=e.equ_id AND m.mai_condition='0' GROUP BY m.mai_id,e.equ_name")
	public List<EquMaiRelation> maintenancingQuery();
	/*
	 * @Select("SELECT COUNT(*) a FROM equ_maintenance_list m,equ_mai_relation mr,equipment e "
	 * +
	 * "WHERE m.mai_id=mr.mai_id AND mr.equ_id=e.equ_id AND m.mai_condition='0' GROUP BY m.mai_id,e.equ_name"
	 * ) public Integer[] maintenancingEquQuantity();
	 */
	
	/*
	 * 完成维护
	 */
	public int maintenanceCompleteList(Integer[] maiId);	
	public Integer[] maintenanceCompleteQuery(Integer[] maiId);
	public int maintenanceCompleteEqu(Integer[]equId);
	
	/*
	 * broken_condition='3'为器材正在维护中
	 * mai_condition(0.维护中/1.维护完成)
	 */
	public int maintenanceEqu(Integer[] equId);
	public int maintenanceList(Maintenance maintenance);
	public int maintenanceRelation(@Param(value="equId")Integer[] equId,@Param(value="maiId")int maiId);

	
}
