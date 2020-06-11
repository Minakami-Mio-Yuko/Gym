package com.ugm.equipmentmanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Order;;

/**
 * 器材的持久层
 * 简单sql使用注解
 * 复杂sql使用配置文件
 */

@Repository
public interface EquipmentDao {
	
	@Select("select * from equipment where equ_id = #{equId}")
	public Equipment findByEquID(int equ_id);

	
	/**
	 * 使用mapper配置文件
	 */
	//查找所有未删除/未删除器材信息.(完好，损坏可维护，损坏不可修复/移除/正在维护)
	@Select("select * from Equipment where broken_condition <> '2' order by equ_update_time DESC")
	public List<Equipment> findUndelete();
	@Select("select * , Count(*) quantity from equipment where broken_condition =0 GROUP BY equ_name DESC")
	public List<Equipment> findUndeleteGroup();
	@Select("select * from Equipment where broken_condition = '2' order by equ_update_time DESC")
	public List<Equipment> findHaddelete();
	//批量添加
	public int newEqu(List<Object>list);
	//批量删除
	public int deleteEqu(Integer[] equId);
	//批量撤消删除
	public int cancelDeleteEqu(Integer[] equId);
	//批量更新
	public int updateEqu(List<Equipment>list);
	//按组更新
	public int updateEquGroup(List<Equipment>list);
	
	public List<Equipment> findlist(Map<String,Object>map);
	public int getTotal(Map<String,Object>map);
}
