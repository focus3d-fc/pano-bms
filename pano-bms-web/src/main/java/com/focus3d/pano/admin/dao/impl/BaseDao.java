package com.focus3d.pano.admin.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport{
	public BaseDao(){
		System.out.println("----------------baseDao--------");
	}
  @Resource(name="ciefSqlMapClient")
  private SqlMapClient sqlMapClient;
  
  @PostConstruct
  public void initSqlMapClient() {
      super.setSqlMapClient(sqlMapClient);
  }
}
