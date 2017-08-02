package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.HousesDAO;
import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_style;

@Service("housesService")
public class HousesServiceImpl implements HousesService {

	@Autowired
	private HousesDAO housesDAO;

	@Override
	public List<pano_project> getHouses() {
		// TODO Auto-generated method stub
		return housesDAO.getHouses();
	}

	@Override
	public int delHousesbySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousesbySN(SN);
	}

	@Override
	public void addHouses(pano_project houses) {
		// TODO Auto-generated method stub
		housesDAO.addHouses(houses);
	}

	@Override
	public List<pano_project> selHouses(pano_project houses) {
		// TODO Auto-generated method stub
		return housesDAO.selHouses(houses);
	}

	@Override
	public List<pano_project_house> getHousetype(Long PROJECT_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousetype(PROJECT_SN);
	}

	@Override
	public int delHousetypebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousetypebySN(SN);
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
		// TODO Auto-generated method stub
		return housesDAO.selHousesbySN(SN);
	}

}
