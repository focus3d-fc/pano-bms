package com.focus3d.pano.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//           /userside/toindex
@Controller
@RequestMapping("/userside")
public class usersideController {

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

	@RequestMapping("/toaddress")
	public String toaddress() {
		return "/userside/address";
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

	@RequestMapping("/tomy")
	public String tomy() {
		return "/userside/my";
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

}
