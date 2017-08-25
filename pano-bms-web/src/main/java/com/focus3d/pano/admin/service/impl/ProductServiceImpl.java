package com.focus3d.pano.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.IProductDAO;
import com.focus3d.pano.admin.service.IProductService;
import com.focus3d.pano.model.ProductFeature;
import com.focus3d.pano.model.ProductClassify;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_project_style;
@Service
public class ProductServiceImpl implements IProductService{


	@Autowired
	private IProductDAO productAdmDAO;

	
	/**
	 * 分类
	 */
	public List<ProductClassify> QueryClassify() {
		return productAdmDAO.QueryClassify();
	
	}

	public Long InsertClassify(String name) {
		return productAdmDAO.InsertClassify(name);
	}
 
	public int getDelete(int sn) {

		return	productAdmDAO.getDelete(sn);
	}
	
	
	public int getUpdate(ProductClassify p){
		return productAdmDAO.getUpdate(p);
	}
	public ProductClassify getselect(int sn){
		ProductClassify panoSkin = null;
		 List<ProductClassify> getselect4 = productAdmDAO.getselect(sn);
		 if(getselect4.size() >0 ){
			 panoSkin = getselect4.get(0);
		 }
		return panoSkin;
	}


	
	

	/**
	 * 套餐
	 */
	@Override
	public List<PanoProjectPackage> getBasics1() {
		return productAdmDAO.getBasics1();
	}

	public Long getInsert1(PanoProjectPackage pano) {
		return productAdmDAO.getInsert1(pano);
	}
	
	@Override
	public int getDelete1(int sn) {
		return	productAdmDAO.getDelete1(sn);
	}
	
	public int getUpdate1(PanoProjectPackage p){
		return productAdmDAO.getUpdate1(p);
	}
	
	public PanoProjectPackage getupdatas1(int sn){
		PanoProjectPackage panoProjectPackage = null;
		List<PanoProjectPackage> getupdatas1 = productAdmDAO.getupdatas1(sn);
		if(getupdatas1.size()>0){
			System.out.println("service");
		 panoProjectPackage = getupdatas1.get(0);
		}
		return panoProjectPackage;
	}
	
	
	public PanoProjectPackage getselect1(int sn){
		PanoProjectPackage panoSkin = null;
		 List<PanoProjectPackage> getselect4 = productAdmDAO.getselect1(sn);
		 if(getselect4.size() >0 ){
			 panoSkin = getselect4.get(0);
		 }
		return panoSkin;
	}
	
	
	
	
	/**
	 * 厂家
	 */
	@Override
	public List<PanoVender> getBasics2() {
		return productAdmDAO.getBasics2();
	}

	public Long getInsert2(String name) {
		return productAdmDAO.getInsert2(name);
	}
	
	@Override
	public int getDelete2(int sn) {
		return	productAdmDAO.getDelete2(sn);
	}
	public int getUpdate2(PanoVender p){
		System.out.println("1");
		return productAdmDAO.getUpdate2(p);
	}
	
	public PanoVender getselect2(int sn){
		PanoVender panoSkin = null;
		 List<PanoVender> getselect4 = productAdmDAO.getselect2(sn);
		 if(getselect4.size() >0 ){
			 panoSkin = getselect4.get(0);
		 }
		return panoSkin;
	}

	
	/**
	 * 风格
	 */
	@Override
	public List<pano_project_style> getBasics3() {
		return productAdmDAO.getBasics3();
	}

	public Long getInsert3(pano_project_style style) {
		return productAdmDAO.getInsert3(style);
	}
	
	@Override
	public int getDelete3(int sn) {
		return	productAdmDAO.getDelete3(sn);
	}
	public int getUpdate3(pano_project_style p){
		System.out.println("1");
		return productAdmDAO.getUpdate3(p);
	}
	
	public pano_project_style getselect3(int sn){
		pano_project_style panoSkin = null;
		 List<pano_project_style> getselect4 = productAdmDAO.getselect3(sn);
		 if(getselect4.size() >0 ){
			 panoSkin = getselect4.get(0);
		 }
		return panoSkin;
	}
	
	
	
	
	/**
	 * 功能
	 */
	@Override
	public List<ProductFeature> getBasics4() {
		return productAdmDAO.getBasics4();
	}

	public Long getInsert4(String name) {
		return productAdmDAO.getInsert4(name);
	}
	
	@Override
	public int getDelete4(int sn) {
		return	productAdmDAO.getDelete4(sn);
	}
	public int getUpdate4(ProductFeature p){
		return productAdmDAO.getUpdate4(p);
	}
	public ProductFeature getselect4(int sn){
		ProductFeature panoSkin = null;
		 List<ProductFeature> getselect4 = productAdmDAO.getselect4(sn);
		 if(getselect4.size() >0 ){
			 panoSkin = getselect4.get(0);
		 }
		return panoSkin;
	}
	
	
	
	/**
	 * 导航
	 */
	@Override
	public List<panoSkin> getBasics5() {
		return productAdmDAO.getBasics5();
	}

	public Long getInsert5(panoSkin pano) {
		return productAdmDAO.getInsert5(pano);
	}
	
	@Override
	public int getDelete5(int sn) {
		return	productAdmDAO.getDelete5(sn);
	}
	
	public int getUpdate5(panoSkin p){
		return productAdmDAO.getUpdate5(p);
	}
	
	public panoSkin getupdatas5(int sn){
		panoSkin panoProjectPackage = null;
		List<panoSkin> getupdatas1 = productAdmDAO.getupdatas5(sn);
		if(getupdatas1.size()>0){
			System.out.println("service");
		 panoProjectPackage = getupdatas1.get(0);
		}
		return panoProjectPackage;
	}

	public panoSkin getselect5(int sn){
		panoSkin panoSkin = null;
		 List<panoSkin> getselect5 = productAdmDAO.getselect5(sn);
		 if(getselect5.size() >0 ){
			 panoSkin = getselect5.get(0);
		 }
		return panoSkin;
	}
	
}
