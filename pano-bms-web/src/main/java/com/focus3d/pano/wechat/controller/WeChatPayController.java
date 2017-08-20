package com.focus3d.pano.wechat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.common.controller.BaseController;

import com.focus3d.pano.wechat.service.WeChatPayService;
import com.focus3d.pano.wechat.utils.*;

@Controller
@RequestMapping("/wechat")
public class WeChatPayController extends BaseController {
	
	@Autowired
    WeChatConfig wx;
	
	@RequestMapping("/testPay")
	public String pay(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		
		WeChatPayService wp = new WeChatPayService(wx);
		
		try{
			
			UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_WX_USER);
			
			HashMap<String, String> data = new HashMap<String, String>();
			
	        data.put("body", "focus3d 支付测试"); // 订单信息
	        data.put("out_trade_no", "zs"+new Date().getTime()); // 订单编号
	        data.put("device_info", "1");
	        data.put("fee_type", "CNY");
	        data.put("total_fee", "1"); // 订单金， 这里单位是分 记得转换 *100
	        data.put("spbill_create_ip", "127.0.0.1"); // 获取ip地址填入
	        data.put("notify_url", "http://gwzj.joy-homeplus.com/wechat/testNotify");
	        data.put("trade_type", "JSAPI");
	        data.put("openid", userInfo.getOpenid());
	        
	        Map<String, String> r = wp.unifiedOrder(data);

	        if("SUCCESS".equals(r.get("result_code"))){
	        	// 二次签名
//	        	SortedMap<Object, Object> paySingMap = new TreeMap<Object, Object>();
//	        	paySingMap.put("appId", wx.getAppId());
//	        	paySingMap.put("noncestr", WxPayUtil.generateNonceStr());
//	        	paySingMap.put("package", "prepay_id="+r.get("prepay_id"));
//	        	paySingMap.put("timeStamp", new Date().getTime()/1000+"");
//	        	paySingMap.put("signType", "MD5");
//	        	
//	        	String pay_sing = WxPayUtil.createSign("utf-8", paySingMap, wx.getMchKey());
	        	
	        	
	        	Map<String, String> payParam = new TreeMap<String, String>();
	            payParam.put("appId", wx.getAppId());
	            payParam.put("nonceStr", WxPayUtil.generateNonceStr());
	            payParam.put("package", "prepay_id="+r.get("prepay_id"));
	            payParam.put("signType", "MD5");
	            payParam.put("timeStamp", new Date().getTime()/1000+"");
	            String secondSign = WxPayUtil.generateSignature(payParam, wx.getMchKey());
	            
	            payParam.put("paySign", secondSign);
		        
		        request.setAttribute("result", payParam);
	        }
	        
		}catch(Exception e){

			e.printStackTrace();
	        
		}
        return "/wechat/pay";
		
	}
	
	@ResponseBody
	@RequestMapping("/testNotify")
	public String notify(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return new Date().getTime()+"";
	}
}
