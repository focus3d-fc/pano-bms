package com.focus3d.pano.wechat.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeChatConfig {
	
	public String appId;
	public String appSecret;
	public String mchId;
	public String mchKey;
	public String keyPath;
	public String notifyUrl;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public void setMchKey(String mchKey) {
		this.mchKey = mchKey;
	}
	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public String getMchId() {
		return mchId;
	}
	public String getMchKey() {
		return mchKey;
	}
	public String getKeyPath() {
		return keyPath;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	
	
} 
