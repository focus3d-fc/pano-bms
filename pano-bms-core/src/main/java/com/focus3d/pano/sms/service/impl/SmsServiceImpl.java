package com.focus3d.pano.sms.service.impl;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.focus3d.pano.sms.response.SmsSendResponse;
import com.focus3d.pano.sms.service.SmsService;
import com.focus3d.pano.sms.util.SmsSendClient;
import com.focustech.common.utils.TCUtil;
/**
 * 短信服务
 * *
 * @author lihaijun
 *
 */
@Service
public class SmsServiceImpl implements SmsService {
	private SmsSendClient smsSendClient = new SmsSendClient();
	
	private static final String PREFIX = "短信";
	private ExecutorService pool = Executors.newFixedThreadPool(4);

	@Override
	public String send(String mobileStr, Map<String, String> parame) {
		String verifyCode = TCUtil.sv(parame, "verifyCode");
		String msg = PREFIX + "校验码 " + verifyCode + "。";
		//发短信通知
		Future<Object> future = pool.submit(new smsTask(mobileStr, msg));
		String sv = "";
		try {
			sv = TCUtil.sv(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return sv;
	}
	/**
	 *
	 * *
	 * @author lihaijun
	 *
	 */
	class smsTask implements Callable<Object> {

		private String mobileStr;
		private String msg;

		public smsTask(String mobileStr, String msg){
			this.mobileStr = mobileStr;
			this.msg = msg;
		}

		@Override
		public Object call() throws Exception {
			SmsSendResponse send = smsSendClient.send(mobileStr, msg);
			return send.getCode();
		}
		
	}
	@Override
	public String send(Map<String, String> parame) {
		return send("", parame);
	}
	
}
