package com.focus3d.pano.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.filter.LoginFilter;
import com.focus3d.pano.member.service.PanoMemUserService;
import com.focus3d.pano.model.PanoMemLoginModel;
import com.focus3d.pano.model.PanoMemUserModel;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.sms.service.SmsValidateService;
import com.focustech.common.utils.StringUtils;
/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/member/login")
public class MobileLoginController extends BaseController {
	@Autowired
	private PanoMemUserService<PanoMemUserModel> memUserService;
	@Autowired
	private SmsValidateService smsValidateService;
	/**
	 * 
	 * *
	 * @param memLoginModel
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "nomal", method = RequestMethod.POST)
	public String login(PanoMemLoginModel memLoginModel, ModelMap modelMap, HttpServletRequest request){
		String mobile = memLoginModel.getLoginName();
		String smsCode = memLoginModel.getSmsCode();
		if(StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(smsCode)){
			PanoValidateModel messageValidate = smsValidateService.selectByMobilePhone(mobile, smsCode);
			if(messageValidate != null && messageValidate.getStatus() == 1){
				memUserService.insertOrUpdate(memLoginModel, 2);
				smsValidateService.setStatus(messageValidate, 0);
				addLoginToSession(memLoginModel, request);;
			}
		}
		return redirect("/usersSide/tomy");
	}
	/**
	 * 
	 * *
	 * @param modelMap
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "exist", method = RequestMethod.POST)
	public String exist(ModelMap modelMap, HttpServletRequest request){
		removeLoginFromSession(request);
		return redirect("/userside/tologin");
	}
	/**
	 * 
	 * *
	 * @param memLoginModel
	 * @param request
	 */
	private void addLoginToSession(PanoMemLoginModel memLoginModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(LoginFilter.SESSION_KEY);
		session.setAttribute(LoginFilter.SESSION_KEY, memLoginModel);
	}
	/**
	 * 
	 * *
	 * @param request
	 */
	private void removeLoginFromSession( HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(LoginFilter.SESSION_KEY);
	}
}
