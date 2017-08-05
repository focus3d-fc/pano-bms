package com.focus3d.pano.usersside.service;

import java.util.List;

import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;

public interface UsersSideService {
	public List<Long> selectAdImg_sn();
	public List<Style> selectStyleByProject_sn(long project_sn);
	public List<Lable> selectLableByStyle_sn(Long style_sn);
	public List<pano_project> list_SelectprojectList(
			String province,String city,String area);
	public List<pano_project> list_SelectprojectList2(
			String province,String city,String area,String project_name);
	public List<pano_project_house> get_selectHouseListByStyle_sn(long style_sn);
	public List<pano_project> get_projectList();
	
	
	
	
}













