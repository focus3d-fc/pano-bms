package com.focus3d.pano.index.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;

/**
 * 
 * 楼盘管理
 * 
 * @author 熊峰
 * 
 */

@Controller
@RequestMapping("/houses")
public class HousesController extends BaseController {

	@Autowired
	private HousesService housesService;

	// -----------------------楼盘管理-----------------------

	@RequestMapping("/tohouse")
	public String tohouse(HttpServletRequest request) {
		List<pano_project> list = housesService.getHouses();
		request.setAttribute("HousesList", list);
		return "/houses/house";
	}

	@RequestMapping("/delhouses")
	public String delhouses(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delHousesbySN(SN);
		return redirect("tohouse");
	}

	@RequestMapping("/addhouses")
	public String addhouses(HttpServletRequest request,
			@RequestParam String PROVINCE, @RequestParam String CITY,
			@RequestParam String AREA, @RequestParam String NAME) {
		pano_project houses = new pano_project();
		houses.setPROVINCE(PROVINCE);
		houses.setCITY(CITY);
		houses.setAREA(AREA);
		houses.setNAME(NAME);

		housesService.addHouses(houses);
		return redirect("tohouse");
	}

	@RequestMapping("/selhouses")
	public String selhouses(HttpServletRequest request,
			@RequestParam String cmbProvince, @RequestParam String cmbCity,
			@RequestParam String cmbArea, @RequestParam String housesname) {
		pano_project houses = new pano_project();
		houses.setPROVINCE(cmbProvince);
		houses.setCITY(cmbCity);
		houses.setAREA(cmbArea);
		if (housesname != null) {
			houses.setNAME(housesname);
		}
		List<pano_project> list = housesService.selHouses(houses);

		if (list.size() != 0) {
			request.setAttribute("HousesList", list);
		}
		return "/houses/house";
	}

	// -----------------------楼盘-设置-户型-----------------------

	@RequestMapping("/tohouseSet")
	public String tohouseSet(HttpServletRequest request) {
		Long PROJECT_SN = Long.parseLong(request.getParameter("SN"));
		List<pano_project> plist = housesService.selHousesbySN(PROJECT_SN);
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		request.setAttribute("pList", plist);
		if (hlist.size() != 0) {
			request.setAttribute("hList", hlist);
		}
		return "/houses/houseSet";
	}

	@RequestMapping("/delHousetype")
	public String delHousetype(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delHousetypebySN(SN);
		return redirect("tohouse");
	}

	@RequestMapping("/toroomSet")
	public String toroomSet() {
		return "/houses/roomSet";
	}

	@RequestMapping("/tocombo")
	public String tocombo() {
		return "/houses/combo";
	}

	@RequestMapping("/tocombo-add")
	public String tocombo_add() {
		return "/houses/combo-add";
	}
}
