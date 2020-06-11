package com.ugm.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugm.site.mapper.SiteDetailMapper;
import com.ugm.site.mapper.SitestateMapper;
import com.ugm.site.po.SiteDetail;


@Service
public class AdminService {
	
	
@Autowired	
private SiteDetailMapper sitedetailMapper;
@Autowired	
private SitestateMapper sitestateMapper;

public List<SiteDetail> selectall() throws Exception{
	
	
	return sitedetailMapper.selectall();
	
	
}

public List<SiteDetail> selectbyindex(String position,String name) throws Exception{
	
	SiteDetail detail=new SiteDetail();
	position.trim();
	name.trim();
	if(name.length()!=0) {
	name="%"+name+"%";
	
	}
	if(position.length()!=0) {
	position="%"+position+"%";
	}
	detail.setSiteName(name);
	detail.setSiteLocation(position);
	List<SiteDetail> li=sitedetailMapper.selectbyindex(detail);

	return li;
		
}

public void insertsite(SiteDetail detail) throws Exception {
	sitedetailMapper.insertdetail(detail);
	detail.getSitestate().setSiteId(detail.getSiteId());
	sitestateMapper.insertstate(detail.getSitestate());	
}

public void edit(SiteDetail detail)throws Exception{
	sitedetailMapper.editone(detail);
	detail.getSitestate().setSiteId(detail.getSiteId());
	sitestateMapper.updatestate(detail.getSitestate());
}

public SiteDetail selectbyid(int id)throws Exception{
	
	
	return sitedetailMapper.selectbyid(id);	
}

public void deleteone(int id)throws Exception{
	sitedetailMapper.deleteone(id);
}

}
