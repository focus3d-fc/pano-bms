package com.focus3d.pano.wechat.controller;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.usersside.service.PersonalService;
import com.focus3d.pano.usersside.service.UsersSideService;
import com.focus3d.pano.wechat.service.WeChatPayService;
import com.focus3d.pano.wechat.utils.Constants;
import com.focus3d.pano.wechat.utils.UserInfo;
import com.focus3d.pano.wechat.utils.WeChatConfig;
import com.focus3d.pano.wechat.utils.WxPayUtil;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/wechat")
public class WeChatPayController extends BaseController {

	@Autowired
	WeChatConfig wx;
	@Resource
	private UsersSideService usersSideService;

	@Autowired
	private PersonalService personalService;

	@RequestMapping("/testPay")
	public void pay(String price_all_pay, String house_pack_strs,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		String msg = "nologin";

		try {

			UserInfo userInfo = (UserInfo) session
					.getAttribute(Constants.SESSION_WX_USER);
			// 如果已经微信登录
			if (userInfo != null) {

				List<String> house_pack_snList_str = Arrays
						.asList(house_pack_strs.split("/"));
				List<Long> house_pack_snList_long = new ArrayList<Long>();
				for (int i = 1; i < house_pack_snList_str.size(); i++) {
					house_pack_snList_long.add(Long
							.parseLong(house_pack_snList_str.get(i)));
				}
				// 查询订单信息
				long house_pack_sn = 0;
				// 单个订单对象
				List<pano_order> order_List_only = new ArrayList<pano_order>();
				// 多个订单对象-集合
				List<pano_order> order_List = new ArrayList<pano_order>();

				for (int i = 0; i < house_pack_snList_long.size(); i++) {
					house_pack_sn = house_pack_snList_long.get(i);
					// 根据house_pack_sn查询订单信息
					order_List_only = usersSideService
							.get_selectOrderByHouse_Pack_Sn(house_pack_sn);
					if (order_List_only.size() > 0) {
						// 把 单个订单对象 加入 多个订单对象-集合
						order_List.add(order_List_only.get(0));
					}
				}
				String All_order_num = "ALL";
				StringBuffer builder = new StringBuffer(All_order_num);
				for (int i = 0; i < 10; i++) {
					int x = (int) (Math.random() * 10);
					builder.append(x);
				}
				// 获取StringBuilder内部修改好的字符串
				String All_order_name = "合并订单名";// 合并订单名
				All_order_num = builder.toString();// 合并订单号
				BigDecimal price_all_pay_big = new BigDecimal(price_all_pay);
				BigDecimal number = new BigDecimal("100");
				BigDecimal price_minute_big = price_all_pay_big
						.multiply(number);
				String price_minute = price_minute_big + "";// 总价（分）

				String IpAddress = this.getIpAddr(request);// ip地址

				WeChatPayService wp = new WeChatPayService(wx);
				HashMap<String, String> data = new HashMap<String, String>();

				data.put("body", All_order_name); // 订单信息(订单名称)
				data.put("out_trade_no", All_order_num);// 订单编号
				data.put("device_info", "1");
				data.put("fee_type", "CNY");
				data.put("total_fee", price_minute); // 订单金， 这里单位是分 记得转换 *100
				data.put("spbill_create_ip", IpAddress); // 获取ip地址填入
				data.put("notify_url",
						"http://gwzj.joy-homeplus.com/wechat/testNotify");
				data.put("trade_type", "JSAPI");
				// 这里等上线部署就可以获得微信openid,才不会报错
				data.put("openid", userInfo.getOpenid());

				Map<String, String> r = wp.unifiedOrder(data);

				if ("SUCCESS".equals(r.get("result_code"))) {
					// 二次签名
					// SortedMap<Object, Object> paySingMap = new
					// TreeMap<Object, Object>();
					// paySingMap.put("appId", wx.getAppId());
					// paySingMap.put("noncestr", WxPayUtil.generateNonceStr());
					// paySingMap.put("package",
					// "prepay_id="+r.get("prepay_id"));
					// paySingMap.put("timeStamp", new
					// Date().getTime()/1000+"");
					// paySingMap.put("signType", "MD5");
					//
					// String pay_sing = WxPayUtil.createSign("utf-8",
					// paySingMap, wx.getMchKey());

					Map<String, String> payParam = new TreeMap<String, String>();
					payParam.put("appId", wx.getAppId());
					payParam.put("nonceStr", WxPayUtil.generateNonceStr());
					payParam.put("package", "prepay_id=" + r.get("prepay_id"));
					payParam.put("signType", "MD5");
					payParam.put("timeStamp", new Date().getTime() / 1000 + "");
					String secondSign = WxPayUtil.generateSignature(payParam,
							wx.getMchKey());

					payParam.put("paySign", secondSign);

					request.setAttribute("result", payParam);
					session.setAttribute("order_List_chindren", order_List);
					session.setAttribute("All_order_num", All_order_num);

				}
				msg = "yeslogin";
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		String jsonProject = JsonUtils.objectToJson(msg);
		this.ajaxOutput(response, jsonProject);
		// return "/wechat/pay";

	}

	@RequestMapping("/perPay")
	public String perPay(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		String msg = "nologin";
		WeChatPayService wp = new WeChatPayService(wx);

		try {

			UserInfo userInfo = (UserInfo) session
					.getAttribute(Constants.SESSION_WX_USER);
			if (userInfo != null) {
				Long ORDER_SN = Long
						.parseLong(request.getParameter("ORDER_SN"));

				List<pano_order> order = personalService
						.selOrderbyOrderSN(ORDER_SN);
				session.setAttribute("order", order.get(0));

				String ORDER_NUM = order.get(0).getORDER_NUM();

				BigDecimal number = new BigDecimal("100");
				BigDecimal price = order.get(0).getTOTAL_PRICE()
						.multiply(number);
				String ORDER_PRICE = price.stripTrailingZeros().toPlainString();

				String IpAddress = this.getIpAddr(request);

				HashMap<String, String> data = new HashMap<String, String>();

				data.put("body", ORDER_NUM); // 订单信息
				data.put("out_trade_no", ORDER_NUM + new Date().getTime()); // 订单编号
				data.put("device_info", "1");
				data.put("fee_type", "CNY");
				data.put("total_fee", ORDER_PRICE); // 订单金，
				// 这里单位是分
				// 记得转换
				// *100
				data.put("spbill_create_ip", IpAddress); // 获取ip地址填入
				data.put("notify_url",
						"http://gwzj.joy-homeplus.com/wechat/testNotify");
				data.put("trade_type", "JSAPI");
				data.put("openid", userInfo.getOpenid());

				Map<String, String> r = wp.unifiedOrder(data);

				if ("SUCCESS".equals(r.get("result_code"))) {
					// 二次签名
					// SortedMap<Object, Object> paySingMap = new
					// TreeMap<Object,
					// Object>();
					// paySingMap.put("appId", wx.getAppId());
					// paySingMap.put("noncestr", WxPayUtil.generateNonceStr());
					// paySingMap.put("package",
					// "prepay_id="+r.get("prepay_id"));
					// paySingMap.put("timeStamp", new
					// Date().getTime()/1000+"");
					// paySingMap.put("signType", "MD5");
					//
					// String pay_sing = WxPayUtil.createSign("utf-8",
					// paySingMap,
					// wx.getMchKey());

					Map<String, String> payParam = new TreeMap<String, String>();
					payParam.put("appId", wx.getAppId());
					payParam.put("nonceStr", WxPayUtil.generateNonceStr());
					payParam.put("package", "prepay_id=" + r.get("prepay_id"));
					payParam.put("signType", "MD5");
					payParam.put("timeStamp", new Date().getTime() / 1000 + "");
					String secondSign = WxPayUtil.generateSignature(payParam,
							wx.getMchKey());

					payParam.put("paySign", secondSign);

					request.setAttribute("result", payParam);

				}
				msg = "yeslogin";

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		String jsonProject = JsonUtils.objectToJson(msg);
		this.ajaxOutput(response, jsonProject);

		return "/wechat/pay2";

	}

	@ResponseBody
	@RequestMapping("/testNotify")
	public String notify(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return new Date().getTime() + "";
	}

	@RequestMapping("/getIpAddr")
	public String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
