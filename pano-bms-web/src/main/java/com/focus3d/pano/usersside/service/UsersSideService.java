package com.focus3d.pano.usersside.service;

import java.math.BigDecimal;
import java.util.List;

import com.focus3d.pano.model.AddToCar;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
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

public interface UsersSideService {
	public List<pano_ad> selectAdImg_sn(Long PROJECT_SN);
	public List<Style> selectStyleByProject_sn(long project_sn);
	public List<Lable> selectLableByStyle_sn(Long style_sn);
	public List<pano_project> list_SelectprojectList(
			String province,String city,String area);
	public List<pano_project> list_SelectprojectList2(
			String province,String city,String area,String project_name);
	public List<pano_project_house> get_selectHouseListByStyle_sn(long style_sn);
	public List<pano_project> get_projectList();
	public List<PanoProjectPackage> get_selectPackageListByStyle_sn(
			long style_sn);
	public List<pano_project_space> list_selectSpaceNameListByHouse_sn(long house_sn);
	public List<pano_project> list_selectProjectByStyle_sn(long style_sn);
	public List<PanoProjectPackage> list_selectPackageByHouse_sn(long house_sn);
	public List<pano_mem_user> get_selectMUserByPhone(String phone);
	public List<PanoProjectPackageType> list_selectPackageTypeListByPackage_Sn(
			long house_package_sn);
	public List<PanoProjectPackage> get_selectPackageByPackage_sn(
			long package_sn);
	public List<AddToCar> get_selectAddToCar(long house_package_sn);
	public void add_ShopCar(long USER_SN,long house_package_sn);
	public List<AddToCar> get_selectAddToCar2(long user_sn);
	public List<Product> list_selectProductListByPAT_sn(long packageType_sn);
	public List<Product> list_selectProductByPackageType_sn(long packageType_sn);
	public List<AddToCar> selectCarByPackage_sn(long package_sn);
	public void delete_shopCarByHouse_package_sn(long house_package_sn);
	public List<pano_order_item> list_selectProductListByPackage_sn(long package_sn);
	public void insert_item(long order_sn,long house_package_sn);
	public void insert_logtc(String id,long order_sn);
	public void insert_order(String order_num,String order_time,
			int status,long address_sn,long user_sn,BigDecimal total_price);
	public pano_order get_order_snByOrder_num(String ORDER_NUM);
	public long get_address_snByUser_sn(long user_sn);
	public List<AddToCar> get_selectAddToCarToConfirm(
			long USER_SN,String order_num);
	public long get_House_package_snByPackage_sn(long package_sn);
	public List<panoSkin> list_selectPanoSkinList();
	public void insert_UserMsg_Phone(String MOBILE);
	public List<pano_order> get_selectOrderByHouse_Pack_Sn(long house_pack_sn);
	public void insert_Merge(String ORDER_NUM,String All_order_num);
	public void update_orderStatus(int STATUS,String ORDER_NUM);
	
}













