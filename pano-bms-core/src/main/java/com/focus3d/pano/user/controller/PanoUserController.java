package com.focus3d.pano.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;

/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/user")
public class PanoUserController extends BaseController{
	/**
	 * 
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "center", method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		
		//return "/member/user/center";
		return "/panoadm/admfirst";
	}

		
}
