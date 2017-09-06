package com.focus3d.pano.index.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.focus3d.pano.admin.service.OrderService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.OrderAdmin;
import com.focus3d.pano.model.pano_project;

/**
 * 
 * 订单管理
 * 
 * @author 熊峰
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	/**
	 * 进入订单管理
	 */
	@RequestMapping("/toOrder")
	public String toOrder(String page,HttpServletResponse response,ModelMap map) {
		// 总记录数
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		List<OrderAdmin> OrderAdmin = null;
		int upPage = 0;
		int nextPage = 0;

		// 判断当前页
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage == 1) {
			upPage = 1;
			nextPage = 2;
		}

		// 获取查询总记录数
		count = orderService.selOrderCount();

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new Page(count, currentPage);

		// 拼接分页语句
		OrderAdmin = orderService.selOrder(pages);
		map.put("orderList", OrderAdmin);
		map.put("pages", pages);
		int totalPages = pages.getTotalPages();

		if (currentPage == totalPages) {
			upPage = currentPage - 1;
			nextPage = totalPages;
		} else if (currentPage > 1) {
			upPage = currentPage - 1;
			nextPage = currentPage + 1;
		}

		map.put("upPage", upPage);
		map.put("nextPage", nextPage);
		int index = (currentPage - 1) * pages.getPagesize();
		map.put("index", index);
		map.put("currentPage", currentPage);

		List<pano_project> houseList = orderService.selHouse();
		map.put("houseList", houseList);
		
		return "/order/order";
	}

	/**
	 * 订单管理-查看
	 */
	@RequestMapping("/toorder-details")
	public String toorder_details(ModelMap map,String ORDER_SN) {
		Long order_sn = Long.parseLong(ORDER_SN);
		List<OrderAdmin> orderList = orderService.selOrderbySN(order_sn);
		map.put("orderList", orderList.get(0));
		return "/order/order-details";
	}

	/**
	 * 订单管理-搜索
	 */
	@RequestMapping("/selOrder")
	public String selOrder(String PROJECT_SN, String NICK_NAME,String ORDER_TIME,String page,ModelMap result) {
	   HashMap<String,Object> map = new HashMap<String,Object>();
		if (!ORDER_TIME.equals("日期")) {
			map.put("ORDER_TIME",ORDER_TIME);
		}
		if (!PROJECT_SN.equals("楼盘名称")) {
			map.put("PROJECT_SN",PROJECT_SN);
		}
		map.put("NICK_NAME",NICK_NAME);
		
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		int upPage = 0;
		int nextPage = 0;

		// 判断当前页
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if (currentPage == 1) {
			upPage = 1;
			nextPage = 2;
		}

		// 获取查询总记录数
		count = orderService.selOrderCount();

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new Page(count, currentPage);
		map.put("startIndex", pages.getStartIndex());
		map.put("pagesize", pages.getPagesize());
		List<OrderAdmin> orderList = orderService.selOrderbyAll(map);
		result.put("orderList", orderList);
		result.put("pages", pages);

		List<pano_project> houseList = orderService.selHouse();
		result.put("houseList", houseList);

		return "/order/order";
	}
}
