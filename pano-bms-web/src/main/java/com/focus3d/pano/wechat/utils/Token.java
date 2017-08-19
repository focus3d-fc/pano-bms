package com.focus3d.pano.wechat.utils;

/** {
"openid":" OPENID",
" nickname": NICKNAME,
"sex":"1",
"province":"PROVINCE"
"city":"CITY",
"country":"COUNTRY",
 "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46", 
	"privilege":[
	"PRIVILEGE1"
	"PRIVILEGE2"
 ],
 "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
} **/

public class Token {
	public String access_token;
	public Integer expires_in;
	public String refresh_token;
	public String openid;
	public String scope;
	private String unionid;
	
	public Token(){};
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("access_token : ");
		buffer.append(this.access_token);
		buffer.append(" | refresh_token : ");
		buffer.append(this.refresh_token);
		buffer.append(" | openid : ");
		buffer.append(this.openid);
		buffer.append(" | expires_in : ");
		buffer.append(this.expires_in);
		buffer.append(" | scope : ");
		buffer.append(this.scope);
		buffer.append(" | unionid : ");
		buffer.append(this.unionid);
		return buffer.toString();
	}
}
