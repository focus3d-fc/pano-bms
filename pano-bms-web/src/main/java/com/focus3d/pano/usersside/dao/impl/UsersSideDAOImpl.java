package com.focus3d.pano.usersside.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.User;
import com.focus3d.pano.model.pano_mem_user;
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
			long package_sn) {
		List<PanoProjectPackageType> packageTypeList=(List<PanoProjectPackageType>) getSqlMapClientTemplate().
				queryForList("list_selectPackageTypeListByPackage_Sn",package_sn);
		return packageTypeList;
	}



	
	
	
	
	
	
	
	
}












