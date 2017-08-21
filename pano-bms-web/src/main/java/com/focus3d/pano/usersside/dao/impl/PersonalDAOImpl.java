package com.focus3d.pano.usersside.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.OrderRelevance;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_order_item;
import com.focus3d.pano.model.pano_project_package_product;
import com.focus3d.pano.model.pano_project_package_type;
import com.focus3d.pano.model.pano_user_receive_address;
import com.focus3d.pano.usersside.dao.PersonalDAO;

@Repository
public class PersonalDAOImpl extends BaseDao implements PersonalDAO {

	@Override
	public pano_mem_user selUserbySN(Long SN) {
		pano_mem_user user = (pano_mem_user) getSqlMapClientTemplate()
				.queryForObject("pano_mem_user.selUserbySN", SN);
		return user;
	}

	@Override
	public List<pano_user_receive_address> selAddressbyUserSN(Long USER_SN) {
		List<pano_user_receive_address> list = (List<pano_user_receive_address>) getSqlMapClientTemplate()
				.queryForList("pano_user_receive_address.selAddressbyUserSN",
						USER_SN);
		return list;
	}

	@Override
	public void addAddress(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert(
				"pano_user_receive_address.addAddress", address);
	}

	@Override
	public int delAddress(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete(
				"pano_user_receive_address.delAddress", SN);
		return row;
	}

	@Override
	public pano_user_receive_address selAddressbySN(Long SN) {
		pano_user_receive_address address = (pano_user_receive_address) getSqlMapClientTemplate()
				.queryForObject("pano_user_receive_address.selAddressbySN", SN);
		return address;
	}

	@Override
	public void upAddress(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("pano_user_receive_address.upAddress",
				address);
	}

	@Override
	public void upMemuser(pano_mem_user memuser) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("pano_mem_user.upMemuser", memuser);
	}

	@Override
	public List<OrderRelevance> selOrderbyUser(Long USER_SN) {
		List<OrderRelevance> list = (List<OrderRelevance>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrderbyUser", USER_SN);
		return list;
	}

	@Override
	public List<OrderRelevance> selOrderbyUser2(Long USER_SN) {
		List<OrderRelevance> list = (List<OrderRelevance>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrderbyUser2", USER_SN);
		return list;
	}

	@Override
	public List<OrderRelevance> selOrderbyUser3(Long USER_SN) {
		List<OrderRelevance> list = (List<OrderRelevance>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrderbyUser3", USER_SN);
		return list;
	}

	@Override
	public List<pano_user_receive_address> selAddressbyDef(Long USER_SN) {
		List<pano_user_receive_address> list = (List<pano_user_receive_address>) getSqlMapClientTemplate()
				.queryForList("pano_user_receive_address.selAddressbyDef",
						USER_SN);
		return list;
	}

	@Override
	public List<OrderRelevance> selOrderbySN(Long ORDER_SN) {
		List<OrderRelevance> list = (List<OrderRelevance>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrderbySN", ORDER_SN);
		return list;
	}

	@Override
	public void upDef(pano_user_receive_address address) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("pano_user_receive_address.upDef",
				address);
	}

	@Override
	public List<pano_order> selOrder() {
		List<pano_order> list = (List<pano_order>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrder");
		return list;
	}

	@Override
	public void upOrder(pano_order or) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("OrderRelevance.upOrder", or);
	}

	@Override
	public List<pano_order> selOrderbyOrderSN(Long ORDER_SN) {
		List<pano_order> list = (List<pano_order>) getSqlMapClientTemplate()
				.queryForList("OrderRelevance.selOrderbyOrderSN", ORDER_SN);
		return list;
	}

	@Override
	public void upOrderStatus(pano_order or) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("OrderRelevance.upOrderStatus", or);
	}

}
