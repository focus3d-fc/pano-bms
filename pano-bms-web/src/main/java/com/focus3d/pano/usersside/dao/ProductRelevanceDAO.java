package com.focus3d.pano.usersside.dao;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.ProductRelevance;

public interface ProductRelevanceDAO {

	// 查询数量
	public int selProCount(Long PACKAGETYPE_SN);

	// 查询信息
	public List<ProductRelevance> selPro(Map map);

	// 根据SN查产品
	public List<ProductRelevance> selProbySN(Long PRODUCT_SN);

	// 查询产品图片
	public List<ProductRelevance> selImgbySN(Long PRODUCT_SN);
}
