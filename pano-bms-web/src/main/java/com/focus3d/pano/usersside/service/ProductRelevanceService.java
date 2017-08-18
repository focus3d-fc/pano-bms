package com.focus3d.pano.usersside.service;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.ProductRelevance;

public interface ProductRelevanceService {

	// 查询数量
	public int selProCount(Long PACKAGETYPE_SN);

	// 查询信息
	public List<ProductRelevance> selPro(Map map);
}
