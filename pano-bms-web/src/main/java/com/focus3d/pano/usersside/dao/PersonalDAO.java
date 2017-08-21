package com.focus3d.pano.usersside.dao;

import java.util.List;

import com.focus3d.pano.model.OrderRelevance;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_user_receive_address;

public interface PersonalDAO {

	// ----------------------------------------------个人中心----------------------------------------------

	// 根据SN查询用户信息
	public pano_mem_user selUserbySN(Long SN);

	// ----------------------------------------------收货地址----------------------------------------------

	// 查询用户收货地址
	public List<pano_user_receive_address> selAddressbyUserSN(Long USER_SN);

	// 新增收货地址
	public void addAddress(pano_user_receive_address address);

	// 删除收货地址
	public int delAddress(Long SN);

	// 根据SN查询收货地址
	public pano_user_receive_address selAddressbySN(Long SN);

	// 修改收货地址
	public void upAddress(pano_user_receive_address address);

	// 查询用户默认收货地址
	public List<pano_user_receive_address> selAddressbyDef(Long USER_SN);

	// 修改默认状态
	public void upDef(pano_user_receive_address address);

	// ----------------------------------------------实名认证----------------------------------------------

	// 修改实名信息
	public void upMemuser(pano_mem_user memuser);

	// ----------------------------------------------全部订单----------------------------------------------
	// 查询订单信息
	public List<pano_order> selOrder();

	// 修改订单信息
	public void upOrder(pano_order or);

	// 根据用户编号查询所有订单
	public List<OrderRelevance> selOrderbyUser(Long USER_SN);

	// 根据用户编号查询待付款订单
	public List<OrderRelevance> selOrderbyUser2(Long USER_SN);

	// 根据用户编号查询已付款订单
	public List<OrderRelevance> selOrderbyUser3(Long USER_SN);

	// 根据订单号查询订单
	public List<OrderRelevance> selOrderbySN(Long ORDER_SN);

	// 根据订单号查询订单
	public List<pano_order> selOrderbyOrderSN(Long ORDER_SN);

	// 修改订单状态
	public void upOrderStatus(pano_order or);

}
