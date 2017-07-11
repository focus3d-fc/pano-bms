package com.focus3d.pano.common.spring;
/**
 *
 * *
 * @author lihaijun
 *
 */
public enum RedirectAttributesType {

	ERROR(2);

	int code;

	RedirectAttributesType(int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
