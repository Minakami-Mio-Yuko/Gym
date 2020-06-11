package com.ugm.site.mapper;

import java.util.List;

import com.ugm.site.po.SiteOrder;

public interface SiteOrderMapper {
	
	public List<SiteOrder> userquery(int id) throws Exception;
	public void insertorder(SiteOrder order) throws Exception;
	public List<SiteOrder> allorder() throws Exception;

}
