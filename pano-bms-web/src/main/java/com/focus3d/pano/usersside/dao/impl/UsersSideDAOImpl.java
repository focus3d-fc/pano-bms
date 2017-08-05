package com.focus3d.pano.usersside.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.User;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
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
		List<Style> styleList=(List<Style>) getSqlMapClientTemplate().
				queryForList("selectStyleByProject_sn",project_sn);
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



	
	
	
	
	
	
	
	
}












