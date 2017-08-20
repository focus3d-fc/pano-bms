package com.focus3d.pano.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PanoProductFuncDAO;
import com.focus3d.pano.admin.service.PanoProductFuncService;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_project_style;
@Service
public class PanoProductFuncServiceImpl implements PanoProductFuncService{


	@Autowired
	private PanoProductFuncDAO productAdmDAO;

	
	/**
	 * 分类
	 */
	public List<PanoProductType> getBasics() {
		return productAdmDAO.getBasics();
	
	}

	public Long getInsert(String name) {
		return productAdmDAO.getInsert(name);
	}
 

	public int getDelete(int sn) {

		return	productAdmDAO.getDelete(sn);
	}
	
	
	public int getUpdate(PanoProductType p){
		System.out.println("1");
		return productAdmDAO.getUpdate(p);
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

	
	
	/**
	 * 功能
	 */
	@Override
	public List<PanoProductFunc> getBasics4() {
		return productAdmDAO.getBasics4();
	}

	public Long getInsert4(String name) {
		return productAdmDAO.getInsert4(name);
	}
	
	@Override
	public int getDelete4(int sn) {
		return	productAdmDAO.getDelete4(sn);
	}
	public int getUpdate4(PanoProductFunc p){
		return productAdmDAO.getUpdate4(p);
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

	
}
