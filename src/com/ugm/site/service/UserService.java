package com.ugm.site.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugm.site.mapper.SiteDetailMapper;
import com.ugm.site.mapper.SiteOrderMapper;
import com.ugm.site.mapper.SitestateMapper;
import com.ugm.site.po.SiteDetail;
import com.ugm.site.po.SiteOrder;
import com.ugm.site.po.Sitestate;
@Service
public class UserService {

	@Autowired	
	private SiteDetailMapper sitedetailMapper;
	@Autowired	
	private SitestateMapper sitestateMapper;
	@Autowired
	private SiteOrderMapper siteordermapper;
	
	
	public List<SiteDetail> selectall() throws Exception{
		
		
		return sitedetailMapper.selectall();
		
		
	}
	
	public List<SiteDetail> selectbyuser(int a,String b) throws Exception{
		SiteDetail detail=new SiteDetail();
		b.trim();
		if(b.length()!=0) {
		b="%"+b+"%";		
		}
		detail.setSiteName(b);
		System.out.println(a);
		if(detail.getSitestate()==null) {
			detail.setSitestate(new Sitestate());
			detail.getSitestate().setSiteBook(a);
			System.out.println(detail.getSitestate().getSiteBook());
		}else {
			detail.getSitestate().setSiteBook(a);
			System.out.println(detail.getSitestate().getSiteBook());
		}
		return sitedetailMapper.selectbyuser(detail);		
	}
	
	public List<SiteOrder> userquery(int id) throws Exception{
				
		return siteordermapper.userquery(id);
		
	}
	
	
	public void insertorder(int id,String a,String b) throws Exception{
		SiteDetail detail=sitedetailMapper.selectbyid(id);
		 Timestamp starttime = Timestamp.valueOf(a);
		 Timestamp endtime=Timestamp.valueOf(b);
		 Timestamp currenttime = new Timestamp(System.currentTimeMillis()); 
		 SiteOrder order=new SiteOrder();
		 order.setOrderStarttime(starttime);
		 order.setOrderEndtime(endtime);
		 order.setOrderRentprice(detail.getSiteRentprice());
		 order.setOrderDepositprice(detail.getSiteDepositprice());
		 order.setOrdersiteId(id);
		 order.setOrderBooktime(currenttime);
		siteordermapper.insertorder(order);
	}
	
	public List<SiteOrder> orderall() throws Exception{
		
		return siteordermapper.allorder();
	}
	
}
