package com.focus3d.pano.usersside.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.AddToCar;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Pano_Order_Shopcart;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_order_item;
import com.focus3d.pano.model.pano_order_logtc;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.usersside.dao.UsersSideDAO;
@Repository
public class UsersSideDAOImpl  extends BaseDao implements UsersSideDAO{
//List<User> userList=(List<User>) getSqlMapClientTemplate().queryForList("limit",page);
	@Override
	public List<Long> selectAdImg_sn() {
		List<Long> AdImg_snList=(List<Long>) getSqlMapClientTemplate().
				queryForList("selectAdImg_sn");
		return AdImg_snList;
	}

	@Override
	public List<Style> selectStyleByProject_sn(long project_sn) {
		System.out.println("1.DAOImpl查询风格project_sn:"+project_sn);
		List<Style> styleList=(List<Style>) getSqlMapClientTemplate().
				queryForList("selectStyleByProject_sn",project_sn);
		System.out.println("2.DAOImpl查询风格");
		return styleList;
	}

	@Override
	public List<Lable> selectLableByStyle_sn(Long style_sn) {
		System.out.println("1.查询style_sn:"+style_sn);
		List<Lable> lableList=(List<Lable>) getSqlMapClientTemplate().
				queryForList("selectStyleByProject_sn",style_sn);
		System.out.println("2.查询标签，进入DAO");
		return lableList;
	}

	@Override
	public List<pano_project> list_SelectprojectList(pano_project pano_project) {
		List<pano_project> projectList=(List<pano_project>) getSqlMapClientTemplate().
				queryForList("list_SelectprojectList",pano_project);
		return projectList;
	}

	@Override
	public List<pano_project> list_SelectprojectList2(pano_project pano_project) {
		List<pano_project> projectList2=(List<pano_project>) getSqlMapClientTemplate().
				queryForList("list_SelectprojectList2",pano_project);
		return projectList2;
	}

	@Override
	public List<pano_project_house> get_selectHouseListByStyle_sn(long style_sn) {
		List<pano_project_house> houseList=(List<pano_project_house>) getSqlMapClientTemplate().
				queryForList("get_selectHouseListByStyle_sn",style_sn);
		return houseList;
	}

	@Override
	public List<pano_project> get_projectList() {
		List<pano_project> projectList3=(List<pano_project>) getSqlMapClientTemplate().
				queryForList("get_projectList");
		return projectList3;
	}

	@Override
	public List<PanoProjectPackage> get_selectPackageListByStyle_sn(
			long style_sn) {
		List<PanoProjectPackage> packageList=(List<PanoProjectPackage>) getSqlMapClientTemplate().
				queryForList("get_selectPackageListByStyle_sn",style_sn);
		return packageList;
	}

	@Override
	public List<pano_project_space> list_selectSpaceNameListByHouse_sn(
			long house_sn) {
		
		List<pano_project_space> spaceList=(List<pano_project_space>) getSqlMapClientTemplate().
				queryForList("list_selectSpaceNameListByHouse_sn",house_sn);
		return spaceList;
	}

	@Override
	public List<pano_project> list_selectProjectByStyle_sn(long style_sn) {
		List<pano_project> projectList=(List<pano_project>) getSqlMapClientTemplate().
				queryForList("list_selectProjectByStyle_sn",style_sn);

		return projectList;
	}

	@Override
	public List<PanoProjectPackage> list_selectPackageByHouse_sn(long house_sn) {
		List<PanoProjectPackage> packageList=(List<PanoProjectPackage>) getSqlMapClientTemplate().
				queryForList("list_selectPackageByHouse_sn",house_sn);
		return packageList;
	}

	@Override
	public List<pano_mem_user> get_selectMUserByPhone(String phone) {
		List<pano_mem_user> muserList_only=(List<pano_mem_user>) getSqlMapClientTemplate().
				queryForList("get_selectMUserByPhone",phone);
		return muserList_only;
	}

	@Override
	public List<PanoProjectPackageType> list_selectPackageTypeListByPackage_Sn(
			long house_package_sn) {
		List<PanoProjectPackageType> packageTypeList=(List<PanoProjectPackageType>) getSqlMapClientTemplate().
				queryForList("list_selectPackageTypeListByPackage_Sn",house_package_sn);
		return packageTypeList;
	}

	@Override
	public List<PanoProjectPackage> get_selectPackageByPackage_sn(
			long package_sn) {
		List<PanoProjectPackage> packageList_only=(List<PanoProjectPackage>) getSqlMapClientTemplate().
				queryForList("get_selectPackageByPackage_sn",package_sn);
		return packageList_only;
	}

	@Override
	public List<AddToCar> get_selectAddToCar(long house_package_sn) {
		List<AddToCar> addToCarList_only=(List<AddToCar>) getSqlMapClientTemplate().
				queryForList("get_selectAddToCar",house_package_sn);
		return addToCarList_only;
	}

	@Override
	public void add_ShopCar(Pano_Order_Shopcart shopcart) {
		getSqlMapClientTemplate().insert("add_ShopCar",shopcart);
	}
	@Override
	public List<AddToCar> get_selectAddToCar2(long user_sn) {
		List<AddToCar> addToCarList_only2=(List<AddToCar>) getSqlMapClientTemplate().
				queryForList("get_selectAddToCar2",user_sn);
		return addToCarList_only2;
	}

	@Override
	public List<Product> list_selectProductListByPAT_sn(long packageType_sn) {
		List<Product> PanoProductList=(List<Product>) getSqlMapClientTemplate().
				queryForList("list_selectProductListByPAT_sn",packageType_sn);
		return PanoProductList;
	}

	@Override
	public List<Product> list_selectProductByPackageType_sn(long packageType_sn) {
		List<Product> productList_pro=(List<Product>) getSqlMapClientTemplate().
				queryForList("list_selectProductByPackageType_sn",packageType_sn);
		return productList_pro;
	}

	@Override
	public List<AddToCar> selectCarByPackage_sn(long package_sn) {
		List<AddToCar> packageList_only=(List<AddToCar>) getSqlMapClientTemplate().
				queryForList("selectCarByPackage_sn",package_sn);
		return packageList_only;
	}

	@Override
	public void delete_shopCarByHouse_package_sn(long house_package_sn) {
		getSqlMapClientTemplate().
		    delete("delete_shopCarByHouse_package_sn",house_package_sn);
	}

	@Override
	public List<pano_order_item> list_selectProductListByPackage_sn(
			long package_sn) {
		List<pano_order_item> itemList=(List<pano_order_item>) getSqlMapClientTemplate().
				queryForList("list_selectProductListByPackage_sn",package_sn);
		return itemList;
	}

	@Override
	public void insert_item(pano_order_item item) {
		System.out.println("1.DAOImpl:item");
		getSqlMapClientTemplate().insert("insert_item",item);
		System.out.println("2.DAOImpl:item");
	}

	@Override
	public void insert_logtc(pano_order_logtc logtc) {
		getSqlMapClientTemplate().insert("insert_logtc",logtc);
	}

	@Override
	public void insert_order(pano_order order) {
		getSqlMapClientTemplate().insert("insert_order",order);
	}

	@Override
	public pano_order get_order_snByOrder_num(String ORDER_NUM) {
		pano_order order=(pano_order) getSqlMapClientTemplate().
				queryForObject("get_order_snByOrder_num",ORDER_NUM);
		return order;
	}

	@Override
	public long get_address_snByUser_sn(long user_sn) {
		long address_sn=(Long) getSqlMapClientTemplate().
				queryForObject("get_address_snByUser_sn",user_sn);
		return address_sn;
	}

	@Override
	public List<AddToCar> get_selectAddToCarToConfirm(pano_order order) {
		List<AddToCar> addToCarList_toConfirm=(List<AddToCar>) getSqlMapClientTemplate().
				queryForList("get_selectAddToCarToConfirm",order);
		return addToCarList_toConfirm;
	}

	@Override
	public long get_House_package_snByPackage_sn(long package_sn) {
		long house_package_sn=(Long) getSqlMapClientTemplate().
				queryForObject("get_House_package_snByPackage_sn",package_sn);
		return house_package_sn;
	}
	



	
	
	
	
	
	
	
	
}












