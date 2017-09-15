package com.focus3d.pano.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.HousesDAO;
import com.focus3d.pano.admin.dao.IProductAdmDAO;
import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_house_style;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.project_style;

@Service("housesService")
public class HousesServiceImpl implements HousesService {

	@Autowired
	private HousesDAO housesDAO;
	
	@Autowired
	private IProductAdmDAO productDAO;

	@Override
	public List<pano_project> getHouses(Page page) {
		// TODO Auto-generated method stub
		return housesDAO.getHouses(page);
	}

	@Override
	public int delHousesbySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousesbySN(SN);
	}

	@Override
	public void addHouses(pano_project houses) {
		// TODO Auto-generated method stub
		housesDAO.addHouses(houses);
	}

	@Override
	public List<pano_project> selHouses(pano_project houses) {
		// TODO Auto-generated method stub
		return housesDAO.selHouses(houses);
	}

	@Override
	public List<pano_project_house> getHousetype(Long PROJECT_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousetype(PROJECT_SN);
	}

	@Override
	public int delHousetypebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousetypebySN(SN);
	}

	@Override
	public List<project_style> getHousestyle(Long PROJECT_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousestyle(PROJECT_SN);
	}

	@Override
	public int delHousestyle(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousestyle(SN);
	}

	@Override
	public List<pano_ad> getHousead(Long PROJECT_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousead(PROJECT_SN);
	}

	@Override
	public int delHousead(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousead(SN);
	}

	@Override
	public List<pano_project> selHousesbySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selHousesbySN(SN);
	}

	@Override
	public List<pano_project_space> getspace(Long HOUSE_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getspace(HOUSE_SN);
	}

	@Override
	public List<pano_project_house> selHousetypebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selHousetypebySN(SN);
	}

	@Override
	public int delroomSet(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delroomSet(SN);
	}

	@Override
	public void addroomSet(pano_project_space space) {
		// TODO Auto-generated method stub
		housesDAO.addroomSet(space);
	}

	@Override
	public int selHousesCount() {
		// TODO Auto-generated method stub
		return housesDAO.selHousesCount();
	}

	@Override
	public pano_project_space selSpacebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selSpacebySN(SN);
	}

	@Override
	public void uproomSet(pano_project_space space) {
		// TODO Auto-generated method stub
		housesDAO.uproomSet(space);
	}

	@Override
	public void upHouse(pano_project houses) {
		// TODO Auto-generated method stub
		housesDAO.upHouse(houses);
	}

	@Override
	public void addHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		housesDAO.addHousetype(house);
	}

	@Override
	public void upHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		housesDAO.upHousetype(house);
	}

	@Override
	public List<pano_project_label> getLablebyStyle(Long STYLE_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getLablebyStyle(STYLE_SN);
	}

	@Override
	public List<project_style> getHousestylebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousestylebySN(SN);
	}

	@Override
	public int delLable(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delLable(SN);
	}

	@Override
	public void addLable(pano_project_label lable) {
		// TODO Auto-generated method stub
		housesDAO.addLable(lable);
	}

	@Override
	public List<pano_project_house> selHousebyStyle(
			pano_project_house_style style) {
		// TODO Auto-generated method stub
		return housesDAO.selHousebyStyle(style);
	}

	@Override
	public int delstylehouseSet(pano_project_house_style style) {
		// TODO Auto-generated method stub
		return housesDAO.delstylehouseSet(style);
	}

	@Override
	public int clearStyleHouse(pano_project_house_style style) {
		// TODO Auto-generated method stub
		return housesDAO.clearStyleHouse(style);
	}

	@Override
	public List<project_style> getAllHousestyle() {
		// TODO Auto-generated method stub
		return housesDAO.getAllHousestyle();
	}

	@Override
	public void addHousestyle(project_style style) {
		// TODO Auto-generated method stub
		housesDAO.addHousestyle(style);
	}

	@Override
	public void addHousead(pano_ad ad) {
		// TODO Auto-generated method stub
		housesDAO.addHousead(ad);
	}

	@Override
	public pano_ad getHouseadbySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHouseadbySN(SN);
	}

	@Override
	public void upHousead(pano_ad ad) {
		// TODO Auto-generated method stub
		housesDAO.upHousead(ad);
	}

	@Override
	public pano_project_house getHousetypebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousetypebySN(SN);
	}

	@Override
	public void addHouseStyle() {
		// TODO Auto-generated method stub
		List<pano_project_house_style> hs = housesDAO.selHouseStyles();
		for (int style = 0; style < hs.size() - 1; style++) {
			pano_project_house_style sh = new pano_project_house_style();
			pano_project_house_style sh2 = new pano_project_house_style();
			sh.setSTYLE_SN(hs.get(style + 1).getSTYLE_SN());
			sh.setSN(hs.get(style).getSN());
			housesDAO.upHouseStyle(sh);
			sh2.setSTYLE_SN(hs.get(style).getSTYLE_SN());
			sh2.setSN(hs.get(style + 1).getSN());
			housesDAO.upHouseStyle(sh2);
		}
	}

	@Override
	public void addStyleHouse(pano_project_house_style style) {
		// TODO Auto-generated method stub
		housesDAO.addStyleHouse(style);
	}

	@Override
	public List<pano_project> selHousesbyName(String NAME) {
		// TODO Auto-generated method stub
		return housesDAO.selHousesbyName(NAME);
	}

	@Override
	public List<pano_project_house_style> selHouseStyle(Map map) {
		// TODO Auto-generated method stub
		return housesDAO.selHouseStyle(map);
	}

	@Override
	public List<pano_project_house_style> selHouseStyles() {
		// TODO Auto-generated method stub
		return housesDAO.selHouseStyles();
	}

	@Override
	public void upHouseStyle(pano_project_house_style hs) {
		// TODO Auto-generated method stub
		housesDAO.upHouseStyle(hs);
	}

	@Override
	public void QueryAllPackage() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<HashMap<String,Object>>  QueryPackageDetail(String packageSn){
		return housesDAO.QueryPackageDetail(packageSn);
	}

	@Override
	public List<Map<String,Object>> QueryHouseStylePackage(PanoProjectPackageStyle panoProjectPackageStyle) {
		// TODO Auto-generated method stub
			return housesDAO.QueryHouseStylePackage(panoProjectPackageStyle);
	}
	
	@Override
	public List<Map<String,Object>> QueryHouseStylePacakgeType(Long housePackageSn){
		return housesDAO.QueryHouseStylePacakgeType(housePackageSn);
	}
	
	@Override
	public List<Map<String,Object>> QueryTypeSurplusSpace(Long houseSn){
		List<Map<String,Object>> list = housesDAO.QueryTypeSurplusSpace(houseSn);
		return list;
	}

	@Override
	public List<Map<String, Object>> getTypeProducts(Long packageTypeSn) {
		List<Map<String, Object>> list  = housesDAO.GetTypeProducts(packageTypeSn);
		return list;
	}
	
	@Override
	public List<ProductInfo> QueryProducts(Map<String,Object> map){
		List<ProductInfo> list = productDAO.listProductInfo(map);
		return list;
	}
	
	@Override
	public Integer QueryProductsCount(Map<String,Object> map){
		int count = productDAO.countProductInfo(map);
		return count;
	}
	
	@Override
	public void insertTypeProduct(Map<String, Object> map){
		housesDAO.insertTypeProduct(map);
	}
	
	@Override
	public void setProductNum(Map<String, Object> map){
		housesDAO.setProductNum(map);
	}
	
	@Override
	public HashMap<String,Object> queryProductDetail(Map<String,Object> map){
		 return housesDAO.queryProductDetail(map);
	}

	@Override
	public void deleteTypeProduct(Long packageProductSn) {
		// TODO Auto-generated method stub
		housesDAO.deleteTypeProduct(packageProductSn);
	}

	@Override
	public void upHouseStyleImg(pano_project_house_style hs) {
		// TODO Auto-generated method stub
		housesDAO.upHouseStyleImg(hs);
	}
	
	@Override
	public pano_project_house_style QueryHouseStyleBySn(Map<String,Object> map){
		return housesDAO.QueryHouseStyleBySn(map);
	}

	@Override
	public void publishHouse(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		housesDAO.publishHouse(map);
	}
}
