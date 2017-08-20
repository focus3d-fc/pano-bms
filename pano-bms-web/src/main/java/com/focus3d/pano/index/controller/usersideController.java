package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.focus3d.pano.admin.service.IPerspectiveService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_user_receive_address;
import com.focus3d.pano.usersside.service.PersonalService;
import com.focus3d.pano.usersside.service.ProductRelevanceService;
import com.focustech.common.utils.JsonUtils;

//           /userside/toindex
@Controller
@RequestMapping("/userside")
public class usersideController extends BaseController {

	@Autowired
	IPerspectiveService _service;

	@Autowired
	private PersonalService personalService;

	@Autowired
	private ProductRelevanceService productRelevanceService;

	@RequestMapping("/toindex")
	public String toindex() {
		return "/userside/index";
	}

	@RequestMapping("/to720")
	public String to720() {
		return "/userside/720";
	}

	@RequestMapping("/toabout")
	public String toabout() {
		return "/userside/about";
	}

	@RequestMapping("/toaddaddress")
	public String toaddaddress() {
		return "/userside/addaddress";
	}

	@RequestMapping("/tocar")
	public String tocar() {
		return "/userside/car";
	}

	@RequestMapping("/tocarshow")
	public String tocarshow() {
		return "/userside/carshow";
	}

	@RequestMapping("/tocer")
	public String tocer() {
		return "/userside/cer";
	}

	@RequestMapping("/tocer_done")
	public String tocer_done() {
		return "/userside/cer-done";
	}

	@RequestMapping("/toconfirm")
	public String toconfirm() {
		return "/userside/confirm";
	}

	@RequestMapping("/tologin")
	public String tologin() {
		return "/userside/login";
	}

	@RequestMapping("/toorderAll")
	public String toorderAll() {
		return "/userside/orderAll";
	}

	@RequestMapping("/topaid")
	public String topaid() {
		return "/userside/paid";
	}

	@RequestMapping("/topaying")
	public String topaying() {
		return "/userside/paying";
	}

	@RequestMapping("/topro")
	public String topro() {
		return "/perspective/pro";
	}

	@RequestMapping("/toshare")
	public String toshare() {
		return "/userside/share";
	}

	@RequestMapping("/tomy")
	public String tomy(HttpServletRequest request,HttpSession session) {
		System.out.println("进入个人中心----");
		pano_mem_user userMsg_phone=(pano_mem_user) session.getAttribute("userMsg_phone");
		Long SN = userMsg_phone.getSN();//Long.parseLong(request.getParameter("SN"));
		System.out.println("用户sn:"+SN);
		pano_mem_user memuser = personalService.selUserbySN(SN);
		request.setAttribute("memuser", memuser);
		return "/userside/my";
	}

	
	// --------------------------------------------收货地址--------------------------------------------
	Long USER_SN;

	@RequestMapping("/toaddress")
	public String toaddress(HttpServletRequest request) {
		USER_SN = Long.parseLong(request.getParameter("USER_SN"));
		List<pano_user_receive_address> address = personalService
				.selAddressbyUserSN(USER_SN);
		request.setAttribute("address", address);
		return "/userside/address";
	}

	@RequestMapping("/toaddress2")
	public String toaddress2(HttpServletRequest request) {
		List<pano_user_receive_address> address = personalService
				.selAddressbyUserSN(USER_SN);
		request.setAttribute("address", address);
		return "/userside/address";
	}

	@RequestMapping("/addSite")
	public String addSite() {
		return redirect("toaddress2");
	}

	/**
	 * 透视图
	 */
	/*
	 * @RequestMapping("QueryPerspective") public String
	 * QueryPro(HttpServletResponse response, ModelMap model_map,
	 * HttpServletRequest request) { // 查询参数 String houseStyleSn = "1"; String
	 * packageTypeSn = "1"; String productSn = "100000"; // 验证有没有透视图
	 * HashMap<String, Object> result = new HashMap<String, Object>();
	 * HashMap<String, Object> map = new HashMap<String, Object>();
	 * map.put("houseStyleSn", houseStyleSn); map.put("packageTypeSn",
	 * packageTypeSn); map.put("productSn", productSn); List<Map<String,
	 * Object>> list = _service.QueryPerspectiveInfo(map);
	 * 
	 * for (Map<String, Object> child : list) { child.put("productSn",
	 * productSn); } result.put("count", list.size()); result.put("list",
	 * JsonUtils.arrayToJson(list.toArray()));
	 * 
	 * Map<String, Object> maps =
	 * _service.QueryPerspectiveByProductSn(houseStyleSn, packageTypeSn,
	 * productSn); int num = Integer.parseInt(map.get("count").toString()); if
	 * (num != 0) { model_map.put("viewlist", map.get("list"));
	 * 
	 * return "/perspective/pro"; }
	 * 
	 * return ""; }
	 */

	@ResponseBody
	@RequestMapping("/upset")
	public void upset(HttpServletRequest request, String productSn,
			HttpServletResponse response, ModelMap modelMap) {
		System.out.println("---------------ajax" + productSn);
		Long PRODUCT_SN = Long.parseLong(productSn);
		List<ProductRelevance> proList = productRelevanceService
				.selProbySN(PRODUCT_SN);
		ProductRelevance pro = proList.get(0);

		System.out.println("111111111111111==" + pro.getLEFT_IMG_SN());
		System.out.println("222222222222222==" + pro.getDOWN_IMG_SN());
		System.out.println("333333333333333==" + pro.getFULL_IMG_SN());
		System.out.println("444444444444444==" + pro.getBANNER_IMG_SN());
		System.out.println("555555555555555==" + pro.getFABRIC_IMG_SN());
		System.out.println("666666666666666==" + pro.getMATERIAL_IMG_SN());
		try {
			this.ajaxOutput(response, JsonUtils.objectToJson(pro));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
