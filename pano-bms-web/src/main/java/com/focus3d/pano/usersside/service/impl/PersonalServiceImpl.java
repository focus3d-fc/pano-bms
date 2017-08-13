package com.focus3d.pano.usersside.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.model.OrderRelevance;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_order_item;
import com.focus3d.pano.model.pano_project_package_product;
import com.focus3d.pano.model.pano_user_receive_address;
import com.focus3d.pano.usersside.dao.PersonalDAO;
import com.focus3d.pano.usersside.service.PersonalService;

@Service("personalService")
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalDAO personalDAO;

	@Override
	public pano_mem_user selUserbySN(Long SN) {
		// TODO Auto-generated method stub
		return personalDAO.selUserbySN(SN);
	}

	@Override
	public List<pano_user_receive_address> selAddressbyUserSN(Long USER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selAddressbyUserSN(USER_SN);
	}

	@Override
	public void addAddress(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		personalDAO.addAddress(address);
	}

	@Override
	public int delAddress(Long SN) {
		// TODO Auto-generated method stub
		return personalDAO.delAddress(SN);
	}

	@Override
	public pano_user_receive_address selAddressbySN(Long SN) {
		// TODO Auto-generated method stub
		return personalDAO.selAddressbySN(SN);
	}

	@Override
	public void upAddress(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		personalDAO.upAddress(address);
	}

	@Override
	public void upMemuser(pano_mem_user memuser) {
		// TODO Auto-generated method stub
		personalDAO.upMemuser(memuser);
	}

	@Override
	public List<OrderRelevance> selOrderbyUser(Long USER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selOrderbyUser(USER_SN);
	}

}
