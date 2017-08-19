package com.focus3d.pano.wechat.utils;

import java.io.IOException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WxX509zz implements X509HostnameVerifier {

	@Override
	public boolean verify(String hostname, SSLSession session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verify(String arg0, SSLSocket arg1) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void verify(String arg0, X509Certificate arg1) throws SSLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void verify(String arg0, String[] arg1, String[] arg2)
			throws SSLException {
		// TODO Auto-generated method stub

	}

}
