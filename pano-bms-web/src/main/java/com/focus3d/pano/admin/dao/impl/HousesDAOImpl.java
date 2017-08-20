package com.focus3d.pano.admin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.HousesDAO;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_house_style;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.project_style;

@Repository
public class HousesDAOImpl extends BaseDao implements HousesDAO {

	@Override
	public List<pano_project> getHouses(Page page) {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.getHouses", page);
		return list;
	}

	@Override
	public int delHousesbySN(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate()
				.delete("pano_project.delHousesbySN", SN);
		return row;
	}

	@Override
	public void addHouses(pano_project houses) {
		getSqlMapClientTemplate().insert("pano_project.addHouses", houses);
	}

	@Override
	public List<pano_project> selHouses(pano_project houses) {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.selHouses", houses);
		return list;
	}

	@Override
	public List<pano_project_house> getHousetype(Long PROJECT_SN) {
		List<pano_project_house> list = (List<pano_project_house>) getSqlMapClientTemplate()
				.queryForList("pano_project_house.getHousetype", PROJECT_SN);
		return list;
	}

	@Override
	public int delHousetypebySN(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete(
				"pano_project_house.delHousetypebySN", SN);
		return row;
	}

	@Override
	public List<project_style> getHousestyle(Long PROJECT_SN) {
		List<project_style> list = (List<project_style>) getSqlMapClientTemplate()
				.queryForList("pano_project_style.getHousestyle", PROJECT_SN);
		return list;
	}

	@Override
	public int delHousestyle(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete(
				"pano_project_style.delHousestyle", SN);
		return row;
	}

	@Override
	public List<pano_ad> getHousead() {
		List<pano_ad> list = (List<pano_ad>) getSqlMapClientTemplate()
				.queryForList("pano_ad.getHousead");
		return list;
	}

	@Override
	public int delHousead(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete("pano_ad.delHousead", SN);
		return row;
	}

	@Override
	public List<pano_project> selHousesbySN(Long SN) {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.selHousesbySN", SN);
		return list;
	}

	@Override
	public List<pano_project_space> getspace(Long HOUSE_SN) {
		List<pano_project_space> list = (List<pano_project_space>) getSqlMapClientTemplate()
				.queryForList("pano_project_space.getspace", HOUSE_SN);
		return list;
	}

	@Override
	public List<pano_project_house> selHousetypebySN(Long SN) {
		List<pano_project_house> list = (List<pano_project_house>) getSqlMapClientTemplate()
				.queryForList("pano_project_house.selHousetypebySN", SN);
		return list;
	}

	@Override
	public int delroomSet(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete("pano_project_space.delroomSet",
				SN);
		return row;
	}

	@Override
	public void addroomSet(pano_project_space space) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate()
				.insert("pano_project_space.addroomSet", space);
	}

	@Override
	public int selHousesCount() {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"pano_project.selHousesCount");
		return count;
	}

	@Override
	public pano_project_space selSpacebySN(Long SN) {
		pano_project_space space = (pano_project_space) getSqlMapClientTemplate()
				.queryForObject("pano_project_space.selSpacebySN", SN);
		return space;
	}

	@Override
	public void uproomSet(pano_project_space space) {
		getSqlMapClientTemplate().update("pano_project_space.uproomSet", space);

	}

	@Override
	public void upHouse(pano_project houses) {
		getSqlMapClientTemplate().update("pano_project.upHouse", houses);
	}

	@Override
	public void addHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("pano_project_house.addHousetype",
				house);
	}

	@Override
	public void upHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("pano_project_house.upHousetype",
				house);
	}

	@Override
	public List<pano_project_label> getLablebyStyle(Long STYLE_SN) {
		List<pano_project_label> list = (List<pano_project_label>) getSqlMapClientTemplate()
				.queryForList("pano_project_label.getLablebyStyle", STYLE_SN);
		return list;
	}

	@Override
	public List<project_style> getHousestylebySN(Long SN) {
		List<project_style> list = (List<project_style>) getSqlMapClientTemplate()
				.queryForList("pano_project_style.getHousestylebySN", SN);
		return list;
	}

	@Override
	public int delLable(Long SN) {
		int row = -1;
		row = getSqlMapClientTemplate().delete("pano_project_label.delLable",
				SN);
		return row;
	}

	@Override
	public void addLable(pano_project_label lable) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("pano_project_label.addLable", lable);
	}

	@Override
	public List<pano_project_house> selHousebyStyle(
			pano_project_house_style style) {
		List<pano_project_house> list = (List<pano_project_house>) getSqlMapClientTemplate()
				.queryForList("pano_project_house_style.selHousebyStyle", style);
		return list;
	}

	@Override
	public int delstylehouseSet(pano_project_house_style style) {
		int row = -1;
		row = getSqlMapClientTemplate().delete(
				"pano_project_house_style.delstylehouseSet", style);
		return row;
	}

	@Override
	public int clearStyleHouse(pano_project_house_style style) {
		int row = -1;
		row = getSqlMapClientTemplate().delete(
				"pano_project_house_style.clearStyleHouse", style);
		return row;
	}

	@Override
	public List<project_style> getAllHousestyle() {
		List<project_style> list = (List<project_style>) getSqlMapClientTemplate()
				.queryForList("pano_project_style.getAllHousestyle");
		return list;
	}

	@Override
	public void addHousestyle(project_style style) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("pano_project_style.addHousestyle",
				style);
	}

	@Override
	public void addHousead(pano_ad ad) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("pano_ad.addHousead", ad);
	}

	@Override
	public pano_ad getHouseadbySN(Long SN) {
		pano_ad ad = (pano_ad) getSqlMapClientTemplate().queryForObject(
				"pano_ad.getHouseadbySN", SN);
		return ad;
	}

	@Override
	public void upHousead(pano_ad ad) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("pano_ad.upHousead", ad);
	}

	@Override
	public pano_project_house getHousetypebySN(Long SN) {
		pano_project_house ht = (pano_project_house) getSqlMapClientTemplate()
				.queryForObject("pano_project_house.getHousetypebySN", SN);
		return ht;
	}

	@Override
	public void addStyleHouse(pano_project_house_style style) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert(
				"pano_project_house_style.addStyleHouse", style);
	}

	@Override
	public List<pano_project> selHousesbyName(String NAME) {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.selHousesbyName", NAME);
		return list;
	}

	@Override
	public List<pano_project_house_style> selHouseStyle(Map map) {
		List<pano_project_house_style> list = (List<pano_project_house_style>) getSqlMapClientTemplate()
				.queryForList("pano_project_house_style.selHouseStyle", map);
		return list;
	}

	@Override
	public List<pano_project_house_style> selHouseStyles() {
		List<pano_project_house_style> list = (List<pano_project_house_style>) getSqlMapClientTemplate()
				.queryForList("pano_project_house_style.selHouseStyles");
		return list;
	}

	@Override
	public void upHouseStyle(pano_project_house_style hs) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update(
				"pano_project_house_style.upHouseStyle", hs);
	}

}
