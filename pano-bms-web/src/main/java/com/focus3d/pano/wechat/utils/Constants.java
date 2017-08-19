package com.focus3d.pano.wechat.utils;

/**
 * 该类用于定义全局变量
 * @author hele
 *
 */
public class Constants {
	
	private Constants(){}
	
	/**
	 * 定义数字变量
	 */
	public static final int CODE_0 = 0;
	public static final int CODE_1 = 1;
	public static final int CODE_2 = 2;
	public static final int CODE_3 = 3;
	public static final int CODE_4 = 4;
	public static final int CODE_5 = 5;
	public static final int CODE_6 = 6;
	public static final int CODE_7 = 7;
	public static final int CODE_8 = 8;
	public static final int CODE_9 = 9;
	/**
	 * 定义字符串型数字变量
	 */
	public static final String CODE_STR_0 = "0";
	public static final String CODE_STR_1 = "1";
	public static final String CODE_STR_2 = "2";
	public static final String CODE_STR_3 = "3";
	public static final String CODE_STR_4 = "4";
	public static final String CODE_STR_5 = "5";
	public static final String CODE_STR_6 = "6";
	public static final String CODE_STR_7 = "7";
	public static final String CODE_STR_8 = "8";
	public static final String CODE_STR_9 = "9";
	/**
	 * 定义常用字符
	 */
	public static final String OFTEN_CHAR_0 = "_";//下划线
	public static final String OFTEN_CHAR_1 = "&";//&(对于asc为%26)
	public static final String OFTEN_CHAR_2 = "?";//?(对于asc为%3F)
	/**
	 * 定义HTTP请求类型常量
	 */
	public static final String HTTP_REQ_METHOD_GET = "GET";
	public static final String HTTP_REQ_METHOD_POST = "POST";
	/**
	 * 系统默认平台营销中心ID
	 */
	public static final String SYS_DEFAULT_BUILD_ID = "4028470d58000000000000000000000";
	/**
	 * 用户角色ID
	 */
	public static final int USER_ROLE_ADMINSTROTOR = 1;//超级管理员
	public static final int USER_ROLE_LEADER = 2;//总经理/负责人
	public static final int USER_ROLE_MANAGER = 3;//主管
	public static final int USER_ROLE_STAFF = 4;//职员
	/**
	 * SESSION KEY
	 */
	public static final String SESSION_CODE = "code";//验证码
	public static final String SESSION_USER = "cur_user";//当前PC登录用户
	public static final String SESSION_USER_MOBILE = "cur_user_mob";//当前移动端登录用户(微信端)
	public static final String SESSION_WX_USER = "cur_user_wx";//当前微信用户

	/**
	 * 微信公众平台配置
	 */
	public static final String WXMP_OAUTH_URI = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	public static final String WXMP_OAUTH_REDIRECT = "http://gwzj.joy-homeplus.com/wechat/redirect";
	public static final String WXMP_OAUTH_ACCESS_TOKEN_URI = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	public static final String WXMP_APPID = "wxed31115f33aab720";
	public static final String WXMP_APPSECRET = "a13e8439de93ec618e98f5a3d5b7b758";
	public static final String WXMP_OAUTH_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";
	public static final String WXMP_OAUTH_USERINFO_LANG = "zh_CN";//国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	
	public static final String WXMP_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	public static final String WXMP_MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
	public static final String WXMP_MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	
}
