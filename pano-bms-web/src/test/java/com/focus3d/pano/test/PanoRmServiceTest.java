package com.focus3d.pano.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import com.focus3d.pano.rm.AbstractRpcUtils;
/**
 * *
 * @author lihaijun
 *
 */
public class PanoRmServiceTest extends AbstractRpcUtils{
	@Test
	public void testAllocate() {
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("userToken", ""));
		qparams.add(new BasicNameValuePair("id", "6"));
		String httpRequest = httpRequest(getProtocal() + "/pano/prm/user_space_allocate", qparams, HttpMethod.POST);
		System.out.println(httpRequest);
	}
	
	//@Test
	public void testMakeScene() {
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("userToken", ""));
		qparams.add(new BasicNameValuePair("fileId", "bEUoAKyUgxsm"));
		String httpRequest = httpRequest(getProtocal() + "/pano/prm/make_scene", qparams, HttpMethod.POST);
		System.out.println(httpRequest);
	}

	@Override
	protected String getProtocal() {
		return URL_TEST;
	}
}
