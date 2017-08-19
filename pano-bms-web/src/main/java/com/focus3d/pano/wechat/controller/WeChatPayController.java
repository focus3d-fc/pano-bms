package com.focus3d.pano.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.common.controller.BaseController;

import com.focus3d.pano.wechat.utils.*;
import com.focus3d.pano.wechat.service.*;

@Controller
@RequestMapping("/wechat")
public class WeChatPayController extends BaseController {
	
	@RequestMapping("/testPay")
	public String pay(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		
		try{
			WeChatPayService wp = new WeChatPayService();
			
			HashMap<String, String> data = new HashMap<String, String>();
			
	        data.put("body", "focus3d 支付测试");
	        data.put("out_trade_no", "1993092019231");
	        data.put("device_info", "1");
	        data.put("fee_type", "CNY");
	        data.put("total_fee", "1");
	        data.put("spbill_create_ip", "127.0.0.1");
	        data.put("notify_url", "http://gwzj.joy-homeplus.com/wechat/testNotify");
	        data.put("trade_type", "JSAPI");
	        data.put("product_id", "12");
	        data.put("openid", "oHSqcw37i18XF01iXDEasSFpbNZY");

	        Map<String, String> r = wp.unifiedOrder(data);
	        request.setAttribute("result", r);
		}catch(Exception e){

			e.printStackTrace();
	        
		}
        return "/wechat/pay";
		
	}
	
	@ResponseBody
	@RequestMapping("/testNotify")
	public String notify(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return "支付成功";
	}
}
