package com.focus3d.pano.wechat.service;

import java.util.Map;
import com.focus3d.pano.wechat.utils.*;

public class WeChatPayService {
	
	public WxPay wp;
	
	public WeChatPayService(WeChatConfig config) throws Exception {
		WxPayConfig configi = new WxPayConfigImpl(config);
		this.wp = new WxPay(configi);
	}
	
	public Map<String, String> unifiedOrder(Map<String, String> reqData) throws Exception{
		return this.wp.unifiedOrder(reqData);
	};
}