package com.ugm.site.mapper;

import com.ugm.site.po.Sitestate;

public interface SitestateMapper {
  public  Sitestate selectstate(int id) throws Exception;
   public void insertstate(Sitestate state)throws Exception;
    public void updatestate(Sitestate state)throws Exception;
}
