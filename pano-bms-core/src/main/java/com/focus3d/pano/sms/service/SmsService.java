package com.focus3d.pano.sms.service;

import java.util.Map;

import com.focus3d.pano.constant.SmsSendTypeEnum;
/**
 *
 * *
 * @author lihaijun
 *
 */
public interface SmsService {

	public int send(SmsSendTypeEnum sendType, String mobile, Map<String, String> parame);
	public int send(SmsSendTypeEnum sendType, Map<String, String> parame);
}
