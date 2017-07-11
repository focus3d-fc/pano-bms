package com.focus3d.pano.sms.service.impl;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.focus3d.pano.constant.SmsSendTypeEnum;
import com.focus3d.pano.sms.service.SmsService;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.bundle.sms.client.SmsClient;
/**
 * 短信服务
 * *
 * @author lihaijun
 *
 */
@Service
public class SmsServiceImpl implements SmsService {
	private static final Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);
	@Autowired
	private SmsClient smsClient;
	@Value(value = "${sms.rev.mobile}")
	private String f3dPhoneList;
	@Value("${pano.source.code.protect}")
	private boolean codeProtected;
	
	private static final String PREFIX = "[F3D 全景营销]";
	private ExecutorService pool = Executors.newFixedThreadPool(4);

	@Override
	public int send(SmsSendTypeEnum sendType, String mobileStr, Map<String, String> parame) {
		int status = 0;
		boolean isMember = false;
		if(parame != null){
			String msg = "";
			//String curDate = DateUtils.getCurDate(DateUtils.DEFAULT_FORMATE_ALL);
			String userMobile = TCUtil.sv(parame, "userMobile");
			String userName = TCUtil.sv(parame, "userName");
			String revMobile = "";
			if(SmsSendTypeEnum.USER_REGISTER.equals(sendType)){
				isMember = true;
				String verifyCode = TCUtil.sv(parame, "verifyCode");
				msg = PREFIX + " 您正在注册，验证码 " + verifyCode;
			}
			if(SmsSendTypeEnum.USER_REGISTER_FEEDBACK.equals(sendType)){
				isMember = true;
				msg = PREFIX + " 新用户注册，手机：" + userMobile;
			}
			//发短信通知
			log.info("计划发送给：" + mobileStr);
			if(isMember)
			{
				if(StringUtils.isEmpty(mobileStr)){
					mobileStr = f3dPhoneList;
				} 
			} 
			else 
			{
				if(!codeProtected){
					mobileStr = f3dPhoneList;
					log.info("系统处于测试状态，短信统一发送给：" + mobileStr);
				} else {
					if(StringUtils.isEmpty(mobileStr)){
						mobileStr = f3dPhoneList;
					} else {
						mobileStr += f3dPhoneList;
					}
					log.info("系统处于发布状态，短信统一发送给：" + mobileStr);
				}
			}
			pool.execute(new smsTask(mobileStr, msg));
		
		}
		return status;
	}
	/**
	 *
	 * *
	 * @author lihaijun
	 *
	 */
	class smsTask implements Runnable {

		private String mobileStr;
		private String msg;

		public smsTask(String mobileStr, String msg){
			this.mobileStr = mobileStr;
			this.msg = msg;
		}
		@Override
		public void run() {
			String[] split = mobileStr.split(",");
			for (String mobile : split) {
				try {
					if(StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(msg)){
						smsClient.send(mobile, msg);
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
	}


	@Override
	public int send(SmsSendTypeEnum sendType, Map<String, String> parame) {
		return send(sendType, "", parame);
	}
}
