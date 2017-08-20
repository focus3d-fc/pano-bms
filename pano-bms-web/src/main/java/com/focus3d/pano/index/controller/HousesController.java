package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.model.getListPano;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_house_style;
import com.focus3d.pano.model.pano_project_label;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.project_style;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;
import com.opensymphony.oscache.util.StringUtil;

/**
 * 
 * 楼盘管理
 * 
 * 
 */

@Controller
@RequestMapping("/houses")
public class HousesController extends BaseController {

	@Autowired
	private HousesService housesService;

	@Autowired
	private PanoUserLongInService service;

	@Autowired
	private IFileReadClient fileReadClient;// 读取文件接口

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

	/*
	 * @RequestMapping("/selhouses") public String selhouses(HttpServletRequest
	 * request,
	 * 
	 * @RequestParam String cmbProvince, @RequestParam String cmbCity,
	 * 
	 * @RequestParam String cmbArea, @RequestParam String housesname) {
	 * pano_project houses = new pano_project();
	 * houses.setPROVINCE(cmbProvince); houses.setCITY(cmbCity);
	 * houses.setAREA(cmbArea); if (housesname != null) {
	 * houses.setNAME(housesname); } List<pano_project> list =
	 * housesService.selHouses(houses);
	 * 
	 * if (list.size() != 0) { request.setAttribute("HousesList", list); }
	 * return "/houses/house"; }
	 */

	@RequestMapping("/selhouses")
	public String selhouses(HttpServletRequest request,
			@RequestParam String cmbProvince, @RequestParam String cmbCity,
			@RequestParam String cmbArea, @RequestParam String housesname) {
		List<pano_project> list = new ArrayList<pano_project>();
		if ("".equals(housesname) || housesname == null) {
			pano_project houses = new pano_project();
			houses.setPROVINCE(cmbProvince);
			houses.setCITY(cmbCity);
			houses.setAREA(cmbArea);
			list = housesService.selHouses(houses);
		} else {
			list = housesService.selHousesbyName(housesname);
		}
		if (list.size() != 0) {
			request.setAttribute("HousesList", list);
		}
		return "/houses/house2";
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
		if (request.getParameter("he").equals("he")) {
			housesService.addHouseStyle();
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
		System.out.println("==============1" + house.getNAME());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);

		Long imgsn = null;
		try {
			imgsn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		house.setIMG_SN(imgsn);
		if (SN == null) {
			house.setADD_TIME(add_time);
			house.setPROJECT_SN(PROJECT_SN);
			housesService.addHousetype(house);
		} else {
			house.setUPDATE_TIME(add_time);
			house.setSN(SN);
			System.out.println("==============2" + house.getNAME());
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

		project_style style = new project_style();
		style.setNAME(aname);
		/*
		 * Long imgsn = null; try { imgsn = EncryptUtil.decode(fullImgSn); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * style.setIMG_SN(imgsn);
		 */

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		style.setADD_TIME(add_time);
		style.setPROJECT_SN(PROJECT_SN);
		housesService.addHousestyle(style);
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
		request.setAttribute("STYLE_SN", STYLE_SN);
		request.setAttribute("PROJECT_SN", PROJECT_SN);
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
		/*
		 * // 清空关联数据 housesService.clearStyleHouse(house);
		 */

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String add_time = sdf.format(date);
		house.setADD_TIME(add_time);

		String[] parameterValues = request.getParameterValues("uname");
		if (parameterValues != null && parameterValues.length > 0) {
			for (int i = 0; i < parameterValues.length; i++) {
				Long HOUSE_SN = Long.parseLong(parameterValues[i]);
				house.setHOUSE_SN(HOUSE_SN);
				Map map = new HashMap();
				map.put("PROJECT_SN", PROJECT_SN);
				map.put("STYLE_SN", STYLE_SN);
				map.put("HOUSE_SN", HOUSE_SN);
				List<pano_project_house_style> num = housesService
						.selHouseStyle(map);
				if (num.size() == 0) {
					housesService.addStyleHouse(house);
				}

			}
		}
		return redirect("tostyle-houseSet2");
	}

	@ResponseBody
	@RequestMapping("/selHouseStyle")
	public void selHouseStyle(HttpServletRequest request, String HouseSN,
			HttpServletResponse response, ModelMap modelMap) {
		Long House_SN = Long.parseLong(HouseSN);
		Map map = new HashMap();
		map.put("HOUSE_SN", House_SN);
		map.put("STYLE_SN", STYLE_SN);
		map.put("PROJECT_SN", PROJECT_SN);

		List<pano_project_house_style> housty = housesService
				.selHouseStyle(map);

		pano_project_house_style hs = housty.get(0);

		try {
			this.ajaxOutput(response, JsonUtils.objectToJson(hs));
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		List<getListPano> list = new ArrayList<getListPano>();

		house_sn = Long.parseLong(request.getParameter("SN"));
		long project_sn = PROJECT_SN;
		long style_sn = STYLE_SN;
		System.out.println(house_sn + "-" + project_sn + "-" + style_sn);
		/**
		 * 通过 户型 楼盘 风格 查询 得到主键
		 */
		PanoProjectPackageStyle ppps1 = new PanoProjectPackageStyle();
		ppps1.setHouse_sn(house_sn);
		ppps1.setProject_sn(project_sn);
		ppps1.setStyle_sn(style_sn);
		PanoProjectPackageStyle getpackage1 = service.getpackage1(ppps1);
		if (getpackage1 == null) {
			System.out.println("户型风格表无进入");
			/**
			 * 户型风格表对象
			 */
			PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
			pano.setHouse_sn(house_sn);
			pano.setProject_sn(project_sn);
			pano.setStyle_sn(style_sn);
			service.getinsert(pano);
			getpackage1 = service.getpackage1(ppps1);
		}
		/**
		 * 通过主键得到对应的套餐ID
		 */
		List<PanoProjectHousePackage> getpackage2 = service
				.getpackage2(getpackage1.getSn());
		System.out.println(getpackage1.getSn() + "套餐主键");
		/**
		 * 通过套餐户型关系表查看对应的户型风格表是否有对应的套餐
		 */
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(getpackage1
				.getSn());
		getListPano lp = new getListPano();
		if (ppps.size() > 0) {
			System.out.println("进入有值判断");
			/**
			 * 通过 套餐 户型 风格 楼盘 的主键获得name 和id
			 */
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			for (PanoProjectHousePackage p : getpackage2) {
				lp.setHuose_style_sn(p.getHouse_style_sn());
				lp.setPackage_sn(p.getPackage_sn());
				lp.setSn(p.getSn());
				getListPano getpackage = service.getpackage(lp);
				request.setAttribute("listss", getpackage);
				list.add(service.getpackage(lp));
			}

			request.setAttribute("lists", list);

		} else {
			System.out.println("进入空值判断");
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			getListPano get = service.getselect1(lp);
			System.out.println(get.getProject_name() + get.getHouse_name()
					+ get.getStyle_name());
			request.setAttribute("listss", get);

		}
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		return "/houses/combo";

	}

	long package_price;

	@RequestMapping("/packageSet2")
	public String packageSet2(HttpServletRequest request) {
		List<getListPano> list = new ArrayList<getListPano>();

		long project_sn = PROJECT_SN;
		long style_sn = STYLE_SN;

		/**
		 * 通过 户型 楼盘 风格 查询 得到主键
		 */
		PanoProjectPackageStyle ppps1 = new PanoProjectPackageStyle();
		ppps1.setHouse_sn(house_sn);
		ppps1.setProject_sn(project_sn);
		ppps1.setStyle_sn(style_sn);
		PanoProjectPackageStyle getpackage1 = service.getpackage1(ppps1);
		if (getpackage1 == null) {
			/**
			 * 户型风格表对象
			 */
			PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
			pano.setHouse_sn(house_sn);
			pano.setProject_sn(project_sn);
			pano.setStyle_sn(style_sn);
			service.getinsert(pano);
			getpackage1 = service.getpackage1(ppps1);
		}
		/**
		 * 通过主键得到对应的套餐ID
		 */
		List<PanoProjectHousePackage> getpackage2 = service
				.getpackage2(getpackage1.getSn());
		/**
		 * 通过套餐户型关系表查看对应的户型风格表是否有对应的套餐
		 */
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(getpackage1
				.getSn());
		getListPano lp = new getListPano();
		if (ppps.size() > 0) {
			System.out.println("进入有值判断");
			/**
			 * 通过 套餐 户型 风格 楼盘 的主键获得name 和id
			 */
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			ProductInfo prodtInfo = null;
			for (PanoProjectHousePackage p : getpackage2) {
				lp.setHuose_style_sn(p.getHouse_style_sn());
				lp.setPackage_sn(p.getPackage_sn());
				lp.setSn(p.getSn());
				getListPano getpackage = service.getpackage(lp);
				Long fullImgSn = getpackage.getImg_sn();
				if (fullImgSn != null) {
					String fullImgUrl = fileReadClient.getFile(fullImgSn,
							FileAttributeEnum.VISIT_ADDR);
					getpackage.setGetFullImgUrl(fullImgUrl);
				}
				request.setAttribute("listss", getpackage);
				list.add(service.getpackage(lp));
			}

			request.setAttribute("lists", list);

		} else {
			System.out.println("进入空值判断");
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			getListPano get = service.getselect1(lp);
			System.out.println(get.getProject_name() + get.getHouse_name()
					+ get.getStyle_name());
			request.setAttribute("listss", get);

		}
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		return "/houses/combo";

	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String package_sn = request.getParameter("id2");
		PanoProjectHousePackage ppp = new PanoProjectHousePackage();
		ppp.setSn(Long.parseLong(package_sn));
		int getdelete = service.getdelete(ppp);
		return redirect("packageSet2");

	}

	@RequestMapping("/insert")
	public String insert(HttpServletRequest request) {
		String[] package_ = request.getParameterValues("name");

		/**
		 * 通过前台得到户型 风格 楼盘的SN
		 */
		String names = request.getParameter("names");
		String[] split = names.split(",");
		String style_sn = split[0];
		String house_sn = split[1];
		String project_sn = split[2];
		System.out.println(style_sn + house_sn + project_sn);
		/**
		 * 在根据户型 户型 楼盘 风格Sn 得到添加了的字段的SN 添加的户型的套餐表
		 */
		PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
		pano.setHouse_sn(Long.parseLong(house_sn));
		pano.setProject_sn(Long.parseLong(project_sn));
		pano.setStyle_sn(Long.parseLong(style_sn));
		PanoProjectPackageStyle getpackage1 = service.getpackage1(pano);
		PanoProjectHousePackage pphp = new PanoProjectHousePackage();
		pphp.setHouse_style_sn(getpackage1.getSn());
		for (String package_sn : package_) {
			pphp.setPackage_sn(Long.parseLong(package_sn));
			System.out.println("套餐ID" + package_sn + "主键ID"
					+ getpackage1.getSn());
			service.getinserts(pphp);
			System.out.println("添加成功");
		}

		return redirect("packageSet2");

	}

	@RequestMapping("/insert1")
	public String insert1(HttpServletRequest request, HttpSession session,
			String fullImgSn) {
		String name = request.getParameter("names");
		String sn = request.getParameter("sn");
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PanoProjectHousePackage p = new PanoProjectHousePackage();
		System.out.println("进入套餐设置" + name + "-" + sn + "-" + img_sn);
		p.setIMG_SN(img_sn);
		System.out.println("进入套餐设置1");
		if (StringUtil.isEmpty(name)) {
		}
		p.setPackage_price(Double.parseDouble(name));
		System.out.println("进入套餐设置2");
		p.setSn(Long.parseLong(sn));
		service.getInsert1(p);
		return redirect("packageSet2");

	}

}
