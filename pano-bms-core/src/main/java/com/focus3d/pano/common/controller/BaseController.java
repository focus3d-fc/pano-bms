package com.focus3d.pano.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.focustech.common.utils.TCUtil;

/**
 * 
 * *
 * @author lihaijun
 *
 */
public class BaseController {
	
	@ModelAttribute
	public void initCommon(ModelMap modelMap, HttpServletRequest req){
		modelMap.put("isMobile", getMobileSystemType(req) != 0);
	}
	/**
	 * 是否微信内置浏览器
	 * *
	 * @param ua
	 * @return
	 */
	public boolean isWeixinBrowser(String ua){
		if(ua.contains("micromessenger")){
			return true;
		}
		return false;
	}
	/**
	 * 获取移动设备类型
	 * *
	 * @param ua 需要转换成小写
	 * @return
	 */
	public String getMobileType(String ua){
		if(ua.contains("iphone")){
			return "1";
		}
		if(ua.contains("android")){
			return "2";
		}
		return "0";
	}
	
	/**
	 *
	 * *
	 * @param req
	 * @return
	 */
	public boolean isWeixinBrowser(HttpServletRequest req){
       String ua = TCUtil.sv(req.getHeader("User-Agent")).toLowerCase();
       return ua.contains("micromessenger");
   }
	/**
	 *
	 * *
	 * @param req
	 * @return
	 */
	public int getMobileSystemType(HttpServletRequest req){
       String ua = TCUtil.sv(req.getHeader("User-Agent")).toLowerCase();
       if(ua.contains("iphone") || ua.contains("ipad")){
       	return 2;
       }
       return !ua.contains("android") ? 0 : 1;
	}
	
	 /**
     * ajax输出
     *
     * @param response HttpServletResponse
     * @param outputString 输出字符
     * @throws IOException 输出流异常

     */
    protected void ajaxOutput(HttpServletResponse response, String outputString) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write(outputString);
        response.getWriter().flush();
    }

    /**
     * 使用redirect跳转到指定的请求上
     *
     * @param URI 指定的请求链接
     * @return
     */
    protected String redirect(String URI, Integer statusCode, HttpServletRequest req) {
    	req.getSession().setAttribute("saveCode", TCUtil.sv(statusCode));
    	return redirect(URI);
    }

    /**
     * 使用redirect跳转到指定的请求上
     *
     * @param URI 指定的请求链接
     * @return
     */
    public static String redirect(String URI) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("redirect:");
        stringBuilder.append(URI);
        return stringBuilder.toString();
    }
}
