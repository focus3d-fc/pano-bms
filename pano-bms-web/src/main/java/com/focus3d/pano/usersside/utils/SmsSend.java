package com.focus3d.pano.usersside.utils;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @author tianyh 
 * @Description:普通短信发送
 */
public class SmsSend {

	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "N7476327";
	// 用户平台API密码(非登录密码)
	public static String pswd = "79t2jmpnZC24eb";
    //public static void main(String[] args)     public void sendPhoneCode(String phone)
	public String sendPhoneCode(String phone) throws UnsupportedEncodingException {

		//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsSingleRequestServerUrl = "http://smsbj1.253.com/msg/send/json";
		// 短信内容
		String phoneCode = "";
		StringBuffer builder = new StringBuffer(phoneCode);
		/*
		 * StringBuilder append(String str)
		 * 向当前字符串末尾追加给定内容
		 */
		for(int i=0;i<6;i++){
			int x=(int)(Math.random()*10);
			builder.append(x);
		}
		//获取StringBuilder内部修改好的字符串
		phoneCode = builder.toString();
		System.out.println("随机验证码为："+phoneCode);
	    String msg = "【格物至居】您的验证码是："+phoneCode;
		//手机号码
		//String phone = "18952133329";
		//状态报告
		String report= "true";
		
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		
		String requestJson = JSON.toJSONString(smsSingleRequest);
		
		System.out.println("1.requestJson: " + requestJson);
		
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		
		System.out.println("2.response:" + response);
		
		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
		
		System.out.println("3.smsSingleResponse:" + smsSingleResponse);
		
		return phoneCode;
	
	}


}
