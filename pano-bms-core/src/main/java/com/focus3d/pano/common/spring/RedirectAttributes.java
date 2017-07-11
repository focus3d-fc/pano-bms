package com.focus3d.pano.common.spring;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class RedirectAttributes {
	public static final String MESSAGE = "message";
	public static final String MESSAGE_TYPE = "messageType";
	public static final String MSG = "msg";
	private HttpServletRequest request;


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void addFlashAttribute(String name, Object value){
		request.getSession().setAttribute(name, value);
	}

	public void addFlashAttribute(RedirectAttributesType type, Object value){
		request.getSession().setAttribute(MESSAGE_TYPE, type.getCode());
		addFlashAttribute(value);
	}

	public void addFlashAttribute(Object value){
		request.getSession().setAttribute(MESSAGE, value);
	}
	/**
	 *
	 * *
	 * @param name
	 * @return
	 */
	public Object getFlashAttribute(String name){
		return request.getSession().getAttribute(name);
	}
}
