package com.focus3d.pano.sms.util;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.focus3d.pano.sms.request.SmsSendRequest;
import com.focus3d.pano.sms.response.SmsSendResponse;
import com.focus3d.pano.sms.util.ChuangLanSmsUtil;
/**
 * 
 * *
 * @author lihaijun
 *
 */
public class SmsSendClient {

	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "N7630417";
	// 用户平台API密码(非登录密码)
	public static String pswd = "0LPYw2b5uc84a9";
	//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
	public String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
	
	public SmsSendResponse send(String phone, String msg){
		//状态报告
		String report= "true";
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		
		String requestJson = JSON.toJSONString(smsSingleRequest);
		
		System.out.println("before request string is: " + requestJson);
		
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		
		return JSON.parseObject(response, SmsSendResponse.class);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		SmsSendClient client = new SmsSendClient();
		
		client.send("13451836990", "d333dsfd斤斤计较");
	}




}
