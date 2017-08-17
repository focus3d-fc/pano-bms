package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.OrderDAO;
import com.focus3d.pano.admin.service.OrderService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.OrderAdmin;
import com.focus3d.pano.model.pano_project;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public List<OrderAdmin> selOrder(Page page) {
		// TODO Auto-generated method stub
		return orderDAO.selOrder(page);
	}

	@Override
	public int selOrderCount() {
		// TODO Auto-generated method stub
		return orderDAO.selOrderCount();
	}

	@Override
	public List<OrderAdmin> selOrderbySN(Long ORDER_SN) {
		// TODO Auto-generated method stub
		return orderDAO.selOrderbySN(ORDER_SN);
	}

	@Override
	public List<pano_project> selHouse() {
		// TODO Auto-generated method stub
		return orderDAO.selHouse();
	}

	@Override
	public List<OrderAdmin> selOrderbyAll(OrderAdmin order) {
		// TODO Auto-generated method stub
		return orderDAO.selOrderbyAll(order);
	}

	@Override
	public List<OrderAdmin> selOrderbyHouse(OrderAdmin order) {
		// TODO Auto-generated method stub
		return orderDAO.selOrderbyHouse(order);
	}

	@Override
	public List<OrderAdmin> selOrderbyNickname(OrderAdmin order) {
		// TODO Auto-generated method stub
		return orderDAO.selOrderbyNickname(order);
	}
}
