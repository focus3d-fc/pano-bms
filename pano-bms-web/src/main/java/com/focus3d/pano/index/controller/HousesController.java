package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.getListPano;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_house_style;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.project_style;
import com.focustech.common.utils.EncryptUtil;
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

	@Autowired
	private PanoUserLongInService service;

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

	@RequestMapping("/addHousetype")
	public String addHousetype(String aname, String fullImgSn, Long SN) {
		pano_project_house house = new pano_project_house();
		house.setNAME(aname);
		Long imgsn = null;
		try {
			imgsn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		house.setIMG_SN(imgsn);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		if (SN == null) {
			house.setADD_TIME(add_time);
			house.setPROJECT_SN(PROJECT_SN);
			housesService.addHousetype(house);
		} else {
			house.setUPDATE_TIME(add_time);
			house.setSN(SN);
			housesService.upHousetype(house);
		}

		return redirect("tohouseSet2");
	}

	@RequestMapping("/upHousetypeVerify")
	public void upHousetypeVerify(HttpServletResponse response, Long SN) {
		pano_project_house space = null;
		try {
			space = housesService.getHousetypebySN(SN);
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

	// -----------------------楼盘-设置-风格-----------------------

	@RequestMapping("/tostyleSet")
	public String tostyleSet(HttpServletRequest request) {
		List<project_style> stylist = housesService.getHousestyle(PROJECT_SN);
		if (stylist.size() != 0) {
			request.setAttribute("stylist", stylist);
		}
		List<project_style> allsty = housesService.getAllHousestyle();
		for (int i = 0; i < allsty.size(); i++) {
			System.out.println(allsty.get(i).getNAME());
		}
		request.setAttribute("allsty", allsty);

		return "/houses/styleSet";
	}

	@RequestMapping("/delstyleSet")
	public String delstyleSet(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delHousestyle(SN);
		return redirect("tostyleSet");
	}

	@RequestMapping("/addstyleSet")
	public String addstyleSet(String aname, String fullImgSn) {
		System.out.println("start==================");
		System.out.println("aname===================" + aname);
		System.out.println("fullimgsn===================" + fullImgSn);

		project_style style = new project_style();
		style.setNAME(aname);
		Long imgsn = null;
		try {
			imgsn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		style.setIMG_SN(imgsn);

		System.out.println("imgsn==================" + imgsn);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		style.setADD_TIME(add_time);
		style.setPROJECT_SN(PROJECT_SN);
		housesService.addHousestyle(style);
		System.out.println("end============");
		return redirect("tostyleSet");
	}

	// -----------------------楼盘-设置-风格-户型设置-----------------------
	Long STYLE_SN;

	@RequestMapping("/tostyle-houseSet")
	public String tostylehouseSet(HttpServletRequest request) {
		STYLE_SN = Long.parseLong(request.getParameter("SN"));
		pano_project_house_style house = new pano_project_house_style();
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		List<pano_project_house> housename = housesService
				.selHousebyStyle(house);
		request.setAttribute("houList", housename);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		request.setAttribute("styname", stylist.get(0).getNAME());
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		request.setAttribute("hlist", hlist);
		return "/houses/style-houseSet";
	}

	@RequestMapping("/tostyle-houseSet2")
	public String tostylehouseSet2(HttpServletRequest request) {
		pano_project_house_style house = new pano_project_house_style();
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		List<pano_project_house> housename = housesService
				.selHousebyStyle(house);
		request.setAttribute("houList", housename);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		request.setAttribute("styname", stylist.get(0).getNAME());
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		request.setAttribute("hlist", hlist);
		return "/houses/style-houseSet";
	}

	@RequestMapping("/delstyle-houseSet")
	public String delstylehouseSet(HttpServletRequest request) {
		Long HOUSE_SN = Long.parseLong(request.getParameter("SN"));
		pano_project_house_style house = new pano_project_house_style();
		house.setHOUSE_SN(HOUSE_SN);
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		housesService.delstylehouseSet(house);
		return redirect("tostyle-houseSet2");
	}

	@RequestMapping("/upstyle-houseSet")
	public String upstylehouseSet(HttpServletRequest request) {
		pano_project_house_style house = new pano_project_house_style();
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		// 清空关联数据
		housesService.clearStyleHouse(house);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		house.setADD_TIME(add_time);

		String[] parameterValues = request.getParameterValues("uname");
		for (int i = 0; i < parameterValues.length; i++) {
			Long HOUSE_SN = Long.parseLong(parameterValues[i]);
			house.setHOUSE_SN(HOUSE_SN);
			housesService.addStyleHouse(house);
		}

		return redirect("tostyle-houseSet2");
	}

	// -----------------------楼盘-设置-风格-标签设置-----------------------

	@RequestMapping("/tostyle-sloginSet")
	public String tostylesloginSet(HttpServletRequest request) {
		STYLE_SN = Long.parseLong(request.getParameter("SN"));
		List<pano_project_label> lable = housesService
				.getLablebyStyle(STYLE_SN);
		request.setAttribute("labList", lable);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		request.setAttribute("styname", stylist.get(0).getNAME());
		return "/houses/style-sloginSet";
	}

	@RequestMapping("/tostyle-sloginSet2")
	public String tostylesloginSet2(HttpServletRequest request) {
		List<pano_project_label> lable = housesService
				.getLablebyStyle(STYLE_SN);
		request.setAttribute("labList", lable);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		request.setAttribute("styname", stylist.get(0).getNAME());
		return "/houses/style-sloginSet";
	}

	@RequestMapping("/delsloginSet")
	public String delsloginSet(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
		housesService.delLable(SN);
		return redirect("tostyle-sloginSet2");
	}

	@RequestMapping("/addsloginSet")
	public String addsloginSet(@RequestParam String aname) {
		pano_project_label lable = new pano_project_label();
		lable.setNAME(aname);
		lable.setSTYLE_SN(STYLE_SN);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		lable.setADD_TIME(add_time);
		housesService.addLable(lable);
		return redirect("tostyle-sloginSet2");
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

	@RequestMapping("/addHousead")
	public String addHousead(String alink, String fullImgSn, Long SN) {
		pano_ad ad = new pano_ad();
		ad.setLINK(alink);
		Long imgsn = null;
		try {
			imgsn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ad.setIMG_SN(imgsn);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);

		if (SN == null) {
			ad.setADD_TIME(add_time);
			housesService.addHousead(ad);
		} else {
			ad.setSN(SN);
			ad.setUPDATE_TIME(add_time);
			housesService.upHousead(ad);
		}
		return redirect("toaddSet");
	}

	@RequestMapping("/upAdVerify")
	public void upAdVerify(HttpServletResponse response, Long SN) {
		pano_ad ad = null;
		try {
			ad = housesService.getHouseadbySN(SN);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String jsonprodt = JsonUtils.objectToJson(ad);
		try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	@RequestMapping("/topro-details")
	public String topro_details() {
		return "/houses/pro-details";
	}

	// -----------------------楼盘-设置-风格-户型设置-【何伟】-----------------------

	long house_sn;

	@RequestMapping("/packageSet")
	public String packageSet(HttpServletRequest request) {
		/**
		 * 从套餐页面获取3个ID值
		 */
		List<getListPano> list = new ArrayList<getListPano>();
		house_sn = Long.parseLong(request.getParameter("SN"));
		long project_sn = PROJECT_SN;
		long style_sn = STYLE_SN;
		/**
		 * 根据传过来的Id找到对应的套餐
		 */
		PanoProjectPackageStyle ppp = new PanoProjectPackageStyle();
		ppp.setHouse_sn(house_sn);
		ppp.setProject_sn(project_sn);
		ppp.setStyle_sn(style_sn);
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(ppp);
		getListPano lp = new getListPano();

		/**
		 * 循环输出套餐id
		 */
		if (ppps.size() > 0) {
			for (int i = 0; i < ppps.size(); i++) {
				PanoProjectPackageStyle panoProjectPackageStyle = ppps.get(i);
				Long package_sn = panoProjectPackageStyle.getPackage_sn();
				Long sn = panoProjectPackageStyle.getSn();
				/**
				 * 输出 楼层 / 套餐 / 风格 / 户型 得到 name值
				 */
				lp.setSn(sn);
				lp.setPackage_id(package_sn);
				lp.setProject_id(project_sn);
				lp.setHouse_id(house_sn);
				lp.setStyle_id(style_sn);
				getListPano getpackage = service.getpackage(lp);
				System.out
						.println("----" + getpackage.getHouse_sn()
								+ getpackage.getProject_sn()
								+ getpackage.getStyle_sn());
				list.add(getpackage);
				request.setAttribute("listss", getpackage);
			}
		} else {
			System.out.println(project_sn + "-" + house_sn + "-" + style_sn);
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			System.out.println("进入空的以后的方法");
			getListPano get = service.getselect1(lp);
			System.out.println("户型详情：" + get.getHouse_name()
					+ get.getHouse_sn() + "楼盘详情：" + get.getProject_name()
					+ get.getProject_sn() + "风格详情：" + get.getStyle_name()
					+ get.getStyle_sn());
			request.setAttribute("listss", get);
		}
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		request.setAttribute("list", list);
		return "/houses/combo";

	}

	@RequestMapping("/packageSet2")
	public String packageSet2(HttpServletRequest request) {
		/**
		 * 从套餐页面获取3个ID值
		 */
		List<getListPano> list = new ArrayList<getListPano>();
		long project_sn = PROJECT_SN;
		long style_sn = STYLE_SN;
		/**
		 * 根据传过来的Id找到对应的套餐
		 */
		PanoProjectPackageStyle ppp = new PanoProjectPackageStyle();
		ppp.setHouse_sn(house_sn);
		ppp.setProject_sn(project_sn);
		ppp.setStyle_sn(style_sn);
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(ppp);
		getListPano lp = new getListPano();

		/**
		 * 循环输出套餐id
		 */
		if (ppps.size() > 0) {
			for (int i = 0; i < ppps.size(); i++) {
				PanoProjectPackageStyle panoProjectPackageStyle = ppps.get(i);
				Long package_sn = panoProjectPackageStyle.getPackage_sn();
				Long sn = panoProjectPackageStyle.getSn();
				/**
				 * 输出 楼层 / 套餐 / 风格 / 户型 得到 name值
				 */
				lp.setSn(sn);
				lp.setPackage_id(package_sn);
				lp.setProject_id(project_sn);
				lp.setHouse_id(house_sn);
				lp.setStyle_id(style_sn);
				getListPano getpackage = service.getpackage(lp);
				System.out
						.println("----" + getpackage.getHouse_sn()
								+ getpackage.getProject_sn()
								+ getpackage.getStyle_sn());
				list.add(getpackage);
				request.setAttribute("listss", getpackage);
			}
		} else {
			System.out.println(project_sn + "-" + house_sn + "-" + style_sn);
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			System.out.println("进入空的以后的方法");
			getListPano get = service.getselect1(lp);
			System.out.println("户型详情：" + get.getHouse_name()
					+ get.getHouse_sn() + "楼盘详情：" + get.getProject_name()
					+ get.getProject_sn() + "风格详情：" + get.getStyle_name()
					+ get.getStyle_sn());
			request.setAttribute("listss", get);
		}
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		request.setAttribute("list", list);
		return "/houses/combo";

	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String house_sn = request.getParameter("id");
		String project_sn = request.getParameter("id1");
		String style_sn = request.getParameter("id2");
		String sn = request.getParameter("id3");
		PanoProjectPackageStyle ppp = new PanoProjectPackageStyle();
		ppp.setHouse_sn(Long.parseLong(house_sn));
		ppp.setProject_sn(Long.parseLong(project_sn));
		ppp.setStyle_sn(Long.parseLong(style_sn));
		ppp.setSn(Long.parseLong(sn));
		int getdelete = service.getdelete(ppp);
		return redirect("packageSet2");

	}

	@RequestMapping("/insert")
	public String insert(HttpServletRequest request) {
		System.out.println("进入添加页面");
		PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
		String[] package_sn = request.getParameterValues("name");
		String names = request.getParameter("names");
		String[] split = names.split(",");
		String style_sn = split[0];
		String house_sn = split[1];
		String project_sn = split[2];
		pano.setHouse_sn(Long.parseLong(house_sn));
		pano.setProject_sn(Long.parseLong(project_sn));
		pano.setStyle_sn(Long.parseLong(style_sn));
		for (int i = 0; i < package_sn.length; i++) {
			System.out.println("套餐：" + package_sn[i]);
			pano.setPackage_sn(Long.parseLong(package_sn[i]));
			service.getinsert(pano);
		}
		return redirect("packageSet2");

	}
}
