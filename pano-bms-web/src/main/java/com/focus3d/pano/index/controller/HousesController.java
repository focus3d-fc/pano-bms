package com.focus3d.pano.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 樓盤管理
 * 
 * @author 熊峰
 *
 */

@Controller
@RequestMapping("/houses")
public class HousesController {

	@RequestMapping("/tohouse")
	public String tohouse() {
		return "/houses/house";
	}
	
	@RequestMapping("/tohouseSet")
	public String tohouseSet() {
		return "/houses/houseSet";
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
