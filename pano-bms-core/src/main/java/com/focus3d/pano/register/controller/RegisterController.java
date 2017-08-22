package com.focus3d.pano.register.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.constant.SmsSendTypeEnum;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.PanoValidateModel;
import com.focus3d.pano.sms.service.SmsService;
import com.focus3d.pano.user.service.PanoUserService;
import com.focus3d.pano.validate.service.PanoValidateService;
import com.focustech.common.utils.StringUtils;

/**
 * 申请代理
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/user/register")
public class RegisterController extends BaseController{
	@Autowired
	private PanoUserService<PanoUserModel> panoUserService;
	//@Autowired
	//private PanoLoginService<PanoLoginModel> panoLoginService;
	@Autowired
	private SmsService smsService;
	@Autowired
	private PanoValidateService<PanoValidateModel> panoValidateService;
	
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String create(ModelMap modelMap){
		return "/member/user/register";
	}
	/**
	 *
	 *
	 * *
	 * @param userVO
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(PanoUserModel userVO, ModelMap modelMap, HttpServletRequest req){
		String nickName = userVO.getNickName();
		String mobilePhone = userVO.getLogin().getLoginName();
		String password = userVO.getLogin().getPassword();
		String smsCode = userVO.getLogin().getSmsCode();
		String msg = "";
		if(StringUtils.isEmpty(nickName)){
			msg = "昵称不能为空";
		}
		else if(StringUtils.isEmpty(mobilePhone)){
			msg = "手机号不能为空";
		}
		else if(StringUtils.isEmpty(password)){
			msg = "密码不能为空";
		}
		else if(StringUtils.isEmpty(smsCode)){
			msg = "短信验证码不能为空";
		} else {
			PanoValidateModel messageValidate = panoValidateService.getByCode(mobilePhone, smsCode);
			if(messageValidate != null){
				if(mobilePhone.equals(messageValidate.getSendObj())){
						PanoUserModel userDO = panoUserService.getByMobile(mobilePhone);
						if(userDO != null){
							msg = "改手机号码已存在，请换一个。";
						} else {
							panoUserService.register(userVO, messageValidate);
							//自动登录进入会员中心
							/*PanoLoginModel loginInfo = panoLoginService.getByName(userVO.getMobile());
							req.getSession().setAttribute(LoginFilter.SESSION_KEY, loginInfo);
							RequestThreadLocal.setLoginInfo(loginInfo);*/
							Map<String, String> parame = new HashMap<String, String>();
							parame.put("userMobile", mobilePhone);
							//smsService.send(SmsSendTypeEnum.USER_REGISTER_FEEDBACK, parame);
							return redirect("/user/register/success");
						}
					} else {
						msg = "手机号码输入有误";
					}
				} else {
					msg = "短信验证码有误";
				}
		} 
		modelMap.put("user", userVO);
		modelMap.put("message", msg);
		return "/member/user/register";
	}
	/**
	 * 
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String success(ModelMap modelMap){
		return "/member/user/register_success";
	}
}
