package com.focus3d.pano.login.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.common.spring.RedirectAttributes;
import com.focus3d.pano.filter.LoginFilter;
import com.focus3d.pano.filter.RequestThreadLocal;
import com.focus3d.pano.login.service.PanoLoginService;
import com.focus3d.pano.model.PanoLoginModel;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;

/**
 * 
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/user/login")
public class LoginController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private PanoLoginService<PanoLoginModel> panoLoginService;
	private static final String VIEW_LOGIN = "/member/user/login";
	private static final String VIEW_CENTER = "/user/center";
	@Value("${pano.source.code.protect}")
	private boolean codeProtect;
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap){
		if(!codeProtect){
			return VIEW_LOGIN;
		} 
		return redirect("");
	}
	/**
	 * 
	 * *
	 * @param loginVo
	 * @param modelMap
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(PanoLoginModel loginVo, ModelMap modelMap, HttpServletRequest req, HttpServletResponse response, RedirectAttributes redirectAttributes){
		String view = VIEW_LOGIN;
		String loginName = loginVo.getLoginName();
		String password = loginVo.getPassword();
		String validCode = loginVo.getValidCode();
		int status = 0;
		if(StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(password)){
			boolean showValidateCode = TCUtil.bv(req.getSession().getAttribute("showValidateCode"));
			boolean validateCodeOk = false;
			if(showValidateCode){
				if(StringUtils.isNotEmpty(validCode)){
					String sessionValidCode = TCUtil.sv(req.getSession().getAttribute("captcha"));
					if(sessionValidCode.equalsIgnoreCase(validCode)){
						validateCodeOk = true;
					}
				} 
			}
			if((showValidateCode && validateCodeOk) || !showValidateCode){
				boolean validate = false;
				PanoLoginModel loginDO = panoLoginService.getByName(loginName);
				if(loginDO != null){
					//validate = loginDO.getPassword().equals(MD5Util.MD5Encode(password, ""));
					validate = loginDO.getPassword().equals(password);
					if(validate){
						int loginStatus = loginDO.getStatus();
						if(loginStatus == 1){
							req.getSession().setAttribute(LoginFilter.SESSION_KEY, loginDO);
							RequestThreadLocal.setLoginInfo(loginDO);
							view = VIEW_CENTER;
						}
						Integer loginTimes = TCUtil.iv(loginDO.getLoginTimes());
						loginDO.setLoginTimes(++ loginTimes);
						loginDO.setLastLoginTime(new Date());
						panoLoginService.update(loginDO);
					}
				} 
				if(!validate){
					status = 3;
				}
			} else {
				status = 2;
			}
		} else {
			status = 1;
		}
		String msg = "";
		if(status == 2){
			msg = "图形验证码有误";
		} else if(status == 3){
			msg = "用户名或者密码错误";
		} else if(status == 1){
			msg = "请填写完整的信息";
		}
		req.getSession().setAttribute("showValidateCode", status != 0);
		redirectAttributes.addFlashAttribute(msg);
		//modelMap.addAttribute("login", loginVo);
		return redirect(view);
	}
}
