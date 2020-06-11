package com.ugm.equipmentmanager.service.impl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ugm.equipmentmanager.dao.OrderDao;
import com.ugm.equipmentmanager.entity.EquOrderRelation;
import com.ugm.equipmentmanager.entity.Equipment;
import com.ugm.equipmentmanager.entity.Order;
import com.ugm.equipmentmanager.service.OrderService;
@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDao orderDao;	
	@Override
	public Order findByResID(int resID){
		// TODO Auto-generated method stub
		return orderDao.findByResID(resID);
	}
	

	/**
	 *可预约器材的查询
	 */
	@Override
	public List<Equipment> resQuery(String date,String time) {
		// TODO Auto-generated method stub
		//转换前端传来的日期为租用时间和归还时间
		Map<String,Object>map = datetimeTrans(date,time);

		String rentTime = (String) map.get("rentTime");
		String returnDate = (String) map.get("returnDate");
		
		//获取可预约的器材
		List<Equipment>list=new ArrayList<Equipment>();
		Integer[]equId=null;
		Integer[]orderListId=orderDao.resQueryOrder(rentTime, returnDate);
		if(orderListId.length!=0) {
			equId=orderDao.resQueryEqu(orderListId);	
		}

			list=orderDao.resQuery(equId);
			return list;
		


	}
	
	/**
	 *预约器材
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int orderResList(String[]equName,BigDecimal resCost,int[]quantity,String date,String time,BigDecimal rentTotalPrice) {
		//转换前端传来的日期为租用时间和归还时间
		Map<String,Object>map = datetimeTrans(date,time);
		String rentTime = (String) map.get("rentTime");
		String returnDate = (String) map.get("returnDate");
		//获取可预约的器材id
		List<Equipment>list=new ArrayList<Equipment>();
		Integer[]orderListId=orderDao.resQueryOrder(rentTime, returnDate);
		Integer[]equId0=null;
		if(orderListId.length!=0) {
			orderDao.resQueryEqu(orderListId);
		}
		list=orderDao.resQueryEquId(equId0);
		
		/**
		 *i为前端传来的equName计数
		 *j为可预约器材list的计数
		 *k为预约数量的计数
		 *m为equId[]的储存索引
		 */
		
		Integer[]equId = new Integer[list.size()];
        int m=0;
		for(int i=0;i<equName.length;i++) {
			int k=0;
			for(int j=0;j<list.size();j++) {
				if(equName[i].equals(list.get(j).getEquName())) {
					equId[m]=list.get(j).getEquId();
					m++;
					k++;
					if(k==quantity[i]) {
						break;
					}
				}
			}
			//器材数量不足
			if(k<quantity[i]) {
				return 0;
				/* throw new RuntimeException(); */
			}
		}
		Order order=new Order();
		order.setRentTime(rentTime);
		order.setReturnDate(returnDate);
		order.setResDeposit(resCost);
		order.setRentTotalPrice(rentTotalPrice);
		orderDao.orderResList(order);
		orderDao.orderResRelation(equId,order.getOrderListId());

		return 1;
	}
	
	
	//退订
	@Override
	public int orderUnsubscribeList(Integer[] orderListId,String remark) {
		
		
		return orderDao.orderUnsubscribeList(orderListId,remark);
	}

	
	/**
	 *租借
	 */
	@Override
	public Map<String, Object> rentQuery() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.rentQuery();
		list=timeStringChange(list);

		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	@Override
	public int rent(Integer[] orderListId) {
		// TODO Auto-generated method stub	
		return orderDao.rent(orderListId);
	}

	/**
	 *归还
	 */
	@Override
	public Map<String, Object> returnQuery() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		
		//totalList,用于用户归还弹出框显示数据
		List<EquOrderRelation>list=orderDao.returnQuery();
		List<EquOrderRelation>totalList=orderDao.returnQueryEqu();
		//格式化时间
		list=timeStringChange(list);
		Map<String, Object> map = new HashMap<String, Object>();
		
		//把显示的器材出来好，放在map返回出来
		map=equNameTrans(list,equList);
		
		//把totalList也加入map返回到前端
		map.put("totalList", totalList);
		return map;
	}

	@Override
	@Transactional
	public int equReturn(Integer orderListId,String remark,Integer[]equId,int[]returnCondition) {
		// TODO Auto-generated method stub
		orderDao.equReturn(orderListId, remark);
		List<EquOrderRelation>list=new ArrayList<EquOrderRelation>();
        for(int i=0;i<equId.length;i++) {
        	EquOrderRelation equOrderRelation=new EquOrderRelation();
        	equOrderRelation.setEquId(equId[i]);
        	equOrderRelation.setReturnCondition(returnCondition[i]);;
        	list.add(equOrderRelation);
        }
		
		return orderDao.equReturnSituation(list,orderListId);
	}
	
	
	/**
	 *查看订单表
	 */
	@Override
	public Map<String, Object> orderQuery() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.orderQuery();
		Map<String, Object> map = equNameTrans(list,equList);
		list=timeStringChange(list);
		return map;
	}
	
	
	
	//找未审批预约的订单
	@Override
	public Map<String, Object> findResAll() {
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.findResAll();
		list=timeStringChange(list);
		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	//找未审批租用的订单
	@Override
	public Map<String, Object> findRentAll() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.findRentAll();
		list=timeStringChange(list);
		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	//找未审批归还的订单
	@Override
	public Map<String, Object> findReturnAll() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.findReturnAll();
		list=timeStringChange(list);
		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	//找未审批退订的订单
	@Override
	public Map<String, Object> findUnsubscribeAll() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.findUnsubscribeAll();
		list=timeStringChange(list);
		
		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	@Override
	public int reservationApproval(Integer[]orderListId) {
		// TODO Auto-generated method stub
		return orderDao.reservationApproval(orderListId);
	}


	@Override
	public int rentApproval(Integer[]orderListId) {
		// TODO Auto-generated method stub
		return orderDao.rentApproval(orderListId);
	}


	@Override
	public int returnApproval(Integer[]orderListId) {
		// TODO Auto-generated method stub
		return orderDao.returnApproval(orderListId);
	}


	@Override
	public int unsubscribeApproval(Integer[]orderListId) {
		// TODO Auto-generated method stub
		return orderDao.unsubscribeApproval(orderListId);
	}
	
	
	@Override
	public Map<String, Object> allOrder() {
		// TODO Auto-generated method stub
		List<String>equList=new ArrayList<String>();   
		List<EquOrderRelation>list=orderDao.allOrder();
		list=timeStringChange(list);
		
		Map<String, Object> map = equNameTrans(list,equList);
		return map;
	}
	
	
	//处理器材名称
	public Map<String, Object>equNameTrans(List<EquOrderRelation>list,List<String>equList){
		Map<String, Object> map = new HashMap<String, Object>();   
		int orderId=0;
		String[] str=new String[list.size()+1];
    	int j=0;
		//移除list和quantity里相同id的数据，并把器材和其数量结合组成与处理过的list对应的字符串组
        for(int i=0;i<list.size();i++) {
        	if(orderId!=list.get(i).getOrderListId()) {
        		orderId=list.get(i).getOrderListId();	
            	equList.add(str[j]);
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
        map.put("list", list);
        map.put("equList", equList);
		return map;
		
	}
	
	
	
	/**
	 *转换前端传来的日期为租用时间和归还时间
	 */
	public Map<String,Object> datetimeTrans(String date,String time){
		Map<String,Object>map=new HashMap<String,Object>();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String rentTime = null;
		String returnDate = null;
		if(time.equals("上午(8:00—12:00)")) {
			rentTime=date+" "+"8:00:00";
			returnDate=date+" "+"12:00:00";
		}else if (time.equals("下午(13:00——17:00)")) {
			rentTime=date+" "+"13:00:00";
			returnDate=date+" "+"17:00:00";
		}else if (time.equals("晚上(18:00——22:00)")) {
			rentTime=date+" "+"18:00:00";
			returnDate=date+" "+"22:00:00";
		}else if (time.equals("1天")) {
			rentTime=date+" "+"8:00:00";
			returnDate=date+" "+"22:00:00";
		}else if (time.equals("2天")) {
			try {
				Date d=sdf.parse(date);
				Calendar cld=Calendar.getInstance();
				cld.setTime(d);
				cld.add(Calendar.DAY_OF_YEAR, 1);
				
				rentTime=date+" "+"8:00:00";
				returnDate=sdf.format(cld.getTime())+" "+"22:00:00";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		map.put("rentTime", rentTime);
		map.put("returnDate", returnDate);
		
		return map;
	}

public List<EquOrderRelation> timeStringChange(List<EquOrderRelation>list){
	for(int i=0;i<list.size();i++) {
		//去除空格
		list.get(i).setResTime(list.get(i).getResTime().replaceAll(" ", "/"));
		list.get(i).setRentTime(list.get(i).getResTime().replaceAll(" ", "/"));
		list.get(i).setReturnDate(list.get(i).getResTime().replaceAll(" ", "/"));
		//去除日期后缀的.0
		list.get(i).setResTime(list.get(i).getResTime().substring(0, 19));
		list.get(i).setRentTime(list.get(i).getResTime().substring(0, 19));
		list.get(i).setReturnDate(list.get(i).getResTime().substring(0, 19));
	}
	return list;
}













}


