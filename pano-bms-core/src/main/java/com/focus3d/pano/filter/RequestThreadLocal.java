package com.focus3d.pano.filter;

import com.focus3d.pano.model.PanoLoginModel;



/**
 *
 * *
 * @author lihaijun
 *
 */
public class RequestThreadLocal {

	public static final ThreadLocal<RequestMessageCookie> msgThreadLocal = new ThreadLocal<RequestMessageCookie>();
	public static final ThreadLocal<PanoLoginModel> loginInfoThreadLocal = new ThreadLocal<PanoLoginModel>();

	public static RequestMessageCookie getMessageCookie(){
		RequestMessageCookie requestMessageCookie = msgThreadLocal.get();
		if(requestMessageCookie == null){
			requestMessageCookie = new RequestMessageCookie();
			msgThreadLocal.set(requestMessageCookie);
		}
		return requestMessageCookie;
	}

	public static PanoLoginModel getLoginInfo(){
		return loginInfoThreadLocal.get();
	}

	public static void setLoginInfo(PanoLoginModel loginInfo){
		if(loginInfo != null){
			loginInfoThreadLocal.set(loginInfo);
		}
	}
	public static void setLoginInfo(Object loginInfo){
		if(loginInfo != null && loginInfo instanceof PanoLoginModel){
			loginInfoThreadLocal.set((PanoLoginModel)loginInfo);
		} else {
			loginInfoThreadLocal.remove();
		}
	}

	public static void cleanAll(){
		msgThreadLocal.remove();
		loginInfoThreadLocal.remove();
	}
}
