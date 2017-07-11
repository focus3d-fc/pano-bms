package com.focus3d.pano.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

/**
 *
 * *
 * @author lihaijun
 *
 */
public class RpcUtils {
	private static final Logger log = LoggerFactory.getLogger(RpcUtils.class);
	/**
	 *
	 * *
	 * @param url
	 * @param qparams
	 * @return
	 */
	public static String httpRequest(String url, List<NameValuePair> qparams, HttpMethod httpMethod) {
		if(httpMethod.equals(HttpMethod.GET)){
			return getRequest(url, qparams);
		} else if(httpMethod.equals(HttpMethod.POST)){
			return postRequest(url, qparams);
		}
		throw new RuntimeException("请求不支持 " + httpMethod.name() + " 方法");
	}

	private static String postRequest(String url, List<NameValuePair> qparams) {
		log.info("======================================================");
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8000).setConnectTimeout(8000).build();
			HttpPost post = new HttpPost(url);
			post.setConfig(requestConfig);
			if(qparams != null && qparams.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(qparams, "utf-8");
				post.setEntity(entity);
			}
			//示例：提交用户名和密码
			log.info(post.getRequestLine().toString());
			HttpResponse resp = httpClient.execute(post);
			int statusCode = resp.getStatusLine().getStatusCode();
			log.info("status:" + statusCode);
			InputStream is = resp.getEntity().getContent();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int len = 0;
			byte[] byt = new byte[1024];
			while((len = is.read(byt)) != -1){
				outputStream.write(byt, 0, len);
			}
			String result = new String(outputStream.toByteArray(), "utf-8");
			log.info("result:" + result);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("无返回结果");
	}

	@SuppressWarnings("unused")
	private static String getRequest(String url, List<NameValuePair> qparams) {
		log.info("======================================================");
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
			if(qparams != null && qparams.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(qparams, "utf-8");
				url += ("?" + URLEncodedUtils.format(qparams, "utf-8"));
			}
			HttpGet get = new HttpGet(url);
			get.setConfig(requestConfig);
			//示例：提交用户名和密码
			log.info(get.getRequestLine().toString());
			HttpResponse resp = httpClient.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			log.info("status:" + statusCode);
			InputStream is = resp.getEntity().getContent();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int len = 0;
			byte[] byt = new byte[1024];
			while((len = is.read(byt)) != -1){
				outputStream.write(byt, 0, len);
			}
			String result = new String(outputStream.toByteArray(), "utf-8");
			log.info("result:" + result);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("无返回结果");
	}
}
