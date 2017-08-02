package com.focus3d.pano.usersside.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.UserDao;
import com.focus3d.pano.usersside.dao.UsersSideDAO;
import com.focus3d.pano.usersside.service.UsersSideService;
@Service("usersSideService")
public class UsersSideServiceImpl implements UsersSideService{
	@Resource
	private UsersSideDAO usersSideDAO;
	@Override
	public List<Long> selectAdImg_sn() {
		return usersSideDAO.selectAdImg_sn();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}















