package com.focus3d.pano.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.OrderAdmin;
import com.focus3d.pano.model.pano_project;

public interface OrderDAO {

	// 查询订单
	public List<OrderAdmin> selOrder(Page page);

	// 查询记录数
	public int selOrderCount(HashMap<String,Object> map);

	// 查看订单详情
	public List<OrderAdmin> selOrderbySN(Long ORDER_SN);

	// 查询所有楼盘
	public List<pano_project> selHouse();

	// 搜索
	public List<OrderAdmin> selOrderbyAll(HashMap<String,Object> order);

	// 搜索-根据楼盘
	public List<OrderAdmin> selOrderbyHouse(OrderAdmin order);

	// 搜索-根据姓名
	public List<OrderAdmin> selOrderbyNickname(OrderAdmin order);

}
