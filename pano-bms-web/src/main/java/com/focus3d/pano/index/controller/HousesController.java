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

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.admin.service.PackageTypeService;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.ProductList;
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
	private PackageTypeService packageTypeService;
	
	@Autowired
	private HousesService housesService;

	@Autowired
	private PanoUserLongInService service;
	
	@Autowired
	private IProductAdmService productService;

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
	
	@RequestMapping("/publicHouses")
	public String publishHouse(HttpServletResponse response,String SN,String PUBLISH){
		HashMap map = new HashMap<String,Object>();
		map.put("SN",SN);
		map.put("PUBLISH",PUBLISH);
		housesService.publishHouse(map);
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
		/*
		if (request.getParameter("he").equals("he")) {
			housesService.addHouseStyle();
		}*/
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
			housesService.upHousetype(house);
		}

		return redirect("tohouseSet2");
	}

	@RequestMapping("/upHousetypeVerify")
	public void upHousetypeVerify(HttpServletResponse response, Long SN) {
		pano_project_house space = null;
		try {
			space = housesService.getHousetypebySN(SN);
			space.setIMG_URL(fileReadClient.getFile(space.getIMG_SN(), FileAttributeEnum.VISIT_ADDR));
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
		return "/houses/styleSet";
	}
	
	@RequestMapping("/QueryStyle")
	public void QueryStyle(HttpServletResponse response,ModelMap map) {
		try{
			List<project_style> list = housesService.getAllHousestyle();
			ajaxOutput(response,JsonUtils.arrayToJson(list.toArray()));
		}catch(IOException e){
			e.printStackTrace();
		}
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
		Long style_sn = Long.parseLong(aname);
		style.setSTYLE_SN(style_sn);
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
	public String tostylehouseSet(String SN,ModelMap map) {
		STYLE_SN = Long.parseLong(SN);
		pano_project_house_style house = new pano_project_house_style();
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		List<pano_project_house> housename = housesService.selHousebyStyle(house);
		
		map.put("houList", housename);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		map.put("styname", stylist.get(0).getNAME());
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		map.put("hlist", hlist);
		map.put("STYLE_SN", STYLE_SN);
		map.put("PROJECT_SN", PROJECT_SN);
		return "/houses/style-houseSet";
	}
	
	@RequestMapping("/queryProjectHouse")
	public void QueryProjectHouse(HttpServletResponse response,String projectSn) {
		try{
			Long PROJECT_SN = Long.parseLong(projectSn);
			List<pano_project_house> list = housesService.getHousetype(PROJECT_SN);
			ajaxOutput(response,JsonUtils.arrayToJson(list.toArray()));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tostyle-houseSet2")
	public String tostylehouseSet2(HttpServletRequest request) {
		pano_project_house_style house = new pano_project_house_style();
		house.setPROJECT_SN(PROJECT_SN);
		house.setSTYLE_SN(STYLE_SN);
		List<pano_project_house> housename = housesService.selHousebyStyle(house);
		request.setAttribute("houList", housename);
		List<project_style> stylist = housesService.getHousestylebySN(STYLE_SN);
		request.setAttribute("styname", stylist.get(0).getNAME());
		List<pano_project_house> hlist = housesService.getHousetype(PROJECT_SN);
		request.setAttribute("hlist", hlist);
		request.setAttribute("STYLE_SN", STYLE_SN);
		request.setAttribute("PROJECT_SN", PROJECT_SN);
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
	public void upstylehouseSet(HttpServletResponse response,String uname,String fullImgSn) {
		try{
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
			Long map_key = EncryptUtil.decode(fullImgSn);
			Long HOUSE_SN = Long.parseLong(uname);
			house.setHOUSE_SN(HOUSE_SN);
			house.setIMG_SN(map_key);
			housesService.addStyleHouse(house);
			JSONObject json = new JSONObject();
			json.put("info", "succeed");
			ajaxOutput(response, json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/queryStyleHouse")
	public void QueryStyleHouse(HttpServletResponse response,String houseSn) {
		try{
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("houseSn",houseSn);
			map.put("projectSn",PROJECT_SN);
			map.put("styleSn",STYLE_SN);
			pano_project_house_style houseStyle = housesService.QueryHouseStyleBySn(map);
			
			JSONObject json = new JSONObject();
			json.put("houseStyleSn", houseStyle.getSN());
			if(houseStyle.getIMG_SN()!=null){
				json.put("img_url",fileReadClient.getFile(houseStyle.getIMG_SN(), FileAttributeEnum.VISIT_ADDR));
				json.put("mapKey", EncryptUtil.encode(houseStyle.getIMG_SN()));
			}
			
			ajaxOutput(response,json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/modifyStyleHouse")
	public void ModifyStyleHouse(HttpServletResponse response,String housestylesn,String fullImgSn) {
		try{
			Long mapKey = EncryptUtil.decode(fullImgSn);
			Long SN = Long.parseLong(housestylesn);
			pano_project_house_style house = new pano_project_house_style();
			house.setIMG_SN(mapKey);
			house.setSN(SN);
			/*
			 * // 清空关联数据 housesService.clearStyleHouse(house);
			 */
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String add_time = sdf.format(date);
			house.setADD_TIME(add_time);
			housesService.upHouseStyleImg(house);
			
			JSONObject json = new JSONObject();
			json.put("info","succeed");
			ajaxOutput(response, json.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
		List<pano_ad> list = housesService.getHousead(PROJECT_SN);
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
	public void addHousead(HttpServletResponse response,String alink, String fullImgSn, Long SN) {
		pano_ad ad = new pano_ad();
		ad.setPROJECT_SN(PROJECT_SN);
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
		
		try{
			JSONObject result = new JSONObject();
			result.put("info", "succeed");
			ajaxOutput(response, result.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@RequestMapping("/upAdVerify")
	public void upAdVerify(HttpServletResponse response, Long SN) {
		pano_ad ad = null;
		try {
			ad = housesService.getHouseadbySN(SN);
			ad.setIMG_URL(fileReadClient.getFile(ad.getIMG_SN(),FileAttributeEnum.VISIT_ADDR));
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
	public String packageSet(HttpServletRequest request,ModelMap map) {
		//List<getListPano> list = new ArrayList<getListPano>();
		
		house_sn = Long.parseLong(request.getParameter("SN"));
		long project_sn = PROJECT_SN;
		long style_sn = STYLE_SN;
		
		PanoProjectPackageStyle projectPackageStyle = new PanoProjectPackageStyle();
		projectPackageStyle.setHouse_sn(house_sn);
		projectPackageStyle.setProject_sn(project_sn);
		projectPackageStyle.setStyle_sn(style_sn);
		
		List<Map<String,Object>> list = housesService.QueryHouseStylePackage(projectPackageStyle);
		
		if(list.size()!=0){
			map.put("info", list.get(0));
		}
		
		map.put("lists", list);
		List<PanoProjectPackage> getselect = service.getselect();
		map.put("getselect", getselect);
		
		map.put("PROJECT_SN",PROJECT_SN);
		map.put("STYLE_SN",STYLE_SN);
		map.put("HOUSE_SN",house_sn);
		
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
			lp.setProject_sn(project_sn);
			lp.setHouse_sn(house_sn);
			lp.setStyle_sn(style_sn);
			getListPano get = service.getselect1(lp);
			request.setAttribute("listss", get);

		}
		
		return "/houses/combo";

	}
	
	
	@RequestMapping("/queryAllPackage")
	public void QueryAllPackage(HttpServletResponse response){
		try{
			List<PanoProjectPackage> list = service.getselect();
			ajaxOutput(response,JsonUtils.arrayToJson(list.toArray()));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String package_sn = request.getParameter("id2");
		PanoProjectHousePackage ppp = new PanoProjectHousePackage();
		ppp.setSn(Long.parseLong(package_sn));
		int getdelete = service.getdelete(ppp);
		return redirect("packageSet?SN="+house_sn);
	}

	@RequestMapping("/insert")
	public void insert(HttpServletResponse response,String package_sn,String names) {
		String[] split = names.split(",");
		String style_sn = split[0];
		String house_sn = split[1];
		String project_sn = split[2];
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
		
		pphp.setPackage_sn(Long.parseLong(package_sn));
		service.getinserts(pphp);
		
		try{
			JSONObject json = new JSONObject();
			json.put("info", "succeed");
			ajaxOutput(response,json.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		//return redirect("packageSet?SN="+house_sn);
		
	}
	
	
	@RequestMapping("/queryPackageDetail")
	public void queryPackageDetail(HttpServletResponse response,String sn) {
		try{
			JSONObject result = new JSONObject();
			List<HashMap<String,Object>> list = housesService.QueryPackageDetail(sn);
			
			for(HashMap<String,Object> map:list){
					String type_key = map.get("typeSn").toString();
					JSONObject child;
					if(result.containsKey(type_key)){
						child = result.getJSONObject(type_key);
						if(child.containsKey("alternative")){
							String value = child.getString("alternative");
							value += ","+map.get("productName").toString()+"*"+map.get("productNum").toString();
							child.put("alternative", value);
						}else{
							child.put("alternative", map.get("productName").toString()+"*"+map.get("productNum").toString());
						}
					}else{
						child = new JSONObject();
						child.put("spaceName", map.get("spaceName"));
						child.put("first", map.get("productName").toString()+"*"+map.get("productNum").toString());
						result.put(type_key,child);
					}
			}
			
			ajaxOutput(response, result.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@RequestMapping("/insert1")
	public void insert1(HttpServletResponse response,HttpSession session,String discount_price,String price,String sn,String fullImgSn) {
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PanoProjectHousePackage p = new PanoProjectHousePackage();
		p.setIMG_SN(img_sn);
		
		if (!StringUtil.isEmpty(price)) {
			p.setPackage_price(Double.parseDouble(price));
		}
		
		if (!StringUtil.isEmpty(discount_price)) {
			p.setDISCOUNT_PRICE(Double.parseDouble(discount_price));
		}
		
		p.setSn(Long.parseLong(sn));
		service.getInsert1(p);
		
		try{
			JSONObject json = new JSONObject();
			json.put("info", "success");
			ajaxOutput(response, json.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/queryTypeProducts")
	public String selectProduct(HttpServletResponse response,String packagetypesn,ModelMap map){
		    
			Long packageTypeSn = Long.parseLong(packagetypesn);
			
			List<Map<String,Object>> list = housesService.getTypeProducts(packageTypeSn);
			map.put("list", list);
			map.put("packageTypeSn",packagetypesn);
			
			List<ProductList> type = packageTypeService.getType();
			List<ProductList> func = packageTypeService.getFunc();
			List<ProductList> style = packageTypeService.getStyle();
			map.put("type", type);
			map.put("func", func);	
			map.put("style", style);
			
			return "/houses/combo-add1";
	}
	
	@RequestMapping("/ajaxQueryTypeProducts")
	public void QueryTypeProduct(HttpServletResponse response,String packagetypesn,ModelMap map){
		try{
			Long packageTypeSn = Long.parseLong(packagetypesn);
			List<Map<String,Object>> list = housesService.getTypeProducts(packageTypeSn);
			ajaxOutput(response, JsonUtils.arrayToJson(list.toArray()));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/queryAllProducts")
	public void QueryAllProducts(HttpServletResponse response,String id,String styleSn,String funcSn,String typeSn,String startNum,String pageSize,String total){
		try{
			  Map<String,Object> map = new HashMap<String,Object>();
			    map.put("id", id);
			    map.put("styleSn",styleSn);
			    map.put("funcSn",funcSn);
			    map.put("typeSn",typeSn);
			    map.put("startNum",startNum);
			    map.put("pageSize",pageSize);
				List<ProductInfo> list = housesService.QueryProducts(map);
				
				for(ProductInfo product : list){
					Long fullImgSn = product.getFullImgSn();
					if(fullImgSn!=null){
						product.setFullImgUrl(fileReadClient.getFile(fullImgSn, FileAttributeEnum.VISIT_ADDR));
					}
				}
				
				JSONObject json = new JSONObject();
				json.put("list",list);
				
				if(total.isEmpty()){
					int count = housesService.QueryProductsCount(map);
					json.put("total",count);
				}
				
				ajaxOutput(response, json.toString());
		}catch(IOException e){
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/queryProductDetail")
	public void QueryProductDetail(HttpServletResponse response,String productSn){
		try{
			  	Map<String,Object> map = new HashMap<String,Object>();
			    map.put("productSn", productSn);
			    HashMap<String,Object> product= housesService.queryProductDetail(map);
			    
			    if(product.get("fullImgSn")!=null){
			    	Long key = Long.parseLong(product.get("fullImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("fullImgUrl", url);
			    }
			    
			    if(product.get("leftImgSn")!=null){
			    	Long key = Long.parseLong(product.get("leftImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("leftImgUrl", url);
			    }
			    
			    if(product.get("downImgSn")!=null){
			    	Long key = Long.parseLong(product.get("downImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("downImgUrl", url);
			    }
			    
			    if(product.get("bannerImgSn")!=null){
			    	Long key = Long.parseLong(product.get("bannerImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("bannerImgUrl", url);
			    }
			    
			    if(product.get("materialImgSn")!=null){
			    	Long key = Long.parseLong(product.get("materialImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("materialImgUrl", url);
			    }
			    
			    if(product.get("fabricImgSn")!=null){
			    	Long key = Long.parseLong(product.get("fabricImgSn").toString());
			    	String url = fileReadClient.getFile(key, FileAttributeEnum.VISIT_ADDR);
			    	product.put("fabricImgUrl", url);
			    }
				ajaxOutput(response, JsonUtils.mapToJson(product));
		}catch(IOException e){
				e.printStackTrace();
		}
	}
	
	@RequestMapping("/insertTypeProduct")
	public void InsertTypeProduct(HttpServletResponse response,String checked,String packageTypeSn){
			try{
				String[] param = checked.split(",");
				for(int i=0;i<param.length;i++){
					HashMap<String,Object> map = new HashMap<String,Object>();
					map.put("packageTypeSn",packageTypeSn);
					map.put("productSn", param[i]);
					map.put("productNum",1);
					housesService.insertTypeProduct(map);
				}
				JSONObject json = new JSONObject();
				ajaxOutput(response,json.toString());
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	
	@RequestMapping("/deleteTypeProduct")
	public void DeleteTypeProduct(HttpServletResponse response,String packageproductsn){
		try{
			Long packageProductSn = Long.parseLong(packageproductsn);
			housesService.deleteTypeProduct(packageProductSn);
			JSONObject json = new JSONObject();
			json.put("packageProductSn", packageProductSn);
			ajaxOutput(response,json.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/setProductNum")
	public void setProductNum(HttpServletResponse response,String packageproductsn,String productNum){
		try{
			HashMap map = new HashMap<String,Object>();
			map.put("packageProductSn",packageproductsn);
			map.put("productNum",productNum);
			housesService.setProductNum(map);
			
			JSONObject json = new JSONObject();
			json.put("info", "succeed");
			ajaxOutput(response, json.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
