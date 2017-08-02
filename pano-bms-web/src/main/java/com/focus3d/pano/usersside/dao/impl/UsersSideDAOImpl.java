package com.focus3d.pano.usersside.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.User;
import com.focus3d.pano.usersside.dao.UsersSideDAO;
@Repository
public class UsersSideDAOImpl  extends BaseDao implements UsersSideDAO{

	@Override
	public List<Long> selectAdImg_sn() {
		List<Long> AdImg_snList=(List<Long>) getSqlMapClientTemplate().queryForList("selectAdImg_sn");
		return AdImg_snList;
	}



	
	
	
	
	
	
	
	
}












