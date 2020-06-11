package com.ugm.equipmentmanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.EquMaiRelation;
import com.ugm.equipmentmanager.entity.Maintenance;
import com.ugm.equipmentmanager.entity.Order;

// ����Աdao


/**
 * 订单状态(预约审核中、已预约、租用审核中、已租用、归还审核中、已归还、退订审核中、已退订)
 *
 */
@Repository
public interface OrderDao {
	@Select("select * from equ_order_list where res_list_id = #{resListId}")
	public Order findByResID(int equresListId_id);
	
	/**
	 * 查符合预约时间段的器材
	 */
	@Select("select order_list_id from equ_order_list where (NOT(return_date < #{rentTime} or rent_time > #{returnDate})) or order_condition<>'7'")
	public Integer[] resQueryOrder(@Param(value="rentTime")String rentTime,@Param(value="returnDate")String returnDate);
	public Integer[] resQueryEqu(@Param(value="orderListId")Integer[]orderListId);
	public List<Equipment> resQuery(@Param(value="equId")Integer[]equId);
	public List<Equipment> resQueryEquId(@Param(value="equId")Integer[]equId);
	
	/**
	 * 预约
	 */
	public int orderResList(Order order);
	public int orderResRelation(@Param(value="equId")Integer[] equId,@Param(value="orderListId")int orderListId);
	
	/*
	 * 退订
	 */
	public int orderUnsubscribeList(@Param(value="orderListId")Integer[] orderListId,@Param(value="remark")String remark);	
	/*
	 * 租用
	 */
	public int rent(Integer[]orderListId);
	/*
	 * 归还
	 */
	@Update("update equ_order_list set order_condition='4',true_return_date=now(),remark=#{remark} where order_list_id=#{orderListId}")
	public int equReturn(@Param(value="orderListId")Integer orderListId,@Param(value="remark")String remark);
	public int equReturnSituation(@Param(value="list")List<EquOrderRelation>list,@Param(value="orderListId")Integer orderListId);
	/*
	 * 查找订单单信息
	 */
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> orderQuery();
	/*
	 * 查找已预约审批订单信息
	 */
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id and order_condition='1' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> rentQuery();
	/*
	 * 查找已租用审批订单信息
	 */
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id and order_condition='3' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> returnQuery();
	/*
	 * 查找已租用审批订单上的器材信息
	 */
	@Select("SELECT *FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id and order_condition='3' GROUP BY e.equ_id,o.order_list_id")
	public List<EquOrderRelation> returnQueryEqu();
	

	
	//查找所有器材信息
	@Select("select * from equipment where 1=1")
	public List<Equipment> findAll(Map<String,Object>map);
	
	
	
	/**
	 * 订单状态(预约审核中、已预约、租用审核中、已租用、归还审核中、已归还、退订审核中、已退订)
	 */
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id AND o.order_condition='0' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> findResAll();
	public int reservationApproval (Integer[]orderListId);
	
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id AND o.order_condition='2' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> findRentAll();
	public int rentApproval(Integer[]orderListId);
	
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id AND o.order_condition='4' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> findReturnAll();
	public int returnApproval(Integer[]orderListId);
	
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id AND o.order_condition='6' GROUP BY o.order_list_id,e.equ_name")
	public List<EquOrderRelation> findUnsubscribeAll();
	public int unsubscribeApproval(Integer[]orderListId);
	//全部订单
	@Select("SELECT *,count(*) quantity FROM equ_order_list o,equ_order_relation eo,equipment e WHERE "
			+ "o.order_list_id=eo.order_id AND eo.equ_id=e.equ_id GROUP BY o.order_list_id,e.equ_name order by res_time DESC")
	public List<EquOrderRelation> allOrder();
}
