package com.focus3d.pano.wechat.service;

import java.util.Map;
import com.focus3d.pano.wechat.utils.*;

public class WeChatPayService {
	
	public WxPay wp;
	
	public WeChatPayService() throws Exception {
		WxPayConfig config = new WxPayConfigImpl();
		this.wp = new WxPay(config);
	}
	
	public Map<String, String> unifiedOrder(Map<String, String> reqData) throws Exception{
		return this.wp.unifiedOrder(reqData);
	};
}