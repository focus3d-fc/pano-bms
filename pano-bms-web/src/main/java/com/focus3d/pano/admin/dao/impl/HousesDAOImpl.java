package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.HousesDAO;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_style;

@Repository
public class HousesDAOImpl extends BaseDao implements HousesDAO {

	@Override
	public List<pano_project> getHouses() {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.getHouses");
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
		row = getSqlMapClientTemplate()
				.delete("pano_project_house.delHousetypebySN", SN);
		return row;
	}

	@Override
	public List<pano_project_style> getHousestyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delHousestyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<pano_ad> getHousead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delHousead() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<pano_project> selHousesbySN(Long SN) {
		List<pano_project> list = (List<pano_project>) getSqlMapClientTemplate()
				.queryForList("pano_project.selHousesbySN", SN);
		return list;
	}

}
