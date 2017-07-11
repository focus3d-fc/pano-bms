package com.focus3d.pano.password.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.filter.LoginFilter;
import com.focus3d.pano.filter.RequestThreadLocal;
import com.focus3d.pano.login.service.PanoLoginService;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.user.service.PanoUserService;
import com.focus3d.pano.validate.service.PanoValidateService;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.MD5Util;
import com.focustech.common.utils.StringUtils;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/user/password")
public class PasswordController extends BaseController{
	@Autowired
	private PanoUserService<PanoUserModel> userService;
	@Autowired
	private PanoLoginService<PanoLoginModel> loginService;
	@Autowired
	private PanoValidateService<PanoValidateModel> validateService;
	
	/**
	 *
	 * *
	 * @param uid
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify(ModelMap modelMap, HttpServletRequest req){
		try {
			PanoLoginModel currentLogin = RequestThreadLocal.getLoginInfo();
			if(currentLogin != null){
				PanoLoginModel PtsLogin = loginService.getBySn(currentLogin.getSn());
				Long userId = PtsLogin.getUserSn();
				if(userId != null && userId > 0){
					PanoUserModel user = userService.getBySn(userId);
					if(user != null){
						user.setEncryptSn(EncryptUtil.encode(userId));
					}
					modelMap.put("user", user);
				}
				String message = RequestThreadLocal.getMessageCookie().getMessage();
				modelMap.put("message", message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/member/user/password_modify";
	}
	/**
	 *
	 * *
	 * @param uid
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(PanoLoginModel loginVO, ModelMap modelMap, HttpServletRequest req){
		PanoLoginModel currentLogin = RequestThreadLocal.getLoginInfo();
		String loginName = currentLogin.getLoginName();
		String password = loginVO.getPassword();
		String passwordNew = loginVO.getPasswordNew();
		String passwordNewS = loginVO.getPasswordConfirm();
		String verifyCode = loginVO.getSmsCode();
		String msg = "";
		String view = "/member/user/password_modify";
		if(StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(passwordNew) && StringUtils.isNotEmpty(passwordNewS) && StringUtils.isNotEmpty(verifyCode)){
			if(!passwordNew.equals(passwordNewS)){
				msg = "两次输入的新密码不一致";
			}
			else if(StringUtils.isNotEmpty(loginName)){
				PanoValidateModel messageValidate = validateService.getByCode(loginName, verifyCode);
				if(messageValidate != null){
					PanoLoginModel loginDO = loginService.getByName(loginName);
					if(loginDO != null){
						boolean isValidate = loginDO.getPassword().equals(MD5Util.MD5Encode(password, ""));
						if(isValidate){
							loginDO.setPassword(MD5Util.MD5Encode(passwordNew, ""));
							loginService.update(loginDO);
							req.getSession().removeAttribute(LoginFilter.SESSION_KEY);
							view = redirect("/user/login");
						} else {
							msg = "原始密码输入有误";
						}
					} else {
						msg = "用户不存在";
					}
				} else {
					msg = "短信验证码有误";
				}
			} else {
				msg = "请登录";
			}
		} else {
			msg = "密码不能为空";
		}
		if(StringUtils.isNotEmpty(msg)){
			modelMap.put("message", msg);
		}
		return view;
	}
	
	/**
	 *
	 * *
	 * @param uid
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String getChangePasswordOut(ModelMap modelMap, HttpServletRequest req){
		return "/member/user/password_find";
	}
	/**
	 * 
	 * *
	 */
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String postChangePasswordOut(PanoLoginModel loginVO, ModelMap modelMap, HttpServletRequest req){
		String loginName = loginVO.getLoginName();
		String password = loginVO.getPassword();
		String passwordNew = loginVO.getPasswordNew();
		String passwordNewS = loginVO.getPasswordConfirm();
		String verifyCode = loginVO.getSmsCode();
		String msg = "";
		String view = "/member/user/password_find";
		if(StringUtils.isNotEmpty(passwordNew) && StringUtils.isNotEmpty(passwordNewS) && StringUtils.isNotEmpty(verifyCode)){
			if(!passwordNew.equals(passwordNewS)){
				msg = "两次输入的新密码不一致";
			}
			else if(StringUtils.isNotEmpty(loginName)){
				PanoValidateModel messageValidate = validateService.getByCode(loginName, verifyCode);
				if(messageValidate != null){
					PanoLoginModel loginDO = loginService.getByName(loginName);
					if(loginDO != null){
						loginDO.setPassword(MD5Util.MD5Encode(passwordNew, ""));
						loginService.update(loginDO);
						req.getSession().removeAttribute(LoginFilter.SESSION_KEY);
						view = redirect("/user/login");
					} else {
						msg = "用户不存在";
					}
				} else {
					msg = "短信验证码有误";
				}
			} else {
				msg = "请登录";
			}
		} else {
			msg = "密码不能为空";
		}
		if(StringUtils.isNotEmpty(msg)){
			RequestThreadLocal.getMessageCookie().addMessage(msg);
		}
		return view;
	}
	
}
