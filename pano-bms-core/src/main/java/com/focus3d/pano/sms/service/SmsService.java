package com.focus3d.pano.sms.service;

import java.util.Map;
/**
 *
 * *
 * @author lihaijun
 *
 */
public interface SmsService {

	public String send(String mobile, Map<String, String> parame);
	public String send(Map<String, String> parame);
}
