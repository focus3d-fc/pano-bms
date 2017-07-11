package com.focus3d.pano.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
/**
 * 访问控制过滤器
 * *
 * @author lihaijun
 *
 */
public class VisitLimitFilter implements Filter {
	private final Logger log = LoggerFactory.getLogger(VisitLimitFilter.class);
	//静态文件目录
	private static String[] STATIC_FILE = new String[]{"css", "style", "images", "fonts", "script", "js", "product", "krp", "component"};
	
	@Value("${pano.domain}")
	private String panoDomain;
	@Value("${pano.source.code.protect}")
	private boolean codeProtected;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String url = req.getRequestURI();
		boolean isLimitVisitUrl = validateStaticResource(url, req);;
		if(!isLimitVisitUrl){
			//返回默认资源
			resp.setStatus(403);
			return;
		}
		String method = req.getMethod();
		//StringBuffer requestURL = req.getRequestURL();
		String fromPage = req.getHeader("referer");
		//ajax 跨域
		if(fromPage != null){
			if(
					fromPage.toString().startsWith("http://app-wx.3d-focus.com")
					){
				resp.setHeader("Access-Control-Allow-Origin", "*");
				resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
				resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
				if("OPTIONS".equals(method)){
					log.info("response options stauts set 200");
					resp.setStatus(200);
					return;
				}
			}
		}
		request.setAttribute("panoDomain", panoDomain);
		fc.doFilter(req, resp);
	}
	
	/**
	 * 是否是静态资源url
	 * *
	 * @param url
	 * @return
	 */
	public boolean validateStaticResource(String url, HttpServletRequest request){
		if(url.endsWith("map.html") || url.endsWith("tour.html") || url.endsWith("tour_editor.html")){
			return codeProtected;
		}
		boolean flag = true;
		int type = 0;
		url = url.toLowerCase();
		for(String dir : STATIC_FILE){
			if(url.startsWith("/" + dir)){
				Pattern pattern = Pattern.compile("^/" + dir + "(/?([a-zA-Z]|[0-9]|[-]|[_]|[.])+)+");
				Matcher matcher = pattern.matcher(url);
				flag = matcher.matches();
				type = 1;
				break;
			}
		}
		request.setAttribute("resourceType", type);
		return flag;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {

	}
}
