package com.focus3d.pano.usersside.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.usersside.dao.ProductRelevanceDAO;
import com.focus3d.pano.usersside.service.ProductRelevanceService;

@Service("productRelevanceService")
public class ProductRelevanceServiceImpl implements ProductRelevanceService {

	@Autowired
	private ProductRelevanceDAO productRelevanceDAO;

	@Override
	public int selProCount(Long PACKAGETYPE_SN) {
		// TODO Auto-generated method stub
		return productRelevanceDAO.selProCount(PACKAGETYPE_SN);
	}

	@Override
	public List<ProductRelevance> selPro(Map map) {
		// TODO Auto-generated method stub
		return productRelevanceDAO.selPro(map);
	}

	@Override
	public List<ProductRelevance> selProbySN(Long PRODUCT_SN) {
		// TODO Auto-generated method stub
		return productRelevanceDAO.selProbySN(PRODUCT_SN);
	}

	@Override
	public List<ProductRelevance> selImgbySN(Long PRODUCT_SN) {
		// TODO Auto-generated method stub
		return productRelevanceDAO.selImgbySN(PRODUCT_SN);
	}

}
