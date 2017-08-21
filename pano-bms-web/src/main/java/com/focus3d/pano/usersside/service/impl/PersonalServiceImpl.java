package com.focus3d.pano.usersside.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.model.OrderRelevance;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
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

	@Override
	public List<OrderRelevance> selOrderbyUser2(Long USER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selOrderbyUser2(USER_SN);
	}

	@Override
	public List<OrderRelevance> selOrderbyUser3(Long USER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selOrderbyUser3(USER_SN);
	}

	@Override
	public void upAddres() {
		// TODO Auto-generated method stub
		List<pano_order> orc = personalDAO.selOrder();
		for (int order = 0; order < orc.size() - 1; order++) {
			pano_order sh = new pano_order();
			pano_order sh2 = new pano_order();
			sh.setUSER_SN(orc.get(order + 1).getUSER_SN());
			sh.setSN(orc.get(order).getSN());
			personalDAO.upOrder(sh);
			sh2.setUSER_SN(orc.get(order).getUSER_SN());
			sh2.setSN(orc.get(order + 1).getSN());
			personalDAO.upOrder(sh2);
		}
	}

	@Override
	public List<pano_user_receive_address> selAddressbyDef(Long USER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selAddressbyDef(USER_SN);
	}

	@Override
	public List<OrderRelevance> selOrderbySN(Long ORDER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selOrderbySN(ORDER_SN);
	}

	@Override
	public void upDef(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		personalDAO.upDef(address);
	}

	@Override
	public List<pano_order> selOrder() {
		// TODO Auto-generated method stub
		return personalDAO.selOrder();
	}

	@Override
	public void upOrder(pano_order or) {
		// TODO Auto-generated method stub
		personalDAO.upOrder(or);
	}

	@Override
	public List<pano_order> selOrderbyOrderSN(Long ORDER_SN) {
		// TODO Auto-generated method stub
		return personalDAO.selOrderbyOrderSN(ORDER_SN);
	}

	@Override
	public void upOrderStatus(pano_order or) {
		// TODO Auto-generated method stub
		personalDAO.upOrderStatus(or);
	}

}
