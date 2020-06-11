package com.ugm.site.mapper;

import java.util.List;

import com.ugm.site.po.SiteDetail;

public interface SiteDetailMapper {
	
	public List<SiteDetail> selectall() throws Exception;
	public List<SiteDetail> selectbyindex(SiteDetail sitedetail) throws Exception;
	public void insertdetail(SiteDetail detail) throws Exception;
	public void editone(SiteDetail detail)throws Exception;
	public SiteDetail selectbyid(int id)throws Exception;
	public void deleteone(int id)throws Exception;
	public List<SiteDetail> selectbyuser(SiteDetail sitedetail) throws Exception;
}
