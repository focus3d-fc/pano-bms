package com.focus3d.pano.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.focus3d.pano.common.spring.RedirectAttributes;
import com.focustech.common.utils.TCUtil;
/**
 *
 * *
 * @author lihaijun
 *
 */
public class RequestMessageCookieFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain ch) throws ServletException, IOException {
		//取出cookie
		String cookieValue = "";
        int maxAge = -1;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(RequestMessageCookie.COOKIE_KEY)) {
                    cookieValue = cookie.getValue();
                    //maxAge = cookie.getMaxAge();
                    break;
                }
            }
        }
        RequestMessageCookie requestMessageCookie = RequestThreadLocal.getMessageCookie();
        requestMessageCookie.build(cookieValue);
        RequestMessageResponseWrapper requestMessageResponseWrapper = new RequestMessageResponseWrapper(response);
        
       	HttpSession session = request.getSession();
		Enumeration attributeNames = session.getAttributeNames();
		List<String> redirectAttributeNames = new ArrayList<String>();
    	while(attributeNames.hasMoreElements()){
    		String name = TCUtil.sv(attributeNames.nextElement());
    		if(name.contains(RedirectAttributes.MESSAGE) || name.contains(RedirectAttributes.MSG) || name.contains(RedirectAttributes.MESSAGE_TYPE)){
    			Object value = session.getAttribute(name);
    			request.setAttribute(name, value);
    			redirectAttributeNames.add(name);
    		}
    	}
    	if(!redirectAttributeNames.isEmpty()){
    		for(String name : redirectAttributeNames){
    			session.removeAttribute(name);
    		}
    		redirectAttributeNames.clear();
    	}
    	//
		ch.doFilter(request, requestMessageResponseWrapper);
		//写cookie
		if (!requestMessageResponseWrapper.isCommitted()) {
			requestMessageResponseWrapper.addCookie();
	    }
	}

	class RequestMessageResponseWrapper extends HttpServletResponseWrapper {

		public RequestMessageResponseWrapper(HttpServletResponse response) {
			super(response);
		}
		@Override
		public void sendRedirect(String location) throws IOException {
			addCookie();
			super.sendRedirect(location);
		}

		private void addCookie() {
			RequestMessageCookie requestMessageCookie = RequestThreadLocal.getMessageCookie();
			Cookie cookie = new Cookie(RequestMessageCookie.COOKIE_KEY, requestMessageCookie.getCookieValue());
			cookie.setPath("/");
			cookie.setMaxAge(-1);
			this.addCookie(cookie);
			RequestThreadLocal.cleanAll();
		}
	}
}


