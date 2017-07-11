package com.focus3d.pano.constant;
/**
 *
 * *
 * @author lihaijun
 *
 */
public enum SmsSendTypeEnum {
	USER_LOGIN(5, "用户登录"),
	USER_REGISTER(6, "用户注册"),
	USER_PASSWORD_MODIFY(7, "用户修改密码"),
	USER_REGISTER_FEEDBACK(8, "用户注册反馈信息");

	private int type;
	private String name;

	private SmsSendTypeEnum(int type, String name){
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * *
	 * @param type
	 * @return
	 */
	public static SmsSendTypeEnum valueOf(int type){
		for(SmsSendTypeEnum t : SmsSendTypeEnum.values()){
			if(t.getType() == type){
				return t;
			}
		}
		return null;
	}

	public boolean equals(SmsSendTypeEnum sendType){
		boolean flag = false;
		if(sendType != null){
			flag = sendType.getType() == this.getType();
		}
		return flag;
	}
}
