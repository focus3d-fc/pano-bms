package com.focus3d.pano.index.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_user_receive_address;
import com.focus3d.pano.usersside.service.PersonalService;

//           /userside/toindex
@Controller
@RequestMapping("/userside")
public class usersideController extends BaseController {

	@Autowired
	private PersonalService personalService;

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
		return "/userside/pro";
	}

	@RequestMapping("/toshare")
	public String toshare() {
		return "/userside/share";
	}

	@RequestMapping("/tomy")
	public String tomy(HttpServletRequest request) {
		Long SN = Long.parseLong(request.getParameter("SN"));
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

}
