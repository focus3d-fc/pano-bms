package com.focus3d.pano.index.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.ResultVO;
import com.focustech.common.codec.DefaultEncryptService;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/users")
public class PanoUserlonginController extends BaseController{
	@Autowired
	private PanoUserLongInService user;
	@Autowired
	private DefaultEncryptService encryptService;
	
	@RequestMapping("lonins")
	public String lonins(){
		return "/member/user/login";
		
	}
	
	@RequestMapping("/longin")
	public void UserLongin(HttpServletRequest request,HttpServletResponse response,HttpSession session,String userName,String passWord){
		PanoUserLongin longIn = new PanoUserLongin();
		ResultVO rv = new ResultVO();
		longIn.setNick_name(userName);
		longIn.setPassword(passWord);
		PanoUserLongin userLongin = user.getUserLongin(longIn);
		if(userLongin != null){
			
			rv.setObjData(userLongin);
			doSSO(userName, passWord, request, response);
			session.setAttribute("user",userLongin );
			
			if(userLongin.getStatus() == 2){
				rv.setResult("error");
				rv.setResCode("用户已被锁定");
			}else{
				rv.setResult("success");
				rv.setResCode(null);
			}
		}else{
			rv.setResult("error");
			rv.setResCode("用户名或者密码错误");
		}

		String objectToJson = JsonUtils.objectToJson(rv);
		try {
			this.ajaxOutput(response,objectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void doSSO(String loginName, String password, HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if("pano_ticket".equals(name)){
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		JSONObject jo = new JSONObject();
		jo.put("usn", loginName);
		jo.put("pwd", password);
		Cookie ck = new Cookie("pano_ticket", encryptService.encrypt(jo.toString(), null));
		ck.setPath("/");
		ck.setMaxAge(-1);
		ck.setDomain("joy-homeplus.com");
		response.addCookie(ck);
	}
	
	@RequestMapping("/homepage")
	public String homepage(HttpSession session,HttpServletRequest request){
		PanoUserLongin longins =(PanoUserLongin)session.getAttribute("user");
		PanoBmRoleResource pbrr = new PanoBmRoleResource();
		pbrr.setRole_basics(longins.getRole_basics());
		pbrr.setRole_houses(longins.getRole_houses());
		pbrr.setRole_order(longins.getRole_order());
		pbrr.setRole_product(longins.getRole_product());
		pbrr.setRole_user(longins.getRole_user());
		pbrr.setRole_role(longins.getRole_role());
		pbrr.setRole_promotioncode(longins.getRole_promotioncode());
		pbrr.setRole_panorama(longins.getRole_panorama());
		request.setAttribute("pbrr", pbrr);
		return "/panoadm/admfirst";
		
	}
	
	
	
}
