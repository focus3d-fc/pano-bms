package com.focus3d.pano.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

import com.focustech.common.utils.IPTool;
import com.focustech.common.utils.TCUtil;
/**
 * 防止过度刷新
 * *
 * @author lihaijun
 *
 */
public class AttackRefreashFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(AttackRefreashFilter.class);
	//黑名单缓存
	private Map<String, Map<String, Object>> blacklistCache = new ConcurrentHashMap<String, Map<String, Object>>();
	//url请求日志缓存
	private Map<String, Map<String, Object>> reqLogCache = new ConcurrentHashMap<String, Map<String, Object>>();
	//解锁黑名单线程池
	private ScheduledExecutorService cleanBlacklistPool = Executors.newScheduledThreadPool(1);
	//请求次数数组大小，用于分析是否恶意刷新
	private static final int REQUEST_ARY_LENGTH = 50000;
	//请求数组开始结束时间是小于限制值，如果符合就认为是恶意刷新
	private static final int REQUEST_ARY_TIME_LIMIT = 50000;//单位：秒
	private static final int REQUEST_BLACKLIST_RELEASE = 1 * 60;//单位：秒
	//private static
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String referer = request.getHeader("REFERER");
		String userAgent = request.getHeader("User-Agent");
		boolean isAttack = false;
		String ip = IPTool.getRealIp(request);
		StringBuffer requestURL = request.getRequestURL();
		boolean isStaticFileTag = (TCUtil.iv(request.getAttribute("staticTag")) == 1 || requestURL.toString().contains("favicon.ico"));
		if(!isStaticFileTag){
			log.info("referer:" + referer);
			log.info("requestURL:" + requestURL.toString());
		}
		long[] time = null;
		if(!blacklistCache.containsKey(ip)){
			if(!isStaticFileTag){
				log.info(ip);
				log.info(userAgent);
				if(!reqLogCache.containsKey(ip)){
					Map<String, Object> infoMap = new HashMap<String, Object>();
					time = new long[REQUEST_ARY_LENGTH];
					time[0] = (new Date()).getTime();
					infoMap.put("timeAry", time);
					reqLogCache.put(ip, infoMap);
				} else {
					Map<String, Object> infoMap = reqLogCache.get(ip);
					time = (long[])infoMap.get("timeAry");
					//数组已满，检查请求频率
					if (time[REQUEST_ARY_LENGTH - 1] != 0){
						log.info(ip + " 请求列表已满/" + REQUEST_ARY_LENGTH);
						//pop一个值
						for(int i = 0 ;i < REQUEST_ARY_LENGTH - 1; i ++){
							time[i] = time[ i + 1];
						}
						time[REQUEST_ARY_LENGTH -1] = (new Date()).getTime();
						Long span = time[REQUEST_ARY_LENGTH -1] - time[0];
						log.info("第" + (REQUEST_ARY_LENGTH -1) + "次和第1次时间间隔：" + span);
						//连续请求时间小于
						if(span < REQUEST_ARY_TIME_LIMIT * 1000){
							log.info("###########" + ip + "恶意攻击,加入黑名单###########");
							log.info("原因：【" + REQUEST_ARY_LENGTH + "】个请求在【" + REQUEST_ARY_TIME_LIMIT + "】秒内完成，访问频率大于了：" + (REQUEST_ARY_LENGTH / REQUEST_ARY_TIME_LIMIT) + "次/秒");
							blacklistCache.put(ip, infoMap);
							reqLogCache.remove(ip);
						}
					} else {
						//数组未满，加到数组底部
						int j = 0;
						while(time[j] != 0){
							j ++;
						}
						time[j] = (new Date()).getTime();
						log.info(ip + " 请求列表未满/" + REQUEST_ARY_LENGTH + ",time[" + j + "]=" + time[j]);
					}
				}

			}
		} else {
			isAttack = true;
			log.info(ip + " 已经存在黑名单中");
		}
		if(!isAttack){
			fc.doFilter(req, resp);
		} else {
			log.info("请求在日志过滤器中被拦截，响应返回。");
			time = null;
			response.setStatus(403);
			response.getWriter().print("403");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//清除黑名单
		cleanBlacklistPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if(!blacklistCache.isEmpty()){
					log.info("开始清除黑名单");
					for(Map.Entry<String, Map<String, Object>> m : blacklistCache.entrySet()){
						log.info("ip:" + m.getKey());
					}
					blacklistCache.clear();
				}
			}
		}, 1, REQUEST_BLACKLIST_RELEASE, TimeUnit.SECONDS);
	}

	@Override
	public void destroy() {

	}

}
