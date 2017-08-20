package com.focus3d.pano.admin.dao;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_house_style;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.project_style;

public interface HousesDAO {

	// ----------------------------------------------楼盘管理----------------------------------------------

	// 查询记录数
	public int selHousesCount();

	// 楼盘管理查询
	public List<pano_project> getHouses(Page page);

	// 楼盘管理删除
	public int delHousesbySN(Long SN);

	// 楼盘管理增加
	public void addHouses(pano_project houses);

	// 楼盘管理搜索
	public List<pano_project> selHouses(pano_project houses);

	// 按照SN查询信息
	public List<pano_project> selHousesbySN(Long SN);

	// 楼盘管理修改
	public void upHouse(pano_project houses);

	// 根据名称查楼盘
	public List<pano_project> selHousesbyName(String NAME);

	// ----------------------------------------------楼盘-户型----------------------------------------------

	// 户型查询
	public List<pano_project_house> getHousetype(Long PROJECT_SN);

	// 户型删除
	public int delHousetypebySN(Long SN);

	// 户型新增
	public void addHousetype(pano_project_house house);

	// 户型修改
	public void upHousetype(pano_project_house house);

	// 根据SN查户型
	public pano_project_house getHousetypebySN(Long SN);

	// ----------------------------------------------楼盘-风格----------------------------------------------

	// 风格查询
	public List<project_style> getHousestyle(Long PROJECT_SN);

	// 风格删除
	public int delHousestyle(Long SN);

	// 根据SN查风格
	public List<project_style> getHousestylebySN(Long SN);

	// 查询所有风格
	public List<project_style> getAllHousestyle();

	// 风格添加
	public void addHousestyle(project_style style);

	// ----------------------------------------------楼盘-广告----------------------------------------------

	// 广告查询
	public List<pano_ad> getHousead();

	// 广告删除
	public int delHousead(Long SN);

	// 广告添加
	public void addHousead(pano_ad ad);

	// 根据SN查广告
	public pano_ad getHouseadbySN(Long SN);

	// 广告修改
	public void upHousead(pano_ad ad);

	// ----------------------------------------------楼盘-户型-空间设置----------------------------------------------

	// 根据SN查户型
	public List<pano_project_house> selHousetypebySN(Long SN);

	// 查询空间信息
	public List<pano_project_space> getspace(Long HOUSE_SN);

	// 空间删除
	public int delroomSet(Long SN);

	// 空间添加
	public void addroomSet(pano_project_space space);

	// 根据sn查询空间
	public pano_project_space selSpacebySN(Long SN);

	// 空间修改
	public void uproomSet(pano_project_space space);

	// -----------------------楼盘-设置-风格-户型设置-----------------------

	// 查询户型风格
	public List<pano_project_house_style> selHouseStyles();

	// 根据风格查户型
	public List<pano_project_house> selHousebyStyle(
			pano_project_house_style style);

	// 删除风格户型关联
	public int delstylehouseSet(pano_project_house_style style);

	// 清空关联
	public int clearStyleHouse(pano_project_house_style style);

	// 添加关联
	public void addStyleHouse(pano_project_house_style style);

	// 查询户型风格SN
	public List<pano_project_house_style> selHouseStyle(Map map);

	// 修改户型风格
	public void upHouseStyle(pano_project_house_style hs);

	// -----------------------楼盘-设置-风格-标签设置-----------------------

	// 标签查询
	public List<pano_project_label> getLablebyStyle(Long STYLE_SN);

	// 标签删除
	public int delLable(Long SN);

	// 标签添加
	public void addLable(pano_project_label lable);

}
