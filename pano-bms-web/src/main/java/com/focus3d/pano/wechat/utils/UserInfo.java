package com.focus3d.pano.wechat.utils;

public class UserInfo{
		
		private String openid;
		private String nickname;
		private String sex;
		private String province;
		private String city;
		private String country;
		private String headimgurl;
		private String [] privilege;
		private String unionid;
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getSex() {
			return sex;//sex=="1"?"男":sex=="2"?"女":"未知";
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getHeadimgurl() {
			return headimgurl;
		}
		public void setHeadimgurl(String headimgurl) {
			this.headimgurl = headimgurl;
		}
		public String[] getPrivilege() {
			return privilege;
		}
		public void setPrivilege(String[] privilege) {
			this.privilege = privilege;
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
			buffer.append("openid : ");
			buffer.append(this.openid);
			buffer.append(" | nickname : ");
			buffer.append(this.nickname);
			buffer.append(" | sex : ");
			buffer.append(this.sex);
			buffer.append(" | province : ");
			buffer.append(this.province);
			buffer.append(" | city : ");
			buffer.append(this.city);
			buffer.append(" | country : ");
			buffer.append(this.country);
			buffer.append(" | headimgurl : ");
			buffer.append(this.headimgurl);
			buffer.append(" | privilege : ");
			buffer.append(this.privilege);
			buffer.append(" | unionid : ");
			buffer.append(this.unionid);
			return buffer.toString();
		}
}
