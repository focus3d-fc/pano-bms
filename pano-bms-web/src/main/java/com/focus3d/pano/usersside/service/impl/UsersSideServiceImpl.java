package com.focus3d.pano.usersside.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.UserDao;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_mem_user;
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
	public List<Long> selectAdImg_sn() {
		return usersSideDAO.selectAdImg_sn();
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
			long package_sn) {
		return usersSideDAO.list_selectPackageTypeListByPackage_Sn(package_sn);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}















