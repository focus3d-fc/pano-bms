package com.focus3d.pano.wechat.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.wechat.utils.Constants;
import com.focus3d.pano.wechat.utils.OAuthUtil;
import com.focus3d.pano.wechat.utils.OAuthUtil.Token;
import com.focus3d.pano.wechat.utils.OAuthUtil.UserInfo;


@Controller
@RequestMapping("/wechat")
public class WeChatAuthController extends BaseController {
	
	@RequestMapping(value="/oauth")
	public void oauth(HttpServletRequest request, HttpServletResponse response){
		System.out.println("进入网页授权...");
		String redirect = "";
		try{
			redirect = URLEncoder.encode(Constants.WXMP_OAUTH_REDIRECT, "utf-8");
			String uri = String.format(Constants.WXMP_OAUTH_URI, Constants.WXMP_APPID, redirect);
			response.sendRedirect(uri);
		}catch(UnsupportedEncodingException e){	
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/redirect")
	public String redirect(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			String code, 
			String state) throws Exception{
		
		try{
			System.out.println("进入重定向...Code:"+code+"|State:"+state);
			Token token = OAuthUtil.redirect(code);
			UserInfo userInfo = OAuthUtil.userinfo(token.getAccess_token(), token.getOpenid(), Constants.WXMP_OAUTH_USERINFO_LANG);
			//model.addAttribute("userInfo", userInfo);
			session.setAttribute(Constants.SESSION_WX_USER, userInfo);
			/**
			 * 业务流程：
			 * 判断该openid是否和手机号码绑定
			 * 如果绑定显示个人信息；
			 * 如果未绑定进入绑定页面，绑定成功后进入个人页面；
			 * 
			 * REMIND: 此处暂时不涉及登录
			 */
			String openid = userInfo.getOpenid();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/wechat/userInfo";
	}
	
	@ResponseBody
	@RequestMapping("/userInfo")
	public String userInfo(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception{
		
		try{
			request.setCharacterEncoding("utf-8");
			UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_WX_USER);
			
			String x = userInfo.getOpenid() +"<br/>";
			x+= userInfo.getCity() +"<br/>";
			x+= userInfo.getCountry() +"<br/>";
			x+= userInfo.getHeadimgurl() +"<br/>";
			x+= userInfo.getNickname() +"<br/>";
			x+= userInfo.getProvince() +"<br/>";
			x+= userInfo.getSex() +"<br/>";
			x+= userInfo.getUnionid() +"<br/>";
			
			return x;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
}
