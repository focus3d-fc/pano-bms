package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.HousesDAO;
import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.pano_project_style;

@Service("housesService")
public class HousesServiceImpl implements HousesService {

	@Autowired
	private HousesDAO housesDAO;

	@Override
	public List<pano_project> getHouses(Page page) {
		// TODO Auto-generated method stub
		return housesDAO.getHouses(page);
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
	public List<pano_project_style> getHousestyle(Long PROJECT_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousestyle(PROJECT_SN);
	}

	@Override
	public int delHousestyle(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousestyle(SN);
	}

	@Override
	public List<pano_ad> getHousead() {
		// TODO Auto-generated method stub
		return housesDAO.getHousead();
	}

	@Override
	public int delHousead(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delHousead(SN);
	}

	@Override
	public List<pano_project> selHousesbySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selHousesbySN(SN);
	}

	@Override
	public List<pano_project_space> getspace(Long HOUSE_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getspace(HOUSE_SN);
	}

	@Override
	public List<pano_project_house> selHousetypebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selHousetypebySN(SN);
	}

	@Override
	public int delroomSet(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delroomSet(SN);
	}

	@Override
	public void addroomSet(pano_project_space space) {
		// TODO Auto-generated method stub
		housesDAO.addroomSet(space);
	}

	@Override
	public int selHousesCount() {
		// TODO Auto-generated method stub
		return housesDAO.selHousesCount();
	}

	@Override
	public pano_project_space selSpacebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.selSpacebySN(SN);
	}

	@Override
	public void uproomSet(pano_project_space space) {
		// TODO Auto-generated method stub
		housesDAO.uproomSet(space);
	}

	@Override
	public void upHouse(pano_project houses) {
		// TODO Auto-generated method stub
		housesDAO.upHouse(houses);
	}

	@Override
	public void addHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		housesDAO.addHousetype(house);
	}

	@Override
	public void upHousetype(pano_project_house house) {
		// TODO Auto-generated method stub
		housesDAO.upHousetype(house);
	}

	@Override
	public List<pano_project_label> getLablebyStyle(Long STYLE_SN) {
		// TODO Auto-generated method stub
		return housesDAO.getLablebyStyle(STYLE_SN);
	}

	@Override
	public List<pano_project_style> getHousestylebySN(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.getHousestylebySN(SN);
	}

	@Override
	public int delLable(Long SN) {
		// TODO Auto-generated method stub
		return housesDAO.delLable(SN);
	}

	@Override
	public void addLable(pano_project_label lable) {
		// TODO Auto-generated method stub
		housesDAO.addLable(lable);
	}

}
