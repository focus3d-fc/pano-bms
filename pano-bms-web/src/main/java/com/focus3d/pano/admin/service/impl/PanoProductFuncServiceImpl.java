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

	public Long getInsert1(String name) {
		return productAdmDAO.getInsert1(name);
	}
	
	@Override
	public int getDelete1(int sn) {
		return	productAdmDAO.getDelete1(sn);
	}
	
	public int getUpdate1(PanoProjectPackage p){
		System.out.println("1");
		return productAdmDAO.getUpdate1(p);
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

	public Long getInsert3(String name) {
		return productAdmDAO.getInsert3(name);
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
}
