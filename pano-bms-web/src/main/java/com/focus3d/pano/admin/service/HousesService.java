package com.focus3d.pano.admin.service;

import java.util.List;

import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_style;

public interface HousesService {

	// ----------------------------------------------楼盘管理----------------------------------------------

	// 楼盘管理查询
	public List<pano_project> getHouses();

	// 楼盘管理删除
	public int delHousesbySN(Long SN);

	// 楼盘管理增加
	public void addHouses(pano_project houses);

	// 楼盘管理搜索
	public List<pano_project> selHouses(pano_project houses);

	// 按照SN查询信息
	public List<pano_project> selHousesbySN(Long SN);

	// ----------------------------------------------楼盘-户型----------------------------------------------

	// 户型查询
	public List<pano_project_house> getHousetype(Long PROJECT_SN);

	// 户型删除
	public int delHousetypebySN(Long SN);

	// ----------------------------------------------楼盘-风格----------------------------------------------

	// 风格查询
	public List<pano_project_style> getHousestyle();

	// 风格删除
	public int delHousestyle();

	// ----------------------------------------------楼盘-广告----------------------------------------------

	// 广告查询
	public List<pano_ad> getHousead();

	// 广告删除
	public int delHousead();

}
