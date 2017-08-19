package com.focus3d.pano.wechat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.focustech.common.utils.JsonUtils;


/**
 * 微信OAuth2.0网页授权
 * @author hele
 *
 */
public class OAuthUtil {
	/**
	 * 网页授权
	 * @return
	 */
	public static void oauth(){
		String redirect = "";
		try{
			redirect = URLEncoder.encode(Constants.WXMP_OAUTH_REDIRECT, "utf-8");
		}catch(UnsupportedEncodingException e){	
			e.printStackTrace();
		}
		String uri = String.format(Constants.WXMP_OAUTH_URI, Constants.WXMP_APPID, redirect);
		//httpsRequest(uri, "GET");
		System.out.println("网页授权地址："+uri);
		StringBuffer buffer = new StringBuffer();
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			conn.connect();
			
			// 将返回的输入流转换成字符串
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            String result = buffer.toString();
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            //return buffer.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 重定向
	 * @param code
	 * @return
	 */
	public static Token redirect(String code){
		String uri = String.format(Constants.WXMP_OAUTH_ACCESS_TOKEN_URI, Constants.WXMP_APPID, Constants.WXMP_APPSECRET, code);
		//String json = httpsRequest(uri, "GET");
		System.out.println("重定向地址："+uri);
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			conn.connect();
			
			// 将返回的输入流转换成字符串
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            //return buffer.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Token token = JsonUtils.readValue(buffer.toString(), Token.class);
		System.out.println("REDIRECT Token >>> "+token.toString());
		return token;
	}
	
	/**
	 * 拉取用户信息
	 * @param accessToken
	 * @param openid
	 * @param lang
	 */
	public static UserInfo userinfo(String accessToken, String openid, String lang){
		String uri = String.format(Constants.WXMP_OAUTH_USERINFO, accessToken, openid, lang);
		System.out.println("拉取用户信息地址： "+uri);
		
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			conn.connect();
			
			// 将返回的输入流转换成字符串
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            //return buffer.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("UserInfo Result JSON >>> "+buffer.toString());
		UserInfo userInfo = JsonUtils.readValue(buffer.toString(), UserInfo.class);
		System.out.println("UserInfo >>> "+userInfo.toString());
		return userInfo;
	}
	
	private static String httpsRequest(String uri, String requestMethod){
		StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new OAuthUtil().new MyTrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(uri);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
	}
	
	class MyTrustManager implements X509TrustManager{

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * {
   "access_token":"ACCESS_TOKEN",
   "expires_in":7200,
   "refresh_token":"REFRESH_TOKEN",
   "openid":"OPENID",
   "scope":"SCOPE",
   "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
	}
	 */
	
	public class Token{
		private String access_token;
		private Integer expires_in;
		private String refresh_token;
		private String openid;
		private String scope;
		private String unionid;
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
}

