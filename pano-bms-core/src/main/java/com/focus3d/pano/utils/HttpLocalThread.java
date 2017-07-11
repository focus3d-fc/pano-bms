package com.focus3d.pano.utils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class HttpLocalThread {

	private static ThreadLocal<HttpServletRequest> reqThreadLocal = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest get(){
		return reqThreadLocal.get();
	}

	public static void add(HttpServletRequest request){
		reqThreadLocal.set(request);
	}

	public static ThreadLocal<HttpServletRequest> getReqThreadLocal() {
		return reqThreadLocal;
	}

	public static void setReqThreadLocal(ThreadLocal<HttpServletRequest> reqThreadLocal) {
		HttpLocalThread.reqThreadLocal = reqThreadLocal;
	}


}
