package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.OrderDAO;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.OrderAdmin;
import com.focus3d.pano.model.pano_project;

@Repository
public class OrderDAOImpl extends BaseDao implements OrderDAO {

	@Override
	public List<OrderAdmin> selOrder(Page page) {
		List<OrderAdmin> list = (List<OrderAdmin>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selOrder", page);
		return list;
	}

	@Override
	public int selOrderCount() {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"OrderAdmin.selOrderCount");
		return count;
	}

	@Override
	public List<OrderAdmin> selOrderbySN(Long ORDER_SN) {
		List<OrderAdmin> list = (List<OrderAdmin>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selOrderbySN", ORDER_SN);
		return list;
	}

	@Override
	public List<pano_project> selHouse() {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selHouse");
		return list;
	}

	@Override
	public List<OrderAdmin> selOrderbyAll(OrderAdmin order) {
		List<OrderAdmin> list = (List<OrderAdmin>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selOrderbyAll", order);
		return list;
	}

	@Override
	public List<OrderAdmin> selOrderbyHouse(OrderAdmin order) {
		List<OrderAdmin> list = (List<OrderAdmin>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selOrderbyHouse", order);
		return list;
	}

	@Override
	public List<OrderAdmin> selOrderbyNickname(OrderAdmin order) {
		List<OrderAdmin> list = (List<OrderAdmin>) getSqlMapClientTemplate()
				.queryForList("OrderAdmin.selOrderbyNickname", order);
		return list;
	}

}
