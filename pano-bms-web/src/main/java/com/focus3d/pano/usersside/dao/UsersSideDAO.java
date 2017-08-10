package com.focus3d.pano.usersside.dao;

import java.util.List;

import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;

public interface UsersSideDAO {

	public List<Long> selectAdImg_sn();
	public List<Style> selectStyleByProject_sn(long project_sn);
	public List<Lable> selectLableByStyle_sn(Long style_sn);
	public List<pano_project> list_SelectprojectList(pano_project pano_project);
	public List<pano_project> list_SelectprojectList2(pano_project pano_project);
	public List<pano_project_house> get_selectHouseListByStyle_sn(long style_sn);
	public List<pano_project> get_projectList();
	public List<PanoProjectPackage> get_selectPackageListByStyle_sn(long style_sn);
	public List<pano_project_space> list_selectSpaceNameListByHouse_sn(long house_sn);
    public List<pano_project> list_selectProjectByStyle_sn(long style_sn);
    public List<PanoProjectPackage> list_selectPackageByHouse_sn(long house_sn);
    public List<pano_mem_user> get_selectMUserByPhone(String phone);
    public List<PanoProjectPackageType> list_selectPackageTypeListByPackage_Sn(long package_sn);



}






