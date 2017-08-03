package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.User;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focustech.common.utils.JsonUtils;

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

		String page = request.getParameter("page");

		// 总记录数
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		List<pano_project> pano_project = null;
		int upPage = 0;
		int nextPage = 0;

		// 判断当前页
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage == 1) {
			upPage = 1;
			nextPage = 2;
		}

		// 获取查询总记录数
		count = housesService.selHousesCount();

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new Page(count, currentPage);
		System.out.println("currentPage：" + currentPage);
		// 拼接分页语句
		pano_project = housesService.getHouses(pages);
		request.setAttribute("HousesList", pano_project);
		request.setAttribute("pages", pages);
		int totalPages = pages.getTotalPages();

		if (currentPage == totalPages) {
			upPage = currentPage - 1;
			nextPage = totalPages;
		} else if (currentPage > 1) {
			upPage = currentPage - 1;
			nextPage = currentPage + 1;
		}

		request.setAttribute("upPage", upPage);
		request.setAttribute("nextPage", nextPage);
		int index = (currentPage - 1) * pages.getPagesize();
		request.setAttribute("index", index);
		request.setAttribute("currentPage", currentPage);

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
			@RequestParam String acmbProvince, @RequestParam String acmbCity,
			@RequestParam String acmbArea, @RequestParam String asname) {
		pano_project houses = new pano_project();
		houses.setPROVINCE(acmbProvince);
		houses.setCITY(acmbCity);
		houses.setAREA(acmbArea);
		houses.setNAME(asname);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		houses.setADD_TIME(add_time);
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

	@RequestMapping("/upHouseVerify")
	public void upHouseVerify(HttpServletResponse response, Long SN) {
		pano_project house = null;
		try {
			house = housesService.selHousesbySN(SN).get(0);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String jsonprodt = JsonUtils.objectToJson(house);
		try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/upHouse")
	public String upHouse(@RequestParam String usname, @RequestParam Long SN,
			@RequestParam String ucmbProvince, @RequestParam String ucmbCity,
			@RequestParam String ucmbArea) {
		pano_project house = new pano_project();
		house.setSN(SN);
		house.setNAME(usname);
		house.setPROVINCE(ucmbProvince);
		house.setCITY(ucmbCity);
		house.setAREA(ucmbArea);
		housesService.upHouse(house);
		return redirect("tohouse");
	}

	// -----------------------楼盘-设置-户型-----------------------

	Long PROJECT_SN;

	@RequestMapping("/tohouseSet")
	public String tohouseSet(HttpServletRequest request, HttpSession session) {
		PROJECT_SN = Long.parseLong(request.getParameter("SN"));
		List<pano_project> project = housesService.selHousesbySN(PROJECT_SN);
		pano_project pList = project.get(0);
		session.setAttribute("pList", pList);
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		if (hlist.size() != 0) {
			request.setAttribute("hList", hlist);
		}
		return "/houses/houseSet";
	}

	@RequestMapping("/tohouseSet2")
	public String tohouseSet2(HttpServletRequest request) {
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		if (hlist.size() != 0) {
			request.setAttribute("hList", hlist);
		}
		return "/houses/houseSet";
	}

	@RequestMapping("/delHousetype")
	public String delHousetype(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delHousetypebySN(SN);
		return redirect("tohouseSet2");
	}

	// -----------------------楼盘-设置-风格-----------------------

	@RequestMapping("/tostyleSet")
	public String tostyleSet() {
		return "/houses/styleSet";
	}

	// -----------------------楼盘-设置-广告-----------------------

	@RequestMapping("/toaddSet")
	public String toaddSet(HttpServletRequest request) {
		List<pano_ad> list = housesService.getHousead();
		request.setAttribute("aList", list);
		return "/houses/addSet";
	}

	@RequestMapping("/delHousead")
	public String delHousead(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delHousead(SN);
		return redirect("toaddSet");
	}

	// -----------------------楼盘-设置-户型-空间设置-----------------------

	Long HOUSE_SN;

	@RequestMapping("/toroomSet")
	public String toroomSet(HttpServletRequest request, HttpSession session) {
		HOUSE_SN = Long.parseLong(request.getParameter("SN"));
		List<pano_project_house> housetype = housesService
				.selHousetypebySN(HOUSE_SN);
		String ID = housetype.get(0).getID();
		session.setAttribute("houseID", ID);
		List<pano_project_space> sList = housesService.getspace(HOUSE_SN);
		request.setAttribute("sList", sList);
		return "/houses/roomSet";
	}

	@RequestMapping("/toroomSet2")
	public String toroomSet2(HttpServletRequest request) {
		List<pano_project_space> sList = housesService.getspace(HOUSE_SN);
		request.setAttribute("sList", sList);
		return "/houses/roomSet";
	}

	@RequestMapping("/delroomSet")
	public String delroomSet(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delroomSet(SN);
		return redirect("toroomSet2");
	}

	@RequestMapping("/addroomSet")
	public String addroomSet(@RequestParam String aname) {
		pano_project_space space = new pano_project_space();
		space.setNAME(aname);
		space.setHOUSE_SN(HOUSE_SN);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		space.setADD_TIME(add_time);
		housesService.addroomSet(space);
		return redirect("toroomSet2");
	}

	@RequestMapping("/upRoomVerify")
	public void upRoomVerify(HttpServletResponse response, Long SN) {
		pano_project_space space = null;
		try {
			space = housesService.selSpacebySN(SN);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String jsonprodt = JsonUtils.objectToJson(space);
		try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/uproomSet")
	public String uproomSet(@RequestParam String uname, @RequestParam Long SN) {
		pano_project_space space = new pano_project_space();
		space.setSN(SN);
		space.setNAME(uname);
		housesService.uproomSet(space);
		return redirect("toroomSet2");
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
