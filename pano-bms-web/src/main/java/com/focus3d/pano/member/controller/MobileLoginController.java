package com.focus3d.pano.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.member.service.PanoMemLoginService;
import com.focus3d.pano.model.PanoMemLoginModel;
import com.focustech.common.utils.StringUtils;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/mobile/login")
public class MobileLoginController extends BaseController {
	@Autowired
	private PanoMemLoginService<PanoMemLoginModel> memLoginService;
	/**
	 * 
	 * *
	 * @param memLoginModel
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(PanoMemLoginModel memLoginModel, ModelMap modelMap){
		String mobile = memLoginModel.getLoginName();
		String verifyCode = memLoginModel.getVerifyCode();
		if(StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(verifyCode)){
			
		}
		return redirect("/userside/tologin");
	}
}
