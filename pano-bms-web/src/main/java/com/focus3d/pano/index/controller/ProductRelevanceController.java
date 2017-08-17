package com.focus3d.pano.index.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.utils.PagePRO;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.usersside.service.ProductRelevanceService;

@Controller
@RequestMapping("/pro")
public class ProductRelevanceController extends BaseController {

	@Autowired
	private ProductRelevanceService productRelevanceService;

	@RequestMapping("/topro")
	public String tohouse(HttpServletRequest request) {
		String page = request.getParameter("page");

		// 总记录数
		int count = 0;
		int currentPage = 0;
		PagePRO pages = null;

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
		Long PACKAGETYPE_SN = (long) 1;
		count = productRelevanceService.selProCount(PACKAGETYPE_SN);

		// 通过Page这个类可以获取分页的起始下标和条数
		pages = new PagePRO(count, currentPage);

		// 拼接分页语句
		Map map = new HashMap();
		map.put("PACKAGETYPE_SN", PACKAGETYPE_SN);
		map.put("startIndex", pages.getStartIndex());
		map.put("pagesize", pages.getPagesize());

		List<ProductRelevance> proList = productRelevanceService.selPro(map);

		request.setAttribute("proList", proList);
		request.setAttribute("pages", pages);
		int totalPages = pages.getTotalPages();

		if (currentPage == totalPages) {
			upPage = currentPage - 1;
			nextPage = totalPages;
		} else if (currentPage > 1) {
			upPage = currentPage - 1;
			nextPage = currentPage + 1;
		}

		request.setAttribute("upPage", upPage);
		request.setAttribute("nextPage", nextPage);
		int index = (currentPage - 1) * pages.getPagesize();
		request.setAttribute("index", index);
		request.setAttribute("currentPage", currentPage);

		return "/userside/pro";
	}

}
