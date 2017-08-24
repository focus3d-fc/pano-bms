package com.focus3d.pano.usersside.service.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.focus3d.pano.model.AddToCar;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Pano_Order_Shopcart;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_order_item;
import com.focus3d.pano.model.pano_order_logtc;
import com.focus3d.pano.model.pano_order_merge;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.usersside.dao.UsersSideDAO;
import com.focus3d.pano.usersside.service.UsersSideService;
@Service("usersSideService")
public class UsersSideServiceImpl implements UsersSideService{
	@Resource
	private UsersSideDAO usersSideDAO;
	@Override
	public List<pano_ad> selectAdImg_sn(Long PROJECT_SN) {
		return usersSideDAO.selectAdImg_sn(PROJECT_SN);
	}
	@Override
	public List<Style> selectStyleByProject_sn(long project_sn) {
		return usersSideDAO.selectStyleByProject_sn(project_sn);
	}
	@Override
	public List<Lable> selectLableByStyle_sn(Long style_sn) {
		return usersSideDAO.selectLableByStyle_sn(style_sn);
	}
	@Override
	public List<pano_project> list_SelectprojectList(String province,
			String city, String area) {
		pano_project pano_project=new pano_project();
		pano_project.setPROVINCE(province);
		pano_project.setCITY(city);
		pano_project.setAREA(area);
		return usersSideDAO.list_SelectprojectList(pano_project);
	}
	@Override
	public List<pano_project> list_SelectprojectList2(String province,
			String city, String area, String project_name) {
		pano_project pano_project=new pano_project();
		pano_project.setPROVINCE(province);
		pano_project.setCITY(city);
		pano_project.setAREA(area);
		pano_project.setNAME(project_name);
		return usersSideDAO.list_SelectprojectList2(pano_project);
	}
	@Override
	public List<pano_project_house> get_selectHouseListByStyle_sn(long style_sn) {
		return usersSideDAO.get_selectHouseListByStyle_sn(style_sn);
	}
	@Override
	public List<pano_project> get_projectList() {
		return usersSideDAO.get_projectList();
	}
	@Override
	public List<PanoProjectPackage> get_selectPackageListByStyle_sn(
			long style_sn) {
		return usersSideDAO.get_selectPackageListByStyle_sn(style_sn);
	}
	@Override
	public List<pano_project_space> list_selectSpaceNameListByHouse_sn(
			long house_sn) {
		return usersSideDAO.list_selectSpaceNameListByHouse_sn(house_sn);
	}
	@Override
	public List<pano_project> list_selectProjectByStyle_sn(long style_sn) {
		return usersSideDAO.list_selectProjectByStyle_sn(style_sn);
	}
	@Override
	public List<PanoProjectPackage> list_selectPackageByHouse_sn(long house_sn) {
		return usersSideDAO.list_selectPackageByHouse_sn(house_sn);
	}
	@Override
	public List<pano_mem_user> get_selectMUserByPhone(String phone) {
		return usersSideDAO.get_selectMUserByPhone(phone);
	}
	@Override
	public List<PanoProjectPackageType> list_selectPackageTypeListByPackage_Sn(
			long house_package_sn) {
		return usersSideDAO.list_selectPackageTypeListByPackage_Sn(house_package_sn);
	}
	@Override
	public List<PanoProjectPackage> get_selectPackageByPackage_sn(
			long package_sn) {
		return usersSideDAO.get_selectPackageByPackage_sn(package_sn);
	}
	@Override
	public List<AddToCar> get_selectAddToCar(long house_package_sn) {
		return usersSideDAO.get_selectAddToCar(house_package_sn);
	}
	@Override
	public void add_ShopCar(long USER_SN,long house_package_sn) {
		Pano_Order_Shopcart shopcart=new Pano_Order_Shopcart();
		shopcart.setUSER_SN(USER_SN);
		shopcart.setHOUSE_PACKAGE_SN(house_package_sn);
		usersSideDAO.add_ShopCar(shopcart);
	}
	@Override
	public List<AddToCar> get_selectAddToCar2(long user_sn) {
		return usersSideDAO.get_selectAddToCar2(user_sn);
	}
	@Override
	public List<Product> list_selectProductListByPAT_sn(long packageType_sn) {
		return usersSideDAO.list_selectProductListByPAT_sn(packageType_sn);
	}
	@Override
	public List<Product> list_selectProductByPackageType_sn(long packageType_sn) {
		return usersSideDAO.list_selectProductByPackageType_sn(packageType_sn);
	}
	@Override
	public List<AddToCar> selectCarByPackage_sn(long package_sn) {
		return usersSideDAO.selectCarByPackage_sn(package_sn);
	}
	@Override
	public void delete_shopCarByHouse_package_sn(long house_package_sn) {
		usersSideDAO.delete_shopCarByHouse_package_sn(house_package_sn);
	}
	@Override
	public List<pano_order_item> list_selectProductListByPackage_sn(
			long package_sn) {
		List<pano_order_item> itemList=usersSideDAO.list_selectProductListByPackage_sn(package_sn);
		return itemList;
	}
	@Override
	public void insert_item(long order_sn,long house_package_sn) {
		pano_order_item item=new pano_order_item();
		item.setORDER_SN(order_sn);
		item.setHOUSE_PACKAGE_SN(house_package_sn);
		usersSideDAO.insert_item(item);
	}
	@Override
	public void insert_logtc(String id, long order_sn) {
		pano_order_logtc logtc=new pano_order_logtc();
		logtc.setID(id);
		logtc.setORDER_SN(order_sn);
		usersSideDAO.insert_logtc(logtc);
	}
	@Override
	public void insert_order(String order_num, String order_time, int status,
			long address_sn, long user_sn, BigDecimal total_price) {
		pano_order order=new pano_order();
		order.setORDER_NUM(order_num);
		order.setORDER_TIME(order_time);
		order.setSTATUS(status);
		order.setADDRESS_SN(address_sn);
		order.setUSER_SN(user_sn);
		order.setTOTAL_PRICE(total_price);
		usersSideDAO.insert_order(order);
	}
	@Override
	public pano_order get_order_snByOrder_num(String ORDER_NUM) {
		return usersSideDAO.get_order_snByOrder_num(ORDER_NUM);
	}
	@Override
	public long get_address_snByUser_sn(long user_sn) {
		return usersSideDAO.get_address_snByUser_sn(user_sn);
	}
	@Override
	public List<AddToCar> get_selectAddToCarToConfirm(
			long USER_SN,String order_num) {
		pano_order order=new pano_order();
		order.setUSER_SN(USER_SN);
		order.setORDER_NUM(order_num);
		return usersSideDAO.get_selectAddToCarToConfirm(order);
	}
	@Override
	public long get_House_package_snByPackage_sn(long package_sn) {
		return usersSideDAO.get_House_package_snByPackage_sn(package_sn);
	}
	@Override
	public List<panoSkin> list_selectPanoSkinList() {
		return usersSideDAO.list_selectPanoSkinList();
	}
	@Override
	public void insert_UserMsg_Phone(String MOBILE) {
		usersSideDAO.insert_UserMsg_Phone(MOBILE);
		
	}
	@Override
	public List<pano_order> get_selectOrderByHouse_Pack_Sn(long house_pack_sn) {
		return usersSideDAO.get_selectOrderByHouse_Pack_Sn(house_pack_sn);
	}
	@Override
	public void insert_Merge(String ORDER_NUM,String All_order_num) {
		pano_order_merge merge=new pano_order_merge();
		
		merge.setORDER_NUM(ORDER_NUM);
		merge.setMERGE_ORDER_NUM(All_order_num);
		
		usersSideDAO.insert_Merge(merge);
	}
	@Override
	public void update_orderStatus(int STATUS, String ORDER_NUM) {
		pano_order order=new pano_order();
		order.setSTATUS(STATUS);
		order.setORDER_NUM(ORDER_NUM);
		
		usersSideDAO.update_orderStatus(order);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}















